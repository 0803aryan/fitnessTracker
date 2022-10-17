package com.cg.fitnesstracker.app.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.repository.DietRepository;
import com.cg.fitnesstracker.app.service.DietService;
import com.cg.fitnesstracker.app.service.FoodItemService;

@Component
public class DietServiceImpl implements DietService{
	@Autowired
	DietRepository dietRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	FoodItemService foodItemService;

	@Override
	public List<Diet> getAllDietService(String userName) {
		Customer cust = customerRepository.findByUserName(userName);
		List<Diet> dietList = cust.getDiet();
		return dietList;
	}

	@Override
	public Diet addDietByUserIdService(String userName, Diet diet) {
		Customer cust = customerRepository.findByUserName(userName);
		if (cust!=null) {
			List<Diet> dietList = cust.getDiet();
			dietList.add(diet);
			customerRepository.saveAll(dietList);
		}
		return diet;
	}

	@Override
	public FoodItem addFoodItemToDietService(int dietId, int foodId) {
		Diet diet = dietRepository.findById(dietId).get();
		FoodItem food = foodItemService.getFoodItemByIdService(foodId);
		if (diet!=null) {
			List<FoodItem> foodList = diet.getFoodList();
			foodList.add(food);
			dietRepository.saveAll(foodList);
		}
		
		return food;
	}

	@Override
	public FoodItem removeFoodItemFromDietService(int dietId, int foodId) {
		Diet diet = dietRepository.findById(dietId).get();
		FoodItem food = foodItemService.getFoodItemByIdService(foodId);
		if (diet!=null) {
			List<FoodItem> foodList = diet.getFoodList();
			foodList.remove(food);
			dietRepository.saveAll(foodList);
		}
		
		return food;
	}

	@Override
	public Diet deleteDietService(String userName, int dietId) {
		Customer cust = customerRepository.findByUserName(userName);
		if (cust!=null) {
			List<Diet> dietList = cust.getDiet();
			dietList.remove(diet);
			customerRepository.saveAll(dietList);
		}
		return diet;
	}

	@Override
	public int getTotalCaloriesService(String userName, int dietId) {
		Customer cust = customerRepository.findByUserName(userName);
		List<Diet> dietList = cust.getDiet();
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
