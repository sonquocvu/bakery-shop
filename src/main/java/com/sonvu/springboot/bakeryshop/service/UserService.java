package com.sonvu.springboot.bakeryshop.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonvu.springboot.bakeryshop.entity.User;
import com.sonvu.springboot.bakeryshop.repository.UserRepository;
import com.sonvu.springboot.bakeryshop.utility.InputValidator;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
		return userRepository.findAllUsers();
	}
	
	public User getUser(String username)
	{
		User user = null;
		String type = InputValidator.validateInput(username);
		
		logger.info("The input type is {}", type);
		
		if ("email".equals(type))
		{
			logger.info("Looking for user using email");
			user = userRepository.findByEmail(username);
		}
		else if ("phone".equals(type))
		{
			user = userRepository.findByPhoneNumber(username);
		}
		
		return user;
	}
	
	public User getUserById(Long id)
	{
		return userRepository.findUserById(id);
	}
	
	@Transactional
	public User saveUser(User user)
	{
		return userRepository.save(user);
	}
}
