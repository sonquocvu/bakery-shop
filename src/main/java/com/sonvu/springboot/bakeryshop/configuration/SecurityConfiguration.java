package com.sonvu.springboot.bakeryshop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthEntryPoint;
	
	@Value("${security.permitted.urls}")
	private String[] permittedUrls;
	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(
				request -> 
					request.requestMatchers(permittedUrls).permitAll()
							.requestMatchers("/admin/**").hasRole("ADMIN")
							.requestMatchers("/user/**").hasRole("USER")
							.anyRequest().authenticated())
			.exceptionHandling(
				except ->
					except.authenticationEntryPoint(jwtAuthEntryPoint))
			.sessionManagement(
				session ->
					session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
			.logout(
				logout ->
					logout.deleteCookies("JSESSIONID")
							.invalidateHttpSession(true)
							.logoutUrl("/auth/logout")
							.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
							.permitAll())
			.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
			
		return http.build();
	}
}
