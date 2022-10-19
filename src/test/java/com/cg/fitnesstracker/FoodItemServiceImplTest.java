package com.cg.fitnesstracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.repository.AppUserRepository;
import com.cg.fitnesstracker.app.repository.FoodItemRepository;
import com.cg.fitnesstracker.app.service.implementation.AppUserServiceImpl;
import com.cg.fitnesstracker.app.service.implementation.FoodItemServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FoodItemServiceImplTest {
	@Mock
	private FoodItemRepository foodItemRepo;
	@InjectMocks
	private FoodItemServiceImpl foodItemServiceImpl;
	
	@BeforeEach
	final void setup()
	{
		
	}
	@Test
	final void getAllFoodItemServiceTest()
	{
		List<FoodItem> foodItems = new ArrayList();
		Iterable items = foodItems;
		when(foodItemRepo.findAll()).thenReturn(items);
		assertEquals(foodItems, foodItemServiceImpl.getAllFoodItemService());
	}
	@Test
	final void getAllFoodItemByIdServiceTest()
	{
		FoodItem item=new FoodItem();
		when(foodItemRepo.findById(anyInt())).thenReturn(Optional.of(item));
		assertEquals(item, foodItemServiceImpl.getFoodItemByIdService(0));
	}
	
	@Test
	final void getCaloriesServiceTest()
	{
		FoodItem item=new FoodItem();
		item.setFoodId(12);
		item.setCaloriesInFood(100);
		when(foodItemRepo.findById(anyInt())).thenReturn(Optional.of(item));
		assertEquals(item.getCaloriesInFood(), foodItemServiceImpl.getCaloriesService(12));
	
	}
}
