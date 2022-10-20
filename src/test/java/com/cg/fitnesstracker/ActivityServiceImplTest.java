package com.cg.fitnesstracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.repository.ActivityRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.service.implementation.ActivityServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ActivityServiceImplTest {
	@Mock
	private CustomerRepository customerRepo;
	@Mock
	private ActivityRepository activityRepo;
	
	@InjectMocks
	private ActivityServiceImpl activityServiceImpl;
	
	@Test
	final void addCardioActivityServiceTest()
	{
		Customer c=new Customer();
		c.setUsername("arc");
		Activity a=new Activity();
		List<Activity> act=new ArrayList<>();
		act.add(new Activity());
		act.add(new Activity());
		
		c.setActivities(act);
		when(customerRepo.findByUsername(anyString())).thenReturn(c);
		when(activityRepo.saveAll(any())).thenReturn(act);
		assertEquals(a, activityServiceImpl.addCardioActivityService("arc", a));
	}
	
	@Test
	final void addWorkoutActivityServiceTest()
	{
		Customer c=new Customer();
		c.setUsername("arc");
		Activity a=new Activity();
		List<Activity> act=new ArrayList<>();
		act.add(new Activity());
		act.add(new Activity());
		
		c.setActivities(act);
		when(customerRepo.findByUsername(anyString())).thenReturn(c);
		when(activityRepo.saveAll(any())).thenReturn(act);
		assertEquals(a, activityServiceImpl.addWorkoutActivityService("arc", a));
	}
	@Test
	final void deleteActivityTest()
	{
		Customer c=new Customer();
		c.setUsername("arc");
		Activity a=new Activity();
		a.setActivityId(1);
		when(activityRepo.findById(anyInt())).thenReturn(Optional.of(a));
		assertEquals(a, activityServiceImpl.deleteActivity("arc", 1));
	}
	@Test
	final void getActivityTest()
	{
		Customer c=new Customer();
		c.setUsername("arc");
		Activity a=new Activity();
		List<Activity> act=new ArrayList<>();
		act.add(new Activity());
		act.add(new Activity());		
		c.setActivities(act);
		when(customerRepo.findByUsername(anyString())).thenReturn(c);
		assertEquals(act, activityServiceImpl.getActivity("arc"));
		
	}
}
