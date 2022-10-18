package com.cg.fitnesstracker.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.service.DietService;

@RestController
@RequestMapping("/diet")
public class DietController {

		@Autowired
		DietService dietService;
		
		@GetMapping("/{userName}/diets/")
	    public ResponseEntity<List<Diet>> getAllDiet(@PathVariable String userName){
			try {
				List<Diet> dietList = dietService.getAllDietService(userName);
				if (dietList.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
				return new ResponseEntity<>(dietList, HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
		
		@PostMapping("/{userName}/diets/")
	    public ResponseEntity<Diet> addDiet(@PathVariable String userName, @RequestBody Diet diet){
			try {
				Diet addDiet = dietService.addDietByUserIdService(userName, diet);
				if (addDiet==null) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
				return new ResponseEntity<>(addDiet, HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
		
		@PostMapping("/{userName}/diets/{dietId}/food-items/{foodId}")
	    public ResponseEntity<FoodItem> addFoodItem(@PathVariable int dietId, @PathVariable int foodId){
			try {
				FoodItem addFood = dietService.addFoodItemToDietService(dietId, foodId);
				if (addFood==null) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
				return new ResponseEntity<>(addFood, HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
		
		@DeleteMapping("/{userName}/diets/{dietId}/food-items/{foodId}")
	    public ResponseEntity<FoodItem> deleteFoodItem(@PathVariable int dietId, @PathVariable int foodId){
			try {
				FoodItem removeFood = dietService.removeFoodItemFromDietService(dietId, foodId);
				if (removeFood==null) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
				return new ResponseEntity<>(removeFood, HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
		
		@DeleteMapping("/{userName}/diets/{dietId}/")
	    public ResponseEntity<Diet> deleteDiet(@PathVariable String userName, @PathVariable int dietId){
			try {
				Diet removeDiet = dietService.deleteDietService(userName, dietId);
				if (removeDiet==null) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
				return new ResponseEntity<>(removeDiet, HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
		@GetMapping("/{userName}/diet/{dietId}/get-calories/")
	    public ResponseEntity<Integer> getCalories(@PathVariable String userName,@PathVariable int dietId){
			try {
				int calories = dietService.getTotalCaloriesService(userName, dietId);
				if (calories==0) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
				return new ResponseEntity<>(calories, HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
}
