package com.sonvu.springboot.bakeryshop.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe_tbl")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recipe_id")
	private Integer id;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "serving", nullable = false, columnDefinition = "default 0")
	private Integer serving;
	
	@Column(name = "instruction", columnDefinition = "TEXT")
	private String instruction;
	
	@Column(name = "prepare_time", columnDefinition = "default 0")
	private Integer prepareTime;
	
	@Column(name = "cook_time", columnDefinition = "default 0")
	private Integer cookTime;
	
	@Column(name = "liked_count", nullable = false, columnDefinition = "default 0")
	private Integer numOfLike;
	
	@Column(name = "saved_count", nullable = false, columnDefinition = "default 0")
	private Integer numOfSave;
	
	@Column(name = "view_count", columnDefinition = "default 0")
	private Integer numOfView;
	
	@Column(name = "created_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdDate;
	
	@Column(name = "last_modified", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime lastModified;
	
	@Column(name = "is_actived", nullable = false, columnDefinition = "BIT DEFAULT b'1'")
	private Boolean isActivated = true;
	
	@Column(name = "is_hidden", nullable = false, columnDefinition = "BIT DEFAULT b'0'")
	private Boolean isHidden = false;
	
	@Column(name = "step", length = 1000, nullable = false, columnDefinition = "default ' '")
	private String step;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToOne(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Image image;
	
	public Recipe()
	{
		
	}

	public Recipe(Integer id, String name, Integer serving, String instruction, Integer prepareTime, Integer cookTime,
			Integer numOfLike, Integer numOfSave, Integer numOfView, LocalDateTime createdDate,
			LocalDateTime lastModified, Boolean isActivated, Boolean isHidden, String step, User user,
			Category category, Image image)
	{
		super();
		this.id = id;
		this.name = name;
		this.serving = serving;
		this.instruction = instruction;
		this.prepareTime = prepareTime;
		this.cookTime = cookTime;
		this.numOfLike = numOfLike;
		this.numOfSave = numOfSave;
		this.numOfView = numOfView;
		this.createdDate = createdDate;
		this.lastModified = lastModified;
		this.isActivated = isActivated;
		this.isHidden = isHidden;
		this.step = step;
		this.user = user;
		this.category = category;
		this.image = image;
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

	public Integer getServing() 
	{
		return serving;
	}

	public void setServing(Integer serving) 
	{
		this.serving = serving;
	}

	public String getInstruction() 
	{
		return instruction;
	}

	public void setInstruction(String instruction) 
	{
		this.instruction = instruction;
	}

	public Integer getPrepareTime() 
	{
		return prepareTime;
	}

	public void setPrepareTime(Integer prepareTime) 
	{
		this.prepareTime = prepareTime;
	}

	public Integer getCookTime() 
	{
		return cookTime;
	}

	public void setCookTime(Integer cookTime) 
	{
		this.cookTime = cookTime;
	}

	public Integer getNumOfLike() 
	{
		return numOfLike;
	}

	public void setNumOfLike(Integer numOfLike) 
	{
		this.numOfLike = numOfLike;
	}

	public Integer getNumOfSave() 
	{
		return numOfSave;
	}

	public void setNumOfSave(Integer numOfSave) 
	{
		this.numOfSave = numOfSave;
	}

	public Integer getNumOfView() 
	{
		return numOfView;
	}

	public void setNumOfView(Integer numOfView) 
	{
		this.numOfView = numOfView;
	}

	public LocalDateTime getCreatedDate() 
	{
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) 
	{
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastModified() 
	{
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) 
	{
		this.lastModified = lastModified;
	}

	public Boolean getIsActivated() 
	{
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) 
	{
		this.isActivated = isActivated;
	}

	public Boolean getIsHidden() 
	{
		return isHidden;
	}

	public void setIsHidden(Boolean isHidden) 
	{
		this.isHidden = isHidden;
	}

	public String getStep() 
	{
		return step;
	}

	public void setStep(String step) 
	{
		this.step = step;
	}

	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}

	public Category getCategory() 
	{
		return category;
	}

	public void setCategory(Category category) 
	{
		this.category = category;
	}

	public Image getImage()
	{
		return image;
	}

	public void setImage(Image image) 
	{
		this.image = image;
	}

	public Integer getTotalTime()
	{
		return (this.cookTime + this.prepareTime);
	}
}
