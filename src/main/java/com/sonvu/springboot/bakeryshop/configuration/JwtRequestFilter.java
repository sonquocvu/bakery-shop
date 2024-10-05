package com.sonvu.springboot.bakeryshop.configuration;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sonvu.springboot.bakeryshop.utility.JwtUtility;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtility jwtUtil;
	
	Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);
	
	@Override
	protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException 
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		final String token = request.getHeader("Authorization");
		
		String email = null;
		String jwtToken = null;
		
		if (token != null && token.startsWith("Bearer "))
		{
			jwtToken = token.substring(7);
			logger.info("The JWT: {}", jwtToken);
			
			try
			{
				email = jwtUtil.extractUsername(jwtToken);
			}
			catch (IllegalArgumentException e)
			{
				logger.info("Unable to get JWT");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
			catch (ExpiredJwtException e)
			{
				logger.info("JWT already got expired");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
		}
		else
		{
			logger.warn("Request token is not valid");
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (email != null && authentication == null)
		{
			HttpSession session = request.getSession(true);
			if (session != null)
			{
				UserDetails userDetails = (UserDetails) session.getAttribute("USER_DETAILS");
				
				if (userDetails == null)
				{
					userDetails = userDetailsService.loadUserByUsername(email);
					session.setAttribute("USER_DETAILS", userDetails);
				}
				
				if (jwtUtil.isTokenvalid(jwtToken, userDetails))
				{
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
							userDetails,
							null,
							userDetails.getAuthorities());
					
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
				else
				{
					SecurityContextHolder.clearContext();
					session.invalidate();
					response.sendRedirect("/login");
					return;
				}
			}
		}
		
		chain.doFilter(request, response);
	}
	
	private String getClassName()
	{
		return "JwtRequestFilter";
	}
	
	private String getMethodName()
	{
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[2].getMethodName();
	}
}
