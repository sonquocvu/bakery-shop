package com.sonvu.springboot.bakeryshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tag_tbl")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tag_id")
	private Integer id;
	
	@Column(name = "name", length = 45, nullable = true)
	private String name;
	
	@Column(name = "count", nullable = false, columnDefinition = "default 0")
	private Integer count;

	public Tag()
	{
		
	}
	
	public Tag(Integer id, String name, Integer count)
	{
		super();
		this.id = id;
		this.name = name;
		this.count = count;
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Integer getCount() 
	{
		return count;
	}

	public void setCount(Integer count) 
	{
		this.count = count;
	}
	
}
