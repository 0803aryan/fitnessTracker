package com.cg.fitnesstracker.app.service;

import java.util.List;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.model.FoodItem;

public interface DietService {
        
    public List<Diet> getAllDietService(String username); //Inside this we will get the current day of the week using date time and show the diet for that day
        
    public Diet addDietByUserIdService(String username, Diet diet);

   	public FoodItem addFoodItemToDietService(int dietId, int foodId);

   	public FoodItem removeFoodItemFromDietService(int dietId, int foodId);

   	public Diet deleteDietService(String username, int dietId);

   	public int getTotalCaloriesService(String username, int dietId);
    
}