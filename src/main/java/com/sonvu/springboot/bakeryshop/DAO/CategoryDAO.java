package com.sonvu.springboot.bakeryshop.DAO;

public class CategoryDAO {
	
	private String name;
	private long quantity;
	
	public CategoryDAO()
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
