package com.sonvu.springboot.bakeryshop.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sonvu.springboot.bakeryshop.DAO.FoodDAO;
import com.sonvu.springboot.bakeryshop.entity.Food;
import com.sonvu.springboot.bakeryshop.entity.Image;
import com.sonvu.springboot.bakeryshop.repository.FoodRepository;

import io.jsonwebtoken.lang.Arrays;
import jakarta.transaction.Transactional;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepository foodRepository;
	
	public Map<String, List<FoodDAO>> getAllFoods()
	{
		Map<String, List<FoodDAO>> foodMap = new HashMap<>();
		
		List<Food> foods = foodRepository.findAllFoodsWithAllRelations();
		for (Food food : foods)
		{
			FoodDAO foodDAO = new FoodDAO();
			String categoryName = food.getCategory().getName();
			foodDAO.setId(food.getId());
			foodDAO.setName(food.getName());
			foodDAO.setDescription(food.getDescription());
			foodDAO.setPrice(String.valueOf(formatPrice(food.getPrice())));
			foodDAO.setChef(food.getUser().getFullName());
			foodDAO.setCategory(categoryName);
			for (Image image : food.getImages())
			{
				foodDAO.getImageUrls().add(image.getImageUrl());
			}
						
			if (foodMap.containsKey(categoryName))
			{
				foodMap.get(categoryName).add(foodDAO);
			}
			else
			{
				List<FoodDAO> foodList = new ArrayList<>();
				foodList.add(foodDAO);
				foodMap.put(categoryName, foodList);
			}
		}
		
		return foodMap;
	}
	
	public List<FoodDAO> getFoodsForPagination(int page, int size)
	{
		List<FoodDAO> foodList = new ArrayList<>();
		
		Pageable pageable = PageRequest.of(page, size);
		List<Food> foods = foodRepository.findFoodsByPagination(pageable);
		for (Food food : foods)
		{
			FoodDAO foodDAO = new FoodDAO();
			String categoryName = food.getCategory().getName();
			foodDAO.setId(food.getId());
			foodDAO.setName(food.getName());
			foodDAO.setDescription(food.getDescription());
			foodDAO.setPrice(String.valueOf(formatPrice(food.getPrice())));
			foodDAO.setChef(food.getUser().getFullName());
			foodDAO.setCategory(categoryName);
			for (Image image : food.getImages())
			{
				foodDAO.getImageUrls().add(image.getImageUrl());
			}		
			
			foodList.add(foodDAO);
		}
		
		return foodList;
	}
	
	public Map<String, List<FoodDAO>> getCakesForHomePage()
	{
		Map<String, List<FoodDAO>> foodMap = new HashMap<>();
		
		List<Object[]> foods = foodRepository.findFoodsInLimitWithRelations();
		for (Object[] food : foods)
		{
			FoodDAO foodDAO = new FoodDAO();
			String categoryName = (String) food[5];
			String imageUrls = (String) food[6];
			foodDAO.setId((Long) food[0]);
			foodDAO.setName((String) food[1]);
			foodDAO.setDescription((String) food[2]);
			foodDAO.setPrice(formatPrice((int) food[3]));
			foodDAO.setChef((String) food[4]);
			foodDAO.setCategory(categoryName);
			foodDAO.setImageUrls(Arrays.asList(imageUrls.split(",")));
			
			if (foodMap.containsKey(categoryName))
			{
				foodMap.get(categoryName).add(foodDAO);
			}
			else
			{
				List<FoodDAO> foodList = new ArrayList<>();
				foodList.add(foodDAO);
				foodMap.put(categoryName, foodList);
			}
		}
		
		return foodMap;
	}
	
	public List<FoodDAO> getFoodsByCategoryName(String category)
	{
		List<FoodDAO> foodList = new ArrayList<>();
		
		List<Food> foods = foodRepository.findFoodsByCategoryNameWithRelations(category);
		for (Food food : foods)
		{
			FoodDAO foodDAO = new FoodDAO();
			String categoryName = food.getCategory().getName();
			foodDAO.setId(food.getId());
			foodDAO.setName(food.getName());
			foodDAO.setDescription(food.getDescription());
			foodDAO.setPrice(String.valueOf(formatPrice(food.getPrice())));
			foodDAO.setChef(food.getUser().getFullName());
			foodDAO.setCategory(categoryName);
			for (Image image : food.getImages())
			{
				foodDAO.getImageUrls().add(image.getImageUrl());
			}		
			
			foodList.add(foodDAO);
		}
		
		return foodList;
	}
	
	public List<String> getFoodsNameByCategoryName(String categoryName)
	{
		List<String> foodNameList = new ArrayList<>();
		
		List<Food> foods = foodRepository.findFoodsByCategoryName(categoryName);
		for (Food food : foods)
		{
			foodNameList.add(food.getName());
		}
		
		return foodNameList;
	}
	
	public FoodDAO getFoodById(Long id)
	{
		FoodDAO foodDAO = new FoodDAO();
		
		Food food = foodRepository.findFoodById(id);
		String categoryName = food.getCategory().getName();
		foodDAO.setId(food.getId());
		foodDAO.setName(food.getName());
		foodDAO.setDescription(food.getDescription());
		foodDAO.setPrice(String.valueOf(formatPrice(food.getPrice())));
		foodDAO.setChef(food.getUser().getFullName());
		foodDAO.setCategory(categoryName);
		for (Image image : food.getImages())
		{
			foodDAO.getImageUrls().add(image.getImageUrl());
		}
		
		return foodDAO;
	}
	
	public Food getExistingFoodToUpdate(String name)
	{
		return foodRepository.findFoodByName(name);
	}
	
	@Transactional
	public Food saveFood(Food food)
	{
		return foodRepository.save(food);
	}
	
	@Transactional
	public void deleteFoodByName(String foodName)
	{
		foodRepository.deleteFoodByName(foodName);
	}
	
	private String formatPrice(int price)
	{
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		return decimalFormat.format(price);
	}
}
