package com.sonvu.springboot.bakeryshop.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sonvu.springboot.bakeryshop.entity.User;
import com.sonvu.springboot.bakeryshop.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
		return userRepository.findAllUsers();
	}
	
	public User getUserProfile(String username)
	{
		return userRepository.findByUsernameGetProfile(username);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userRepository.findByUsername(username);
		
		if (user == null)
		{
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		return new org.springframework.security.core.userdetails.User(
				user.getAccount().getUsername(),
				user.getAccount().getPassword(),
				getAuthorities(user.getAccount().getIsAdmin())
				);
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(boolean isAdmin)
	{
		String role = isAdmin? "ADMIN" : "USER";
		Collection<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));
		
		return authorities;
	}
}
