package com.cg.fitnesstracker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import org.junit.runner.RunWith;
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
import com.cg.fitnesstracker.app.model.enums.BodyType;
import com.cg.fitnesstracker.app.model.enums.ConsumeTime;
import com.cg.fitnesstracker.app.model.enums.DayOfWeek;
import com.cg.fitnesstracker.app.model.enums.Gender;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.repository.DietRepository;
import com.cg.fitnesstracker.app.repository.FoodItemRepository;
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
	@InjectMocks
	private DietServiceImpl dietservice;
	private static List<Diet> dietlisT = new ArrayList<>();
	
	@BeforeAll	
	static void setup() {

		Diet d2= new Diet(ConsumeTime.fromInteger(1),DayOfWeek.fromInteger(1));
		Customer c2= new Customer();
		c2.setUserName("Rakeshs");
		d2.setCustomer(c2);
		dietlisT.add(d2);
		c2.setDiet(dietlisT);
		
		
	}
	@Test
	void testGetAllDietServices () {
		Customer c1= new Customer();
		c1.setUserName("Rakesh");
		c1.setGender(Gender.MALE);
		c1.setAge(22);
		c1.setBodyType(BodyType.ENDOMORPH);
		c1.setDiet(dietlisT);
		assertNotNull(dietrepository);
		when(customerepo.findByUserName(anyString())).thenReturn(c1);
		assertEquals(dietlisT,dietservice.getAllDietService("Rakesh"));
	}
	@Test
	void testaddDietByUserIdService() {
		Customer cust= new Customer();
		cust.setUserName("Rakesh");
		cust.setGender(Gender.MALE);
		cust.setAge(22);
		cust.setBodyType(BodyType.ENDOMORPH);
		Diet d4= new Diet(ConsumeTime.fromInteger(0),DayOfWeek.fromInteger(0));
		List<Diet> dietlist = new ArrayList<>();
		dietlist.add(d4);
		cust.setDiet(dietlist);
		Iterable dd1= dietlist;
		when(customerepo.findByUserName(anyString())).thenReturn(cust);
		when(dietrepository.saveAll(any())).thenReturn(dd1);
		assertEquals(d4,dietservice.addDietByUserIdService("rakesh", d4));
		
	}
	@Test
	void testaddFoodItemToDietService() {
		Diet d5= new Diet(ConsumeTime.fromInteger(0),DayOfWeek.fromInteger(0));
		d5.setDietId(12);
		
		FoodItem f4= new FoodItem("Chowmein", "100g", 600);
		f4.setFoodId(13);
		List<FoodItem> foodlist = new ArrayList<>();
		foodlist.add(f4);
		
		Iterable f2= foodlist;
		d5.setFoodList(foodlist);
		when(dietrepository.findById(anyInt())).thenReturn(Optional.of(d5));
		when(fooditemrepo.findById(anyInt())).thenReturn(Optional.of(f4));
		when(fooditemrepo.saveAll(any())).thenReturn(f2);
		assertEquals(f4,dietservice.addFoodItemToDietService(12, 13));
	}
	@Test
	void testremoveFoodItemFromDietService() {
		Diet d5= new Diet(ConsumeTime.fromInteger(0),DayOfWeek.fromInteger(0));
		d5.setDietId(12);
		FoodItem f4= new FoodItem("Chowmein", "100g", 600);
		f4.setFoodId(13);
		List<FoodItem> foodlist = new ArrayList<>();
		foodlist.add(f4);
		Iterable f2= foodlist;
		d5.setFoodList(foodlist);
		when(dietrepository.findById(anyInt())).thenReturn(Optional.of(d5));
		when(fooditemrepo.findById(anyInt())).thenReturn(Optional.of(f4));
		when(dietrepository.deleteFoodFromDiet(anyInt(), anyInt())).thenReturn(1);
		assertEquals(f4,dietservice.removeFoodItemFromDietService(12, 13));	
	}
	@Test
	void testdeleteDietService() {
		Customer cust= new Customer();
		cust.setUserName("Rakesh");
		cust.setGender(Gender.MALE);
		cust.setAge(22);
		cust.setBodyType(BodyType.ENDOMORPH);
		Diet d4= new Diet(ConsumeTime.fromInteger(0),DayOfWeek.fromInteger(0));
		List<Diet> dietlist = new ArrayList<>();
		dietlist.add(d4);
		cust.setDiet(dietlist);
		Iterable dd1= dietlist;
		
		when(customerepo.findByUserName(anyString())).thenReturn(cust);
		when(dietrepository.findById(anyInt())).thenReturn(Optional.of(d4));
		when(dietrepository.deleteDietById(anyInt())).thenReturn(1);
		assertEquals(d4,dietservice.deleteDietService("Rakesh", 12));	
		
	}
	@Test
	void testgetTotalCaloriesService() {
		Customer cust= new Customer();
		cust.setUserName("Rakesh");
		cust.setGender(Gender.MALE);
		cust.setAge(22);
		cust.setBodyType(BodyType.ENDOMORPH);
		Diet d4= new Diet(ConsumeTime.fromInteger(0),DayOfWeek.fromInteger(0));
	
		List<Diet> dietlist = new ArrayList<>();
		dietlist.add(d4);
		cust.setDiet(dietlist);
		Iterable dd1= dietlist;
		FoodItem f4= new FoodItem("Chowmein", "100g", 600);
		f4.setFoodId(13);
		List<FoodItem> foodlist = new ArrayList<>();
		foodlist.add(f4);
		d4.setFoodList(foodlist);
		when(customerepo.findByUserName(anyString())).thenReturn(cust);
		when(dietrepository.findById(anyInt())).thenReturn(Optional.of(d4));
		assertEquals(600,dietservice.getTotalCaloriesService("rakesh",11));
		
	}
	
	
	
}
