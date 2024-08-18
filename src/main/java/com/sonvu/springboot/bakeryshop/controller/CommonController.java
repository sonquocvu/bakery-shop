package com.sonvu.springboot.bakeryshop.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonvu.springboot.bakeryshop.DAO.CakeDAO;
import com.sonvu.springboot.bakeryshop.DAO.CakeResponse;
import com.sonvu.springboot.bakeryshop.service.CakeService;

@RequestMapping("/common")
@RestController
public class CommonController {

	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private CakeService cakeService;

	@GetMapping(value = "/home")
	public ResponseEntity<Map<String, List<CakeDAO>>> home()
	{
		logger.info("{}:{}()", getClassName(), getMethodName());
		
		Map<String, List<CakeDAO>> cakeMap = cakeService.getAllCakes();
		return new ResponseEntity<>(cakeMap, HttpStatus.OK);
	}
	
	private String getClassName()
	{
		return "CommonController";
	}
	
	private String getMethodName()
	{
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[2].getMethodName();
	}
}
