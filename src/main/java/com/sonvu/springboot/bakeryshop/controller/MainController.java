package com.sonvu.springboot.bakeryshop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sonvu.springboot.bakeryshop.entity.Category;
import com.sonvu.springboot.bakeryshop.entity.Profile;
import com.sonvu.springboot.bakeryshop.entity.Recipe;
import com.sonvu.springboot.bakeryshop.entity.Tag;
import com.sonvu.springboot.bakeryshop.service.CategoryService;
import com.sonvu.springboot.bakeryshop.service.ProfileService;
import com.sonvu.springboot.bakeryshop.service.RecipeService;
import com.sonvu.springboot.bakeryshop.service.TagService;

import jakarta.servlet.http.HttpSession;

@Controller
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

	@GetMapping("/")
	public String homePage(HttpSession session)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		initHomePage(session);
		
		return "home_page";
	}
	
	private void initHomePage(HttpSession session)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		List<Category> categories = categoryService.getAllCategories();
		session.setAttribute("allCategories", categories);
		
		List<Recipe> top3ViewRecipes = recipeService.getTopViewRecipes(3);
		session.setAttribute("top3ViewRecipes", top3ViewRecipes);
		
		List<Recipe> top5LikeRecipes = recipeService.getTopLikeRecipes(5);
		session.setAttribute("top5LikeRecipes", top5LikeRecipes);
		
		List<Recipe> top10ModifiedRecipes = recipeService.getTopModifiedRecipes(10);
		session.setAttribute("topLastModifiedRecipes", top10ModifiedRecipes);
		
		List<Tag> top10Tags = tagService.getTopTags(10);
		session.setAttribute("top10Tags", top10Tags);
		
		List<Profile> top5FollowedProfiles = profileSerivce.getTopFollowedProfiles(5);
		session.setAttribute("top5FollowedProfiles", top5FollowedProfiles);
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
