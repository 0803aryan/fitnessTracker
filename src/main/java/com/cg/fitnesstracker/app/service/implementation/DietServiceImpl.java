package com.cg.fitnesstracker.app.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.exceptions.DietException;
import com.cg.fitnesstracker.app.exceptions.FoodItemException;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.model.Meal;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.repository.DietRepository;
import com.cg.fitnesstracker.app.repository.FoodItemRepository;
import com.cg.fitnesstracker.app.repository.MealRepository;
import com.cg.fitnesstracker.app.service.DietService;

@Component
public class DietServiceImpl implements DietService{
	@Autowired
	DietRepository dietRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	FoodItemRepository foodItemRepository;
	@Autowired
	MealRepository mealRepository;
	@Autowired
	Meal meal;
	

	@Override
	public List<Diet> getAllDietService(String username) {
		Customer cust = customerRepository.findByUsername(username);
		List<Diet> dietList = cust.getDiet();
		return dietList;
	}
	
	@Override
	public Diet getDietByIdService(int dietId) {
		Optional<Diet> diet = dietRepository.findById(dietId);
		if (!diet.isPresent()) {
			throw new DietException("No Diet Exists for this diet Id",404);
		}
		return diet.get();
	}

	@Override
	public Diet addDietByUserIdService(String username, Diet diet) {
		Customer cust = customerRepository.findByUsername(username);
		if (cust!=null) {
			diet.setCustomer(cust);
			List<Diet> dietList = cust.getDiet();
			List<Diet> sameTimeDiets = dietList.stream().filter(d->(d.getDate().equals(diet.getDate()))).toList();
			if (sameTimeDiets.size()>0) {
				List<Diet> conflictDiet = sameTimeDiets.stream().filter(sd->(sd.getConsumeTime().equals(diet.getConsumeTime())
						&& sd.getDayOfWeek().equals(diet.getDayOfWeek()))).toList();
				if (conflictDiet.size()>0) {
				throw new DietException("Diet already exists on "+diet.getDate().toString()
						+" "+diet.getConsumeTime().toString()+" "+diet.getDayOfWeek().toString()+" with Id : "+conflictDiet.get(0).getDietId()+" Please add or delete a food item to modify the diet",400);
				}
			}
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
			meal.setDiet(diet);
			meal.setMealId(meal.getMealId()+1);
			meal.setFoodId(food.getFoodId());
			meal.setFoodName(food.getFoodName());
			meal.setFoodQuant(food.getFoodQuantity());
			meal.setCaloriesInFood(food.getCaloriesInFood());
			List<Meal> mealList = diet.getMealList();
			List<Meal> sameMeal = mealList.stream().filter(m->m.getFoodName().equals(food.getFoodName())).toList();
			if (sameMeal.size()>0) {
				throw new DietException("Food Item already exists",400);
			}
			mealList.add(meal);
			mealRepository.saveAll(mealList);
			
		}
		return food;
	}

	@Override
	@Transactional
	public FoodItem removeFoodItemFromDietService(int dietId, int foodId) {
		Diet diet = dietRepository.findById(dietId).get();
		FoodItem food = foodItemRepository.findById(foodId).get();
		if (diet!=null && food!=null) {
			dietRepository.deleteFoodFromDiet(dietId, foodId);
		}
		return food;
	}

	@Override
	@Transactional
	public Diet deleteDietService(String userName, int dietId) {
		Customer cust = customerRepository.findByUserName(userName);
		Optional<Diet> diet = dietRepository.findById(dietId);
		if (!diet.isPresent()) {
			throw new DietException("Could not find Diet",404);
		}
		if (cust!=null && diet.get()!=null) {
			diet.get().setCustomer(cust);
			dietRepository.deleteDietById(dietId);
		}
		return diet.get();
	}

	@Override
	public int getTotalCaloriesService(String userName, int dietId) {
		Customer cust = customerRepository.findByUserName(userName);
		List<Diet> dietList = cust.getDiet();
		Diet diet = dietRepository.findById(dietId).get();
		int cal=0;
		if (diet!=null) {
			List<Meal> mealList = diet.getMealList();
			if (mealList.size()==0) {
				throw new FoodItemException("Please add a food item first!",404); 
			}
			for (Meal item : mealList) {
				cal+=item.getCaloriesInFood();
			}
		}	
		return cal;
	}

}
