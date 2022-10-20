package com.cg.fitnesstracker.app.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

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
import com.cg.fitnesstracker.app.response.ResponseMessage;
import com.cg.fitnesstracker.app.service.DietService;

//@Component
public class DietServiceImpl implements DietService{
	private String foodDietEndo;
	private String foodDietEcto;
	private String foodDietMeso;

	public void setFoodDietEcto(String foodDietEcto) {
		this.foodDietEcto = foodDietEcto;
		System.out.println("setter1..");
	}

	public void setFoodDietEndo(String foodDietEndo) {
		this.foodDietEndo = foodDietEndo;
		System.out.println("setter2..");
	}

	public void setFoodDietMeso(String foodDietMeso) {
		this.foodDietMeso = foodDietMeso;
		System.out.println("setter3..");
	}

	@Autowired
	private DietRepository dietRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private FoodItemRepository foodItemRepository;
	@Autowired
	private MealRepository mealRepository;
	

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
            List<Diet> sameTimeDiets = dietList.stream().filter(d->(d.getDate().equals(diet.getDate()))).collect(Collectors.toList());
            if (sameTimeDiets.size()>0) {
                List<Diet> conflictDiet = sameTimeDiets.stream().filter(sd->(sd.getConsumeTime().equals(diet.getConsumeTime())
                        && sd.getDayOfWeek().equals(diet.getDayOfWeek()))).collect(Collectors.toList());
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
			Meal meal = new Meal();
			meal.setDiet(diet);
//			meal.setMealId(meal.getMealId()+1);
			meal.setMealId(meal.getMealId());
			meal.setFoodId(food.getFoodId());
			meal.setFoodName(food.getFoodName());
			meal.setFoodQuant(food.getFoodQuantity());
			meal.setCaloriesInFood(food.getCaloriesInFood());
			List<Meal> mealList = diet.getMealList();
			List<Meal> sameMeal = mealList.stream().filter(m->m.getFoodName().equals(food.getFoodName())).collect(Collectors.toList());
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
		Customer cust = customerRepository.findByUsername(userName);
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
		Customer cust = customerRepository.findByUsername(userName);
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

	@Override
	public String suggestDietService(String username) {
		
		Customer cust = customerRepository.findByUsername(username);
		if(cust!=null) {
			String bodyType = cust.getBodyType().toString();
			if(bodyType.equals("ENDOMORPH")) {
				return foodDietEndo;
			}
			else if(bodyType.equals("ECTOMORPH")) {
				return foodDietEcto;
			}
			else if(bodyType.equals("MESOMORPH")) {
				return foodDietMeso;
			}
		}
		throw new DietException("Body Type doesn't match",404);
	}

}
