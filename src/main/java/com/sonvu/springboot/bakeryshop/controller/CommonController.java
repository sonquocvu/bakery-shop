package com.sonvu.springboot.bakeryshop.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sonvu.springboot.bakeryshop.DAO.CategoryDAO;
import com.sonvu.springboot.bakeryshop.DAO.FoodDAO;
import com.sonvu.springboot.bakeryshop.service.CategoryService;
import com.sonvu.springboot.bakeryshop.service.FoodService;

@RequestMapping("/common")
@RestController
public class CommonController {

	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "/home")
	public ResponseEntity<Map<String, List<FoodDAO>>> home()
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		Map<String, List<FoodDAO>> foodMap = foodService.getCakesForHomePage();
		return new ResponseEntity<>(foodMap, HttpStatus.OK);
	}
	
	@GetMapping(value = "/category")
	public ResponseEntity<List<CategoryDAO>> category()
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		List<CategoryDAO> categories = categoryService.getAllCategoriesWithFoodQuantity();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@GetMapping(value = "/category/product")
	public ResponseEntity<List<FoodDAO>> products(@RequestParam("category") String category)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		logger.info("The category name is: {}", category);
		
		List<FoodDAO> foodList = foodService.getFoodsByCategoryName(category);
		return new ResponseEntity<>(foodList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/products-name")
	public ResponseEntity<List<String>> productsName(@RequestParam("categoryName") String categoryName)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		logger.info("The category name is: {}", categoryName);
		List<String> foodNameList = foodService.getFoodsNameByCategoryName(categoryName);
		return new ResponseEntity<>(foodNameList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<FoodDAO>> paginationProducts(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "160") int size)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		List<FoodDAO> foodList = foodService.getFoodsForPagination(page, size);
		return new ResponseEntity<>(foodList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/single/product")
	public ResponseEntity<FoodDAO> singleProduct(
			@RequestParam String category,
			@RequestParam Long productId)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		FoodDAO singleProduct = foodService.getFoodById(productId);
		return new ResponseEntity<>(singleProduct, HttpStatus.OK);
	}
	
	private String getClassName()
	{
		return "CommonController";
	}
	
	private String getMethodName()
	{
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[2].getMethodName();
	}
}
