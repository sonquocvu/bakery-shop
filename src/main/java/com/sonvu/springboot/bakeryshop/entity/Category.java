package com.sonvu.springboot.bakeryshop.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category_tbl")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private Integer id;
	
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "count_num")
	private Integer numOfCategories;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Recipe> recipe;
	
	public Category()
	{
		
	}
	
	public Category(String name, Integer numOfCategories)
	{
		this.name = name;
		this.numOfCategories = numOfCategories;
	}
	
	public Category(Integer id, String name, Integer numOfCategories)
	{
		this.id = id;
		this.name = name;
		this.numOfCategories = numOfCategories;
	}
	
	public Integer getId()
	{
		return this.id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Integer getNumOfCategories()
	{
		return this.numOfCategories;
	}
	
	public void setNumOfCategories(Integer numOfCategories)
	{
		this.numOfCategories = numOfCategories;
	}

	public List<Recipe> getRecipe() 
	{
		return recipe;
	}

	public void setRecipe(List<Recipe> recipe) 
	{
		this.recipe = recipe;
	}
}
