package com.cg.fitnesstracker.app.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.repository.ActivityRepository;
import com.cg.fitnesstracker.app.repository.AppUserRepository;
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
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Transactional
	@Override
	public AppUser updateCustomerEmailService(String email,String username) {
		AppUser appUser = appUserRepository.findByUsername(username);
		int c = customerRepository.updateCustomerEmail(email,appUser.getUserId());
		if(c>0)
			return customerRepository.findById(appUser.getUserId()).get();
		throw new RuntimeException("Can't update");
	}
	
	@Override
	public Customer addCustomerDetailService(String username, Customer customer) {
		AppUser appUser = appUserRepository.findByUsername(username);
		System.out.println(appUser.getUsername());
		System.out.println(customer.getUserEmail());
		System.out.println(appUser.getUserId());
		int c =customerRepository.addCustomerDetails(customer.getActive(),customer.getAge(),customer.getBodyType().toString(),customer.getGender().toString(),customer.getHeight(),customer.getUserEmail(),customer.getWeight(),appUser.getUserId());
		System.out.println(c);
		if(c>0)
			return customerRepository.findById(appUser.getUserId()).get();
		throw new RuntimeException("Can't update");
	}

	@Override
	@Transactional
	public Customer updateCustomerWeightService(String username, float updatedWeight) {
		int c = customerRepository.updateWeight(username, updatedWeight);
		if(c>0) {
			Customer cust = customerRepository.findByUsername(username);
			return cust;
		}
		throw new RuntimeException("Can't update");
	}

	@Override
	@Transactional
	public Customer updateCustomerHeightService(String username, float updatedHeight) {
		int c = customerRepository.updateHeight(username, updatedHeight);
		if(c>0) {
			Customer cust = customerRepository.findByUsername(username);
			return cust;
		}
		throw new RuntimeException("Can't update");
	}
	
	@Override
	public Customer toggleCustomerStatus(String userName) {
		Customer customer=customerRepository.findByUsername(userName);
		
		return null;
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
