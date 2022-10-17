package com.cg.fitnesstracker.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cg.fitnesstracker.app.model.FoodItem;

public interface CSVService {
	
	 public void save(MultipartFile f);
	 
	 public List<FoodItem> getAllFoodItems();
}
