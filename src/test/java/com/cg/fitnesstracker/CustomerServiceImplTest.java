package com.cg.fitnesstracker;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.enums.BodyType;
import com.cg.fitnesstracker.app.model.enums.Gender;
import com.cg.fitnesstracker.app.repository.ActivityRepository;
import com.cg.fitnesstracker.app.repository.AppUserRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.repository.DietRepository;
import com.cg.fitnesstracker.app.service.implementation.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomerServiceImplTest {
	@Mock
	private CustomerRepository customerRepo;
	@Mock
	private ActivityRepository activityRepo;
	@Mock
	private DietRepository dietRepo;
	@Mock
	private AppUserRepository appUserRepo;
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	@BeforeEach
	final void setup()
	{
		
	}
	
	@Test
	final void updateCustomerEmailService()
	{
		AppUser appUser=new AppUser();
		appUser.setUserId(1);
		Customer c=new Customer();
		c.setUserEmail("abc");
		when(appUserRepo.findByUsername(anyString())).thenReturn(appUser);
		when(customerRepo.updateCustomerEmail(anyString(), anyInt())).thenReturn(1);
		when(customerRepo.findById(anyInt())).thenReturn(Optional.of(c));
		assertEquals(c, customerServiceImpl.updateCustomerEmailService("arc", "arc@a.com"));
	}
	
	@Test
	final void updateCustomerWeightServiceTest()
	{
		AppUser appUser=new AppUser();
		appUser.setUsername("arc");
		appUser.setUserId(1);
		Customer c=new Customer();
		c.setUserId(1);
		c.setWeight(22);
		c.setUserEmail("abc");
		when(appUserRepo.findByUsername(anyString())).thenReturn(appUser);
		when(customerRepo.findById(anyInt())).thenReturn(Optional.of(c));
		when(customerRepo.updateWeight(anyInt(), anyFloat())).thenReturn(1);
		assertEquals(c, customerServiceImpl.updateCustomerWeightService("arc", 1));
	}
	
	@Test
	final void updateCustomerHeightServiceTest()
	{
		AppUser appUser=new AppUser();
		appUser.setUsername("arc");
		appUser.setUserId(1);
		Customer c=new Customer();
		c.setUserId(1);
		c.setHeight(22);
		c.setUserEmail("abc");
		when(appUserRepo.findByUsername(anyString())).thenReturn(appUser);
		when(customerRepo.findById(anyInt())).thenReturn(Optional.of(c));
		when(customerRepo.updateHeight(anyInt(), anyInt())).thenReturn(1);
		assertEquals(c, customerServiceImpl.updateCustomerHeightService("arc", 1));
	}
	@Test
	final void addCustomerDetailServiceTest()
	{
		AppUser appUser=new AppUser();
		appUser.setUsername("arc");
		appUser.setUserId(1);
		Customer c=new Customer();
		c.setAge(12);
		c.setBodyType(BodyType.ENDOMORPH);
		c.setGender(Gender.MALE);
		c.setActive(true);
		c.setUserId(1);
		c.setHeight(22);
		c.setUserEmail("abc");
		when(appUserRepo.findByUsername(anyString())).thenReturn(appUser);
		when(customerRepo
				.addCustomerDetails(anyBoolean(), anyInt(), anyString(), anyString(), anyInt(), anyString(), anyFloat(), anyInt()))
				.thenReturn(1);
		assertEquals(appUser, customerServiceImpl.addCustomerDetailService("arc", c));
	}

}
