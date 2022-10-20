package com.cg.fitnesstracker.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.dto.CaloriesDto;
import com.cg.fitnesstracker.app.exceptions.DietException;
import com.cg.fitnesstracker.app.exceptions.FoodItemException;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.service.DietService;

@RestController
@RequestMapping("/diet")
public class DietController {

		@Autowired
		DietService dietService;
					//("/diets/")
		@GetMapping("/{userName}/diets")//getAllDiet(Principal p)
	    public ResponseEntity<List<Diet>> getAllDiet(@PathVariable String userName){
																 //(p.getName());	
				List<Diet> dietList = dietService.getAllDietService(userName);
				if (dietList.isEmpty()) {
	                throw new DietException("No diet found for this user ID",404);
				}
				return new ResponseEntity<>(dietList, HttpStatus.OK);
				
		}
		
		@GetMapping("/{userName}/diets/{dietId}")
	    public ResponseEntity<Diet> getDiet(@PathVariable String userName,@PathVariable int dietId){
				Diet diet = dietService.getDietByIdService(dietId);
				return new ResponseEntity<>(diet, HttpStatus.OK);
				
		}
		
		@PostMapping("/{userName}/diets")
	    public ResponseEntity<Diet> addDiet(@PathVariable String userName, @RequestBody Diet diet){
				
				Diet addDiet = dietService.addDietByUserIdService(userName, diet);
				if (addDiet==null) {
					throw new DietException("Unable to add diet",204);
				}
				return new ResponseEntity<>(addDiet, HttpStatus.OK);
				
		}
		
		@PostMapping("/{userName}/diets/{dietId}/food-items/{foodId}")
	    public ResponseEntity<FoodItem> addFoodItem(@PathVariable int dietId, @PathVariable int foodId){
				FoodItem addFood = dietService.addFoodItemToDietService(dietId, foodId);
				//OptioanlDiet diet = dietService.getDietByIdService(dietId);
				//if (diet==null) {
				//	throw new DietException("No diet found for this diet Id",404);
				//}
			    if (addFood==null) {
	                throw new FoodItemException("No food item found for this Id",404);
				}
				return new ResponseEntity<>(addFood, HttpStatus.OK);
				
		}
		
		@DeleteMapping("/{userName}/diets/{dietId}/food-items/{foodId}")
	    public ResponseEntity<FoodItem> deleteFoodItem(@PathVariable int dietId, @PathVariable int foodId){
				FoodItem removeFood = dietService.removeFoodItemFromDietService(dietId, foodId);
				if (removeFood==null) {
	                throw new DietException("Unable to delete food Item",203);
	            }
				return new ResponseEntity<>(removeFood, HttpStatus.OK);
				
		}
		
		@DeleteMapping("/{userName}/diets/{dietId}")
	    public ResponseEntity<Diet> deleteDiet(@PathVariable String userName, @PathVariable int dietId){
		
				Diet removeDiet = dietService.deleteDietService(userName, dietId);
				return new ResponseEntity<>(removeDiet, HttpStatus.OK);
				
		}

		@GetMapping("/{userName}/diets/{dietId}/calories")
	    public ResponseEntity<CaloriesDto> getCalories(@PathVariable String userName,@PathVariable int dietId){

				int calories = dietService.getTotalCaloriesService(userName, dietId);
				Diet diet = dietService.getDietByIdService(dietId);
				CaloriesDto cal = new CaloriesDto();
				cal.setDietid(dietId);
				cal.setDate(diet.getDate());
				cal.setConsumeTime(diet.getConsumeTime().toString());
				cal.setCalories(calories);
				return new ResponseEntity<>(cal, HttpStatus.OK);
			
		}
}
