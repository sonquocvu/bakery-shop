package com.sonvu.springboot.bakeryshop.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfiguration {

	@Autowired
	UserDetailsService userDetailsService;
	
	Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		return config.getAuthenticationManager();
	}
	
	@Bean
	public AuthenticationProvider authenticationProdiver()
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	private String getClassName()
	{
		return "ApplicationConfiguration";
	}
	
	private String getMethodName()
	{
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[2].getMethodName();
	}
}
