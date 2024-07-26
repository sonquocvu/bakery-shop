package com.sonvu.springboot.bakeryshop.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_tbl")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;
	
	@Column(name = "created_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdDate;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Recipe> recipe;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Profile profile;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Account account;
	
	@OneToMany(mappedBy = "following", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Follow> followings = new HashSet<>();
	
	@OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Follow> followers = new HashSet<>();
	
	public User()
	{
		
	}
	
	public User(Integer id, LocalDateTime createdDate, List<Recipe> recipe, Profile profile, Set<Follow> followings,
			Set<Follow> followers) 
	{
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.recipe = recipe;
		this.profile = profile;
		this.followings = followings;
		this.followers = followers;
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public LocalDateTime getCreatedDate()
	{
		return this.createdDate;
	}
	
	public void setCreatedDate(LocalDateTime createdDate)
	{
		this.createdDate = createdDate;
	}

	public List<Recipe> getRecipe() 
	{
		return recipe;
	}

	public void setRecipe(List<Recipe> recipe) 
	{
		this.recipe = recipe;
	}

	public Profile getProfile() 
	{
		return profile;
	}

	public void setProfile(Profile profile) 
	{
		this.profile = profile;
	}

	public Set<Follow> getFollowings() 
	{
		return followings;
	}

	public void setFollowings(Set<Follow> followings) 
	{
		this.followings = followings;
	}

	public Set<Follow> getFollowers() 
	{
		return followers;
	}

	public void setFollowers(Set<Follow> followers) 
	{
		this.followers = followers;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
