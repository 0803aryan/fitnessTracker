package com.cg.fitnesstracker.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.service.FoodItemService;

@RestController
@RequestMapping("/fitness/food-items")
public class FoodItemController {

		@Autowired
		FoodItemService foodItemService;
		
		//To get all the food items available to add
		@GetMapping
		@PreAuthorize("hasAnyRole('Customer','Admin')")
	    public ResponseEntity<List<FoodItem>> getAllFoodItems(){
			
			List<FoodItem> foodItemList = foodItemService.getAllFoodItemService();
			return new ResponseEntity<>(foodItemList, HttpStatus.OK);
			
			
		}
		
		//To get a particular food Item
		@GetMapping("/{foodId}")
		@PreAuthorize("hasAnyRole('Customer','Admin')")
	    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable int foodId){
			
			FoodItem foodItem = foodItemService.getFoodItemByIdService(foodId);
			return new ResponseEntity<>(foodItem, HttpStatus.OK);
			
		}
		
		//To get the calories in a particular food Item
		@GetMapping("/{foodId}/calories")
		@PreAuthorize("hasAnyRole('Customer','Admin')")
	    public ResponseEntity<Integer> getCaloriesById(@PathVariable int foodId){
			
			int calories = foodItemService.getCaloriesService(foodId);
			return new ResponseEntity<>(calories, HttpStatus.OK);
			
		}
}