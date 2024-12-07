package com.sonvu.springboot.bakeryshop.DAO;

import java.util.ArrayList;
import java.util.List;

public class FoodDAO {
	
	private Long id;
	private String name;
	private String description;
	private String chef;
	private String price;
	private String category;
	private List<String> imageUrls;
	
	public FoodDAO()
	{
		imageUrls = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getChef() {
		return chef;
	}

	public void setChef(String chef) {
		this.chef = chef;
	}

	public String getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
	
}
