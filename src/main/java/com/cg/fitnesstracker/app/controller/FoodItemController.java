package com.cg.fitnesstracker.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.service.FoodItemService;

@RestController
@RequestMapping("/food-items")
public class FoodItemController {

		@Autowired
		FoodItemService foodItemService;
		
		@GetMapping("/all")
	    public ResponseEntity<List<FoodItem>> getAllFoodItems(){
			try {
			List<FoodItem> foodItemList = foodItemService.getAllFoodItemService();
			if (foodItemList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
			return new ResponseEntity<>(foodItemList, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		@GetMapping("/{foodId}")
	    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable int foodId){
			try {
			FoodItem foodItem = foodItemService.getFoodItemByIdService(foodId);
			if (foodItem==null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
			return new ResponseEntity<>(foodItem, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		@GetMapping("/calories/{foodId}")
	    public ResponseEntity<Integer> getCaloriesById(@PathVariable int foodId){
			try {
			int calories = foodItemService.getCaloriesService(foodId);
			if (calories==0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
			return new ResponseEntity<>(calories, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
}