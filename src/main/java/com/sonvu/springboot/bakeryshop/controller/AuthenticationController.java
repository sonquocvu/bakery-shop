package com.sonvu.springboot.bakeryshop.controller;

import java.time.LocalDateTime;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonvu.springboot.bakeryshop.entity.Account;
import com.sonvu.springboot.bakeryshop.entity.User;
import com.sonvu.springboot.bakeryshop.service.UserService;
import com.sonvu.springboot.bakeryshop.utility.JwtUtility;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtility jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Value("${spring.admin.code}")
	private String adminCode;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		try
		{
			logger.info("username: {} - password: {}", request.getUsername(), request.getPassword());
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getUsername(),
							request.getPassword()));
			
			User user = userService.getUser(request.getUsername());
		
			
			String jwt = jwtUtil.generateToken(user.getEmail());
			
			AuthenResponse authenResponse = new AuthenResponse(user.getId(),
					jwt, user.getFullName(), user.getAccount().getAvatarUrl(), user.getAccount().getIsAdmin());
			
			return ResponseEntity.ok(authenResponse);
		}
		catch (AuthenticationException e)
		{
			logger.info("Login fail due to {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		logger.info("- email: {} - password: {} - fullName: {} - phoneNumber: {} - gender: {}", 
				user.getEmail(), user.getPassword(), user.getFullName(), user.getPhoneNumber(), user.getGender());

		try
		{
			Account account = new Account();
			account.setUser(user);
			account.setAvatarUrl("img/avatar/default.png");
			account.setIsAdmin(false);
			account.setIsActivated(true);
			account.setLastModified(LocalDateTime.now());
			
			user.setCreatedAt(LocalDateTime.now());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setAccount(account);
			
			logger.info("The new password after being encoded: {}", user.getPassword());
			userService.saveUser(user);
			return ResponseEntity.ok(null);
		}
		catch (Exception e)
		{
			logger.info("Register fail due to {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exist");
		}
	}
	
	@PostMapping("/register/admin")
	public ResponseEntity<?> registerAdmin(@RequestBody User user)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		logger.info("- email: {} - password: {} - fullName: {} - phoneNumber: {} - gender: {} - adminCode frontend: {} - adminCode backend: {}", 
				user.getEmail(), user.getPassword(), user.getFullName(), user.getPhoneNumber(), user.getGender(), user.getAdminCode(), adminCode);
		
		if (Objects.equals(user.getAdminCode(), adminCode))
		{
			try
			{
				Account account = new Account();
				account.setUser(user);
				account.setAvatarUrl("img/avatar/default.png");
				account.setIsAdmin(true);
				account.setIsActivated(true);
				account.setLastModified(LocalDateTime.now());
				
				user.setCreatedAt(LocalDateTime.now());
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				user.setAccount(account);
				
				logger.info("The new password after being encoded: {}", user.getPassword());
				userService.saveUser(user);
				return ResponseEntity.ok(null);
			}
			catch (Exception e)
			{
				logger.info("Register fail due to {}", e.getMessage());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exist");
			}
		}
		else
		{
			logger.info("Register fail due to wrong admin code");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong Admin Code");
		}
	}
	
	private static class LoginRequest {
		
		private String username;
		private String password;
		
		LoginRequest() {}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
	
	private class AuthenResponse {
		
		private Long id;
		private String jwt;
		private String fullName;
		private String avatarUrl;
		private Boolean isAdmin;
		
		public AuthenResponse(Long id, String jwt, String fullName, String avatarUrl, Boolean isAdmin)
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

		public Boolean getIsAdmin() {
			return isAdmin;
		}

		public void setIsAdmin(Boolean isAdmin) {
			this.isAdmin = isAdmin;
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
