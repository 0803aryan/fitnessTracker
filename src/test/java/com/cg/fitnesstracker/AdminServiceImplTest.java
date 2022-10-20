package com.cg.fitnesstracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.repository.AdminRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.service.implementation.AdminServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AdminServiceImplTest {
	@Mock
	private AdminRepository adminRepo;
	
	@Mock
	private CustomerRepository customerRepo;
	@InjectMocks
	private AdminServiceImpl adminServiceImpl;
	
	@BeforeEach
	final void setup()
	{
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	final void addAdminDetailServiceTest()
	{
		Admin ad=new Admin();
		ad.setAdminName("archit");
		when(adminRepo.findById(anyInt())).thenReturn(Optional.of(ad));
		when(adminRepo.save(any())).thenReturn(ad);
		
		assertEquals(ad,adminServiceImpl.addAdminDetailService(1, ad));
	}
	
	@Test
	final void readAllCustomerDetailsServiceImplTest()
	{
		List<Customer> custList = new ArrayList<>();
		Customer c1=new Customer();
		Customer c2=new Customer();
		custList.add(c1);
		custList.add(c2);
		Iterable<Customer> I=custList;
		when(customerRepo.findAll()).thenReturn(I);
		assertEquals(custList, adminServiceImpl.readAllCustomerDetailService());
	}
	@Test
	final void readAllCustomerDetailByIdServiceImplTest()
	{
		Customer c1=new Customer();

		when(customerRepo.findById(anyInt())).thenReturn(Optional.of(c1));
		assertEquals(c1, adminServiceImpl.readCustomerDetailByIdService(1));
	}
	@Test
	final void deleteCustomerByIdServiceImplTest()
	{
		Customer c1=new Customer();

		when(customerRepo.findById(anyInt())).thenReturn(Optional.of(c1));
		adminServiceImpl.deleteCustomerByIdService(1);
		verify(customerRepo).deleteById(anyInt());
	}
}
