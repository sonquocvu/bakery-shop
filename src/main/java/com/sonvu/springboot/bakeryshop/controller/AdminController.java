package com.sonvu.springboot.bakeryshop.controller;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sonvu.springboot.bakeryshop.entity.Category;
import com.sonvu.springboot.bakeryshop.entity.Food;
import com.sonvu.springboot.bakeryshop.entity.Image;
import com.sonvu.springboot.bakeryshop.entity.User;
import com.sonvu.springboot.bakeryshop.service.AdminService;
import com.sonvu.springboot.bakeryshop.service.CategoryService;
import com.sonvu.springboot.bakeryshop.service.FoodService;
import com.sonvu.springboot.bakeryshop.service.ImageService;
import com.sonvu.springboot.bakeryshop.service.UserService;

@RequestMapping("/admin")
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ImageService imageService;
	
	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@PostMapping("/add-product")
	public ResponseEntity<?> addNewProduct(
			@RequestParam("productName") String productName,
			@RequestParam("description") String description,
			@RequestParam("price") int price,
			@RequestParam("category") String categoryName,
			@RequestParam("userId") String userId,
			@RequestParam("images") List<MultipartFile> images)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		logger.info("The userId: {} - The category: {} - The product name: {} - The description: {} - The price: {}", 
				userId, categoryName, productName, description, price);
		
		images.forEach(image -> {
			logger.info("Image name: {}", image.getOriginalFilename());
		});
	
		try 
		{
			String accessToken = adminService.getAccessToken();
			logger.info("The access token got from IMGUR: {}", accessToken);
			
			User user = userService.getUserById(Long.valueOf(userId));
			Category category = categoryService.getCategoryByName(categoryName);
			
			Food newFood = new Food();
			newFood.setName(productName);
			newFood.setDescription(description);
			newFood.setPrice(price);
			newFood.setCreatedAt(LocalDateTime.now());
			newFood.setLastModified(LocalDateTime.now());
			newFood.setCategory(category);
			newFood.setUser(user);
			
			Set<Image> newImages = new HashSet<>();
			for (int i=0; i< images.size(); i++)
			{
				String imageUrl = adminService.uploadImage(images.get(i));
				Image image = new Image();
				image.setCreatedAt(LocalDateTime.now());
				image.setImageUrl(imageUrl);
				image.setFood(newFood);
				newImages.add(image);
				logger.info("The uploaded imageUrl: {}", imageUrl);
			}
			
			newFood.setImages(newImages);
			foodService.saveFood(newFood);
			
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch (Exception e)
		{
			logger.info("{}:{} {}", getClassName(), getMethodName(), e.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}
	
	@DeleteMapping("/delete-product")
	public ResponseEntity<Void> deleteProductByName(@RequestParam String productName)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		logger.info("The product name: {}", productName);
		
		try
		{
			imageService.deleteImageByFoodName(productName);
			foodService.deleteFoodByName(productName);
			return ResponseEntity.noContent().build();
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	private String getClassName()
	{
		return "AdminController";
	}
	
	private String getMethodName()
	{
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[2].getMethodName();
	}
}
