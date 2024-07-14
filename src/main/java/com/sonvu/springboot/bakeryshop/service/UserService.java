package com.sonvu.springboot.bakeryshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonvu.springboot.bakeryshop.entity.User;
import com.sonvu.springboot.bakeryshop.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
		return userRepository.findAllUsers();
	}
}
