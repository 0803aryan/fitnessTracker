package com.cg.fitnesstracker.app.service.implementation;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.service.DietService;

@Component
public class DietServiceImpl implements DietService{

	@Override
	public List<Diet> getAllDietService(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diet addDietByUserIdService(String userName, Diet diet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodItem addFoodItemToDietService(int dietId, int foodId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodItem removeFoodItemFromDietService(int dietId, int foodId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diet deleteDietService(String userName, int dietId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCaloriesService(String userName, int dietId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
