package com.sonvu.springboot.bakeryshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonvu.springboot.bakeryshop.DAO.CategoryDAO;
import com.sonvu.springboot.bakeryshop.entity.Category;
import com.sonvu.springboot.bakeryshop.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<String> getAllCategories()
	{
		List<String> categoryList = new ArrayList<>();
		
		List<Category> categories = categoryRepository.findAllCategories();
		for (Category category : categories)
		{
			categoryList.add(category.getName());
		}
		
		return categoryList;
	}
	
	public List<CategoryDAO> getAllCategoriesWithFoodQuantity()
	{
		List<CategoryDAO> result = new ArrayList<>();
		
		List<Object[]> categories = categoryRepository.findAllCategoriesWithProductQuantity();
		for (Object[] category : categories)
		{
			CategoryDAO dao = new CategoryDAO();
			dao.setId((Long) category[0]);
			dao.setName((String) category[1]);
			dao.setQuantity((Long) category[2]);
			result.add(dao);
		}
		
		return result;
	}
	
	public Category getCategoryByName(String name)
	{
		return categoryRepository.findCategoryByName(name);
	}
}
