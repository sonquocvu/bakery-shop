package com.sonvu.springboot.bakeryshop.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CakeResponse {
	
	HashMap<String, List<CakeDAO>> cakeMap;
	
	public CakeResponse()
	{
		cakeMap = new HashMap<>();
	}

	public HashMap<String, List<CakeDAO>> getCakeMap() {
		return cakeMap;
	}

	public void setCakeMap(HashMap<String, List<CakeDAO>> cakes) {
		this.cakeMap = cakes;
	}
}
