package com.sonvu.springboot.bakeryshop.entity;

import java.time.LocalDateTime;

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
@Table(name = "profile_tbl")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "profile_id")
	private Integer id;
	
	@Column(name = "full_name", length = 100, nullable = true)
	private String fullName;
	
	@Column(name = "gender", length = 10, nullable = true)
	private String gender;
	
	@Column(name = "avatar_url", length = 500, nullable = true)
	private String avatarUrl;
	
	@Column(name = "bio", length = 255, nullable = true)
	private String bio;
	
	@Column(name = "last_modified", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime lastModified;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Profile()
	{
		
	}

	public Profile(Integer id, String fullName, String gender, String avatarUrl, String bio, LocalDateTime lastModified,
			User user) 
	{
		super();
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.avatarUrl = avatarUrl;
		this.bio = bio;
		this.lastModified = lastModified;
		this.user = user;
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getFullName() 
	{
		return fullName;
	}

	public void setFullName(String fullName) 
	{
		this.fullName = fullName;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public String getAvatarUrl() 
	{
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) 
	{
		this.avatarUrl = avatarUrl;
	}

	public String getBio() 
	{
		return bio;
	}

	public void setBio(String bio) 
	{
		this.bio = bio;
	}

	public LocalDateTime getLastModified() 
	{
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) 
	{
		this.lastModified = lastModified;
	}

	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}
	
}
