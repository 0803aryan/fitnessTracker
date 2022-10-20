package com.cg.fitnesstracker.app.controller;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.dto.CaloriesDto;
import com.cg.fitnesstracker.app.exceptions.ApplicationException;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.response.ResponseMessage;
import com.cg.fitnesstracker.app.service.DietService;

@RestController
@RequestMapping("/fitness/diets")
public class DietController {

		@Autowired
		private DietService dietService;
		
		@GetMapping
		@PreAuthorize("hasAuthority('Customer')")
		public ResponseEntity<List<Diet>> getAllDiet(Principal p){
																 	
				List<Diet> dietList = dietService.getAllDietService(p.getName());
				if (dietList.isEmpty()) {
	                throw new ApplicationException("No diet found for this user ID",404);
				}
				return new ResponseEntity<>(dietList, HttpStatus.OK);
				
		}
		
		@GetMapping("/{dietId}")
		@PreAuthorize("hasAuthority('Customer')")
	    public ResponseEntity<Diet> getDiet(@PathVariable int dietId){
			
				Diet diet = dietService.getDietByIdService(dietId);
				return new ResponseEntity<>(diet, HttpStatus.OK);
				
		}

		@PostMapping
		@PreAuthorize("hasAuthority('Customer')")
	    public ResponseEntity<Diet> addDiet(Principal p, @RequestBody Diet diet){
				
				Diet addDiet = dietService.addDietByUserIdService(p.getName(), diet);
				if (addDiet==null) {
					throw new ApplicationException("Unable to add diet",204);
				}
				return new ResponseEntity<>(addDiet, HttpStatus.OK);
				
		}
		
		@PostMapping("/{dietId}/food-items/{foodId}")
		@PreAuthorize("hasAuthority('Customer')")
	    public ResponseEntity<FoodItem> addFoodItem(@PathVariable int dietId, @PathVariable int foodId){
			
				FoodItem addFood = dietService.addFoodItemToDietService(dietId, foodId);
				//OptioanlDiet diet = dietService.getDietByIdService(dietId);
				//if (diet==null) {
				//	throw new DietException("No diet found for this diet Id",404);
				//}
			    if (addFood==null) {
	                throw new ApplicationException("No food item found for this Id",404);
				}
				return new ResponseEntity<>(addFood, HttpStatus.OK);
				
		}
		
		@DeleteMapping("/{dietId}/food-items/{foodId}")
		@PreAuthorize("hasAuthority('Customer')")
	    public ResponseEntity<FoodItem> deleteFoodItem(@PathVariable int dietId, @PathVariable int foodId){
			
				FoodItem removeFood = dietService.removeFoodItemFromDietService(dietId, foodId);
				if (removeFood==null) {
	                throw new ApplicationException("Unable to delete food Item",203);
	            }
				return new ResponseEntity<>(removeFood, HttpStatus.OK);
				
		}
		
		@DeleteMapping("/{dietId}")
		@PreAuthorize("hasAuthority('Customer')")
	    public ResponseEntity<Diet> deleteDiet(Principal p, @PathVariable int dietId){
		
				Diet removeDiet = dietService.deleteDietService(p.getName(), dietId);
				return new ResponseEntity<>(removeDiet, HttpStatus.OK);				
		}

		@GetMapping("/{dietId}/calories")
		@PreAuthorize("hasAuthority('Customer')")
	    public ResponseEntity<CaloriesDto> getCalories(Principal p,@PathVariable int dietId){

				int calories = dietService.getTotalCaloriesService(p.getName(), dietId);
				Diet diet = dietService.getDietByIdService(dietId);
				CaloriesDto cal = new CaloriesDto();
				cal.setDietid(dietId);
				cal.setDate(diet.getDate());
				cal.setConsumeTime(diet.getConsumeTime().toString());
				cal.setCalories(calories);
				return new ResponseEntity<>(cal, HttpStatus.OK);	
				
		}
		@GetMapping("/diets/suggestion")
		@PreAuthorize("hasAnyRole('Admin','Customer')")
		public ResponseEntity<ResponseMessage> suggestDiet(String username){
			String suggestion = dietService.suggestDietService(username);
			return new ResponseEntity<>(new ResponseMessage(suggestion),HttpStatus.OK);
			
		}
}
