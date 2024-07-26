package com.sonvu.springboot.bakeryshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

import com.sonvu.springboot.bakeryshop.entity.Profile;
import com.sonvu.springboot.bakeryshop.entity.User;
import com.sonvu.springboot.bakeryshop.service.UserService;
import com.sonvu.springboot.bakeryshop.utility.JwtUtility;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
	
	Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtility jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthenRequest authenRequest)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		try
		{
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authenRequest.getUsername(),
							authenRequest.getPassword()));
			
			User user = userService.getUserProfile(authenRequest.getUsername());
			
			Profile profile = user.getProfile();
			
			String jwt = jwtUtil.generateToken(user.getAccount().getUsername());
			
			AuthenResponse authenResponse = new AuthenResponse(
					jwt, profile.getFullName(), profile.getAvatarUrl(), profile.getBio());
			
			return ResponseEntity.ok(authenResponse);
		}
		catch (AuthenticationException e)
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody AuthenRequest authenRequest)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		logger.info("fullName: {} - username: {} - password: {}\n", authenRequest.getFullName(), authenRequest.getUsername(), authenRequest.getPassword());
		return ResponseEntity.ok(null);
	}
	
	private static class AuthenRequest {
		
		private String fullName;
		private String username;
		private String password;
		
		public AuthenRequest()
		{
			
		}
		
		public AuthenRequest(String username, String password) 
		{
			super();
			this.username = username;
			this.password = password;
		}
		
		public AuthenRequest(String fullName, String username, String password)
		{
			super();
			this.fullName = fullName;
			this.username = username;
			this.password = password;
		}
		
		public String getFullName() 
		{
			return fullName;
		}

		public void setFullName(String fullName) 
		{
			this.fullName = fullName;
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
	}
	
	private class AuthenResponse {
		
		private String jwt;
		private String fullName;
		private String avatarUrl;
		private String bio;
		
		public AuthenResponse(String jwt, String fullName, String avatarUrl, String bio) 
		{
			super();
			this.jwt = jwt;
			this.fullName = fullName;
			this.avatarUrl = avatarUrl;
			this.bio = bio;
		}

		public String getJwt() 
		{
			return jwt;
		}

		public void setJwt(String jwt) 
		{
			this.jwt = jwt;
		}

		public String getFullName() 
		{
			return fullName;
		}

		public void setFullName(String fullName) 
		{
			this.fullName = fullName;
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
	}
	
	private String getClassName()
	{
		return "Authentication";
	}
	
	private String getMethodName()
	{
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[2].getMethodName();
	}
}
