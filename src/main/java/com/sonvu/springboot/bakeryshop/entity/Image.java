package com.sonvu.springboot.bakeryshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "image_tbl")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "img_id")
	private Integer id;
	
	@Column(name = "img_link", length = 500, nullable = false)
	private String link;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;
	
	public Image()
	{
		
	}

	public Image(Integer id, String link, Recipe recipe)
	{
		this.id = id;
		this.link = link;
		this.recipe = recipe;
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getLink() 
	{
		return link;
	}

	public void setLink(String link) 
	{
		this.link = link;
	}

	public Recipe getRecipe() 
	{
		return recipe;
	}

	public void setRecipe(Recipe recipe) 
	{
		this.recipe = recipe;
	}
}
