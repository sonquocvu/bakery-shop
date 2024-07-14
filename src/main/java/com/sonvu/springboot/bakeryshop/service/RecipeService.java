package com.sonvu.springboot.bakeryshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sonvu.springboot.bakeryshop.entity.Recipe;
import com.sonvu.springboot.bakeryshop.repository.RecipeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;
	
	public List<Recipe> getAllRecipes()
	{
		return recipeRepository.findAllRecipes();
	}
	
	public List<Recipe> getTopViewRecipes(int numOfRecipes)
	{
		Pageable pageable = PageRequest.of(0, numOfRecipes);
		
		return recipeRepository.findTopViewRecipes(pageable);
	}
	
	public List<Recipe> getTopLikeRecipes(int numOfRecipes)
	{
		Pageable pageable = PageRequest.of(0, numOfRecipes);
		
		return recipeRepository.findTopLikeRecipes(pageable);
	}
	
	public List<Recipe> getTopModifiedRecipes(int numOfRecipes)
	{
		Pageable pageable = PageRequest.of(0, numOfRecipes);
		
		return recipeRepository.findTopModifiedRecipes(pageable);
	}
}
