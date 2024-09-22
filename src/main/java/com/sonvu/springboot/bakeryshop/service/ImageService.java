package com.sonvu.springboot.bakeryshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonvu.springboot.bakeryshop.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	public void deleteImageByFoodName(String foodName)
	{
		imageRepository.deleteImageByFoodName(foodName);
	}
}
