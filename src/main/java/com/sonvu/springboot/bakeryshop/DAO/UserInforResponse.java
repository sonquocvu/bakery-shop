package com.sonvu.springboot.bakeryshop.DAO;

public class UserInforResponse {
	
	private Long id;
	private String fullName;
	private String avatarUrl;
	private Boolean isAdmin;
	
	public UserInforResponse(Long id, String fullName, String avatarUrl, Boolean isAdmin)
	{
		this.id = id;
		this.fullName = fullName;
		this.avatarUrl = avatarUrl;
		this.isAdmin = isAdmin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
