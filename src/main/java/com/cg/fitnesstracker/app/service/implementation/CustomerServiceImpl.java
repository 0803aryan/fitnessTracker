package com.cg.fitnesstracker.app.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.repository.ActivityRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.repository.DietRepository;
import com.cg.fitnesstracker.app.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private DietRepository dietRepository;
	
	@Transactional
	@Override
	public AppUser updateCustomerEmailService(String email,int userId) {

		int c = customerRepository.updateCustomerEmail(email,userId);
		if(c>0)
			return customerRepository.findById(userId).get();
		throw new RuntimeException("Can't update");
	}
	
	@Override
	public Customer addCustomerDetailService(Customer customer) {
		Customer cust = customerRepository.save(customer);
		return cust;
	}

	@Override
	@Transactional
	public Customer updateCustomerWeightService(String userName, float updatedWeight) {
		int c = customerRepository.updateWeight(userName, updatedWeight);
		if(c>0) {
			Customer cust = customerRepository.findByUserName(userName);
			return cust;
		}
		throw new RuntimeException("Can't update");
	}

	@Override
	@Transactional
	public Customer updateCustomerHeightService(String userName, float updatedHeight) {
		int c = customerRepository.updateHeight(userName, updatedHeight);
		if(c>0) {
			Customer cust = customerRepository.findByUserName(userName);
			return cust;
		}
		throw new RuntimeException("Can't update");
	}

  /*
	@Override

	public Customer updateCustomerActivityStatusService(String userName, boolean updatedActivityStatus) {
		int c =customerRepository.updateActivityStatus(userName, updatedActivityStatus);
		if(c>0) {
			Customer cust = customerRepository.findByUserName(userName);
			return cust;
		}
		throw new RuntimeException("Can't Update");
	}
	*/

}
