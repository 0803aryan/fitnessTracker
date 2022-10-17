package com.cg.fitnesstracker.app.service;
import java.util.List;
import com.cg.fitnesstracker.app.model.FoodItem;


public interface FoodItemService {
    public List<FoodItem> getAllFoodItemService();

    public FoodItem getFoodItemByIdService(int foodId);

    public FoodItem addFootItemService(FoodItem item);

   	public Float setFoodItemQuantityService(Float quantity);

   	public int getCaloriesService(int foodId);
   
}