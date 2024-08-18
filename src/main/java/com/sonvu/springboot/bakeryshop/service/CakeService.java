package com.sonvu.springboot.bakeryshop.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonvu.springboot.bakeryshop.DAO.CakeDAO;
import com.sonvu.springboot.bakeryshop.entity.Cake;
import com.sonvu.springboot.bakeryshop.entity.Image;
import com.sonvu.springboot.bakeryshop.repository.CakeRepository;

@Service
public class CakeService {

	private static final Logger logger = LoggerFactory.getLogger(CakeService.class);
	
	@Autowired
	private CakeRepository cakeRepository;
	
	public Map<String, List<CakeDAO>> getAllCakes()
	{
		Map<String, List<CakeDAO>> cakeMap = new HashMap<>();
		
		List<Cake> cakes = cakeRepository.findAllCakesWithRelations();
		for (Cake cake : cakes)
		{
			CakeDAO cakeDAO = new CakeDAO();
			String categoryName = cake.getCategory().getName();
			cakeDAO.setId(cake.getId());
			cakeDAO.setName(cake.getName());
			cakeDAO.setDescription(cake.getDescription());
			cakeDAO.setChef(cake.getUser().getFullName());
			cakeDAO.setPrice(String.valueOf(cake.getPrice()));
			cakeDAO.setCategory(categoryName);
			for (Image image : cake.getImages())
			{
				cakeDAO.getImageUrls().add(image.getImageUrl());
			}
						
			if (cakeMap.containsKey(categoryName))
			{
				cakeMap.get(categoryName).add(cakeDAO);
			}
			else
			{
				List<CakeDAO> cakeList = new ArrayList<>();
				cakeList.add(cakeDAO);
				cakeMap.put(categoryName, cakeList);
			}
		}
		
		return cakeMap;
	}
	
	private String formatPrice(int price)
	{
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		return decimalFormat.format(price);
	}
}
