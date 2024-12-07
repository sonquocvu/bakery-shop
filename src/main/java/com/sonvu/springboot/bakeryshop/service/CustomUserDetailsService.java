package com.sonvu.springboot.bakeryshop.service;

import java.util.Collection;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sonvu.springboot.bakeryshop.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		if (username == null || username.trim().isEmpty())
		{
			throw new UsernameNotFoundException("Username is empty");
		}
		
		User user = userService.getUser(username);
		
		if (user == null)
		{
			logger.info("User not found with username: {}", username);
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		logger.info("Found user {}", username);
		
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(),
				user.getPassword(),
				getAuthorities(user.getAccount().getIsAdmin()));
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(boolean isAdmin)
	{
		String role = isAdmin? "ROLE_ADMIN" : "ROLE_USER";
		Collection<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));
		
		return authorities;
	}
}
