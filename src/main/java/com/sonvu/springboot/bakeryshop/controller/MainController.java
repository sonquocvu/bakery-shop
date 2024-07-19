package com.sonvu.springboot.bakeryshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sonvu.springboot.bakeryshop.service.CategoryService;
import com.sonvu.springboot.bakeryshop.service.ProfileService;
import com.sonvu.springboot.bakeryshop.service.RecipeService;
import com.sonvu.springboot.bakeryshop.service.TagService;

@RestController
public class MainController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private ProfileService profileSerivce;
	
	Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/")
	public ModelAndView homePage()
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView LoginPage()
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	private String getClassName()
	{
		return "MainController";
	}
	
	private String getMethodName()
	{
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[2].getMethodName();
	}
}
