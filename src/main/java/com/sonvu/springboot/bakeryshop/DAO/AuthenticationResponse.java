package com.sonvu.springboot.bakeryshop.DAO;

public class AuthenticationResponse {
	
	private Long id;
	private String jwt;
	private String fullName;
	private String avatarUrl;
	private Boolean isAdmin;
	
	public AuthenticationResponse(Long id, String jwt, String fullName, String avatarUrl, Boolean isAdmin)
	{
		super();
		this.id = id;
		this.jwt = jwt;
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

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
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
