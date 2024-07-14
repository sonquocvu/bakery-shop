package com.sonvu.springboot.bakeryshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests((requests) -> 
					requests.anyRequest().permitAll());
		
		return http.build();
	}
}
