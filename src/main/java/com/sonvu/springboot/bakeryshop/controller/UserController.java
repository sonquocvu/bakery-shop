package com.sonvu.springboot.bakeryshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sonvu.springboot.bakeryshop.DAO.UserInforResponse;
import com.sonvu.springboot.bakeryshop.entity.User;
import com.sonvu.springboot.bakeryshop.service.AdminService;
import com.sonvu.springboot.bakeryshop.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	@PutMapping("/update-profile")
	public ResponseEntity<UserInforResponse> updateUserProfile(
			@RequestParam String userId,
			@RequestParam String fullName,
			@RequestParam String  phoneNumber,
			@RequestParam(required = false) MultipartFile avatar)
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		try
		{
			User user = userService.getUserByIdWithAccount(Long.valueOf(userId));
			
			if (!fullName.isEmpty())
			{
				user.setFullName(fullName);
			}
			if (!phoneNumber.isEmpty())
			{
				user.setPhoneNumber(phoneNumber);
			}
			
			if (avatar != null)
			{
				String avatarUrl = adminService.uploadImageToImgbb(avatar);
				if (!avatarUrl.isEmpty())
				{
					user.getAccount().setAvatarUrl(avatarUrl);
				}
			}
			
			User updatedUser = userService.saveUser(user);
			
			UserInforResponse userInforResponse = new UserInforResponse(updatedUser.getId(), updatedUser.getFullName(), 
					updatedUser.getAccount().getAvatarUrl(), updatedUser.getAccount().getIsAdmin());
			
			return ResponseEntity.status(HttpStatus.OK).body(userInforResponse);
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}
	
	private String getClassName()
	{
		return "UserController";
	}
	
	private String getMethodName()
	{
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[2].getMethodName();
	}
}
