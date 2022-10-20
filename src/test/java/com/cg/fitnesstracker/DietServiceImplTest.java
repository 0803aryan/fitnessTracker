package com.cg.fitnesstracker;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.model.Meal;
import com.cg.fitnesstracker.app.model.enums.BodyType;
import com.cg.fitnesstracker.app.model.enums.ConsumeTime;
import com.cg.fitnesstracker.app.model.enums.DayOfWeek;
import com.cg.fitnesstracker.app.model.enums.Gender;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.repository.DietRepository;
import com.cg.fitnesstracker.app.repository.FoodItemRepository;
import com.cg.fitnesstracker.app.repository.MealRepository;
import com.cg.fitnesstracker.app.service.implementation.DietServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DietServiceImplTest {
	
	@Mock
	private DietRepository dietrepository;
	@Mock
	private  CustomerRepository customerepo;
	@Mock
	private FoodItemRepository fooditemrepo;
	@Mock
	private MealRepository mealrepo;
	@InjectMocks
	private DietServiceImpl dietservice;
	private static List<Diet> dietlist = new ArrayList<>();
	private static List<Meal>meallist= new ArrayList<>();
	private static List<FoodItem>foodlist= new ArrayList<>();
	private static Customer c1= new Customer();
	private static Diet diet = new Diet();
	private static FoodItem food = new FoodItem();
	@BeforeAll	
	static void setup() {
		c1.setUsername("Rakesh");
		c1.setGender(Gender.MALE);
		c1.setAge(22);
		c1.setBodyType(BodyType.ENDOMORPH);
		
	    diet.setConsumeTime(ConsumeTime.LUNCH);
	    diet.setDayOfWeek(DayOfWeek.FRIDAY);
		diet.setDate();
		diet.setDietId(12);
		diet.setCustomer(c1);
		diet.setMealList(meallist);
		dietlist.add(diet);
		c1.setDiet(dietlist);
		
		Meal m1= new Meal(10,"Cooked veggies", "200g",500);
		m1.setFoodId(13);
		meallist.add(m1);
		
		food.setFoodName("Chowmein");
		food.setFoodQuant("100g");
		food.setCaloriesInFood(600);
		food.setFoodId(13);
		foodlist.add(food);
	}
	@Test
	void testGetAllDietServices () {
		
		assertNotNull(dietrepository);
		when(customerepo.findByUsername(anyString())).thenReturn(c1);
		assertEquals(dietlist,dietservice.getAllDietService("Rakesh"));
	
	}
	
	@Test
	void testremoveFoodItemFromDietService() {
		
		when(dietrepository.findById(anyInt())).thenReturn(Optional.of(diet));
		when(fooditemrepo.findById(anyInt())).thenReturn(Optional.of(food));
		when(dietrepository.deleteFoodFromDiet(anyInt(), anyInt())).thenReturn(1);
		assertEquals(food,dietservice.removeFoodItemFromDietService(12, 13));	
	}
	@Test
	void testdeleteDietService() {
		
		
		when(customerepo.findByUsername(anyString())).thenReturn(c1);
		when(dietrepository.findById(anyInt())).thenReturn(Optional.of(diet));
		when(dietrepository.deleteDietById(anyInt())).thenReturn(1);
		assertEquals(diet,dietservice.deleteDietService("Rakesh", 12));	
		
	}
	@Test
	void testgetTotalCaloriesService() {

		when(customerepo.findByUsername(anyString())).thenReturn(c1);
		when(dietrepository.findById(anyInt())).thenReturn(Optional.of(diet));
		assertEquals(1100,dietservice.getTotalCaloriesService("Rakesh",11));
		
	}
	@Test
	void testaddDietByUserIdService() {
		Diet d5= new Diet(ConsumeTime.FASTING,DayOfWeek.MONDAY);
		d5.setDate();
		d5.setDietId(13);
		d5.setCustomer(c1);
		c1.setDiet(dietlist);
		Iterable dd1= dietlist;
		List<Diet> sameTimeDiets = dietlist.stream().filter(d->(d.getDate().equals(d5.getDate()))).toList();
		List<Diet> conflictDiet = sameTimeDiets.stream().filter(sd->(sd.getConsumeTime().equals(d5.getConsumeTime())
				&& sd.getDayOfWeek().equals(d5.getDayOfWeek()))).toList();
		when(customerepo.findByUsername(anyString())).thenReturn(c1);
		when(dietrepository.saveAll(any())).thenReturn(dd1);
		
		assertEquals(d5,dietservice.addDietByUserIdService("Rakesh", d5));
		
		
	}
	
	
	@Test
	void testaddFoodItemToDietService() {
		Diet d5= new Diet(ConsumeTime.BREAKFAST,DayOfWeek.WEDNESDAY);
		d5.setDietId(12);
		d5.setMealList(meallist);
		FoodItem f4= new FoodItem("Cooked potato", "100g", 600);
		f4.setFoodId(15);
		d5.setMealList(meallist);
		when(dietrepository.findById(anyInt())).thenReturn(Optional.of(d5));
		when(fooditemrepo.findById(anyInt())).thenReturn(Optional.of(f4));
		when(mealrepo.saveAll(any())).thenReturn(meallist);
		assertEquals(f4,dietservice.addFoodItemToDietService(12, 15));
	}
	
	
	
}
