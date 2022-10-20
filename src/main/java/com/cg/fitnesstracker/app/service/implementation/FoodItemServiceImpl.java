package com.cg.fitnesstracker.app.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.repository.FoodItemRepository;
import com.cg.fitnesstracker.app.service.FoodItemService;
@Component
public class FoodItemServiceImpl implements FoodItemService{
	@Autowired
	FoodItemRepository foodItemRepository;
	
	//To get all food items
	@Override
	public List<FoodItem> getAllFoodItemService() {
		List<FoodItem> foodItems = new ArrayList();
		Iterable<FoodItem> items = foodItemRepository.findAll();
		items.forEach(c->foodItems.add(c));
		return foodItems;
	}
	
	// To get food item by Id
	@Override
	public FoodItem getFoodItemByIdService(int foodId) {
		FoodItem item = foodItemRepository.findById(foodId).get();
		return item;
	}
	
	//To get calories in a food item
	@Override
	public int getCaloriesService(int foodId) {
		FoodItem item = foodItemRepository.findById(foodId).get();
		if (item!=null) {
		return item.getCaloriesInFood();
		}
		return 0;
	}
}
