package com.cg.fitnesstracker.app.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.repository.DietRepository;
import com.cg.fitnesstracker.app.repository.FoodItemRepository;
import com.cg.fitnesstracker.app.service.DietService;

@Component
public class DietServiceImpl implements DietService{
	@Autowired
	DietRepository dietRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	FoodItemRepository foodItemRepository;

	@Override
	public List<Diet> getAllDietService(String username) {
		Customer cust = customerRepository.findByUsername(username);
		List<Diet> dietList = cust.getDiet();
		return dietList;
	}

	@Override
	public Diet addDietByUserIdService(String username, Diet diet) {
		Customer cust = customerRepository.findByUsername(username);
		if (cust!=null) {
			diet.setCustomer(cust);
			List<Diet> dietList = cust.getDiet();
			dietList.add(diet);
			dietRepository.saveAll(dietList);
		}
		return diet;
	}

	@Override
	public FoodItem addFoodItemToDietService(int dietId, int foodId) {
		Diet diet = dietRepository.findById(dietId).get();
		FoodItem food = foodItemRepository.findById(foodId).get();
		
		if (diet!=null && food!=null) {
			food.setDiet(diet);
			List<FoodItem> foodList = diet.getFoodList();
			foodList.add(food);
			foodItemRepository.saveAll(foodList);
			
		}
		
		return food;
	}

	@Override
	@Transactional
	public FoodItem removeFoodItemFromDietService(int dietId, int foodId) {
		Diet diet = dietRepository.findById(dietId).get();
		FoodItem food = foodItemRepository.findById(foodId).get();
		if (diet!=null && food!=null) {
			food.setDiet(diet);
			dietRepository.deleteFoodFromDiet(dietId, foodId);
		}
		
		return food;
	}

	@Override
	@Transactional
	public Diet deleteDietService(String username, int dietId) {
		Customer cust = customerRepository.findByUsername(username);
		Diet diet = dietRepository.findById(dietId).get();
		if (cust!=null && diet!=null) {
			diet.setCustomer(cust);
			dietRepository.deleteDietById(dietId);
		}
		return diet;
	}

	@Override
	public int getTotalCaloriesService(String username, int dietId) {
		Customer cust = customerRepository.findByUsername(username);
		//List<Diet> dietList = cust.getDiet();
		Diet diet = dietRepository.findById(dietId).get();
		int cal=0;
		if (diet!=null) {
			List<FoodItem> foodList = diet.getFoodList();
			for (FoodItem item : foodList) {
				cal+=item.getCaloriesInFood();
			}
		}
		
		return cal;
	}

}
