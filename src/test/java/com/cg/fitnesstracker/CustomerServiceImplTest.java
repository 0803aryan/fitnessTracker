package com.cg.fitnesstracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.repository.ActivityRepository;
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
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	@BeforeEach
	final void setup()
	{
		
	}
	
	@Test
	final void addCustomerDetailService()
	{
		Customer c1=new Customer();
		when(customerRepo.save(any())).thenReturn(c1);
		assertEquals(c1,customerServiceImpl.addCustomerDetailService(c1));
	}
	
	@Test
	final void updateCustomerWeightServiceTest()
	{
		Customer c1=new Customer();
		when(customerRepo.findByUserName(any())).thenReturn(c1);
		when(customerRepo.updateWeight(anyString(), anyFloat())).thenReturn(1);
		assertEquals(c1, customerServiceImpl.updateCustomerWeightService("arc", 1));
	}
	
	@Test
	final void updateCustomerHeightServiceTest()
	{
		Customer c1=new Customer();
		when(customerRepo.findByUserName(any())).thenReturn(c1);
		when(customerRepo.updateHeight(anyString(), anyFloat())).thenReturn(1);
		assertEquals(c1, customerServiceImpl.updateCustomerHeightService("arc", 1));
	}

}
