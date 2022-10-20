package com.cg.fitnesstracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.repository.ActivityRepository;
import com.cg.fitnesstracker.app.repository.CardioRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.repository.DietRepository;
import com.cg.fitnesstracker.app.repository.WorkoutRepository;
import com.cg.fitnesstracker.app.service.implementation.ActivityServiceImpl;
import com.cg.fitnesstracker.app.service.implementation.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ActivityServiceImplTest {
	@Mock
	private CustomerRepository customerRepo;
	@Mock
	private ActivityRepository activityRepo;
	@Mock
	private WorkoutRepository workoutRepo;
	@Mock
	private CardioRepository cardiorepo;
	@InjectMocks
	private ActivityServiceImpl activityServiceImpl;
	@BeforeEach
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	final void addCardioActivityServiceTest()
	{
		Customer c1=new Customer();
		c1.setUserName("archit");
		
		List<Activity> alist=new ArrayList<>();
		alist.add(new Activity());
		c1.setActivities(alist);
		Activity cardioActivity=new Activity();
		cardioActivity.setActivityId(1);
		cardioActivity.setCustomer(c1);
		alist.add(cardioActivity);
		Iterable activityList=alist;
		when(customerRepo.findByUserName(anyString())).thenReturn(c1);
		when(activityRepo.saveAll(any())).thenReturn(activityList);
		assertEquals(cardioActivity, activityServiceImpl.addCardioActivityService("archit", cardioActivity));
	}
	@Test
	final void addWorkoutActivityServiceTest()
	{
		Customer c1=new Customer();
		c1.setUserName("archit");
		
		List<Activity> alist=new ArrayList<>();
		alist.add(new Activity());
		c1.setActivities(alist);
		Activity workoutActivity=new Activity();
		workoutActivity.setActivityId(1);
		workoutActivity.setCustomer(c1);
		alist.add(workoutActivity);
		Iterable activityList=alist;
		when(customerRepo.findByUserName(anyString())).thenReturn(c1);
		when(activityRepo.saveAll(any())).thenReturn(activityList);
		assertEquals(workoutActivity, activityServiceImpl.addCardioActivityService("archit", workoutActivity));
	}

}
