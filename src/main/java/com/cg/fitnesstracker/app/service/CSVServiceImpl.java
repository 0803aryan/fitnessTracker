package com.cg.fitnesstracker.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cg.fitnesstracker.app.csvoperations.CSVHelper;
import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.repository.FoodItemRepository;

@Component
public class CSVServiceImpl implements CSVService{
	
	@Autowired
    FoodItemRepository foodrepository;
    
    public void save(MultipartFile file) {
        try {
            List<FoodItem> fooditems = CSVHelper.csvToFoodItem(file.getInputStream());
            foodrepository.saveAll(fooditems);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
    
    public List<FoodItem> getAllFoodItems() {
        //casted
        return (List<FoodItem>) foodrepository.findAll();
    }
}
