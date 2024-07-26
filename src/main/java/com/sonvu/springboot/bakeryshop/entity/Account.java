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
@Table(name = "account_tbl")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private Integer id;
	
	@Column(name = "username", length = 50, nullable = false)
	private String username;
	
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	@Column(name = "email", length = 255, nullable = true)
	private String email;
	
	@Column(name = "phone_number", length = 15, nullable = true)
	private String phoneNumber;
	
	@Column(name = "last_modified", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime lastModifided;
	
	@Column(name = "is_actived", nullable = false, columnDefinition = "BIT DEFAULT b'1'")
	private Boolean isActivated = true;
	
	@Column(name = "is_admin", nullable = false, columnDefinition = "BIT DEFAULT b'0")
	private Boolean isAdmin = false;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Account()
	{
		
	}

	public Account(Integer id, String username, String password, String email, String phoneNumber,
			LocalDateTime lastModifided, Boolean isActivated, Boolean isAdmin, User user) 
	{
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.lastModifided = lastModifided;
		this.isActivated = isActivated;
		this.isAdmin = isAdmin;
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

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getLastModifided() 
	{
		return lastModifided;
	}

	public void setLastModifided(LocalDateTime lastModifided) 
	{
		this.lastModifided = lastModifided;
	}

	public Boolean getIsActivated() 
	{
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) 
	{
		this.isActivated = isActivated;
	}

	public Boolean getIsAdmin() 
	{
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) 
	{
		this.isAdmin = isAdmin;
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
