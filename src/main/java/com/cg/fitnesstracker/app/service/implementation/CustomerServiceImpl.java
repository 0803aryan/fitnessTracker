package com.cg.fitnesstracker.app.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.exceptions.ApplicationException;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.repository.AppUserRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AppUserRepository appUserRepository;
	
	//To update customer email service
	@Transactional
	@Override
	public Customer updateCustomerEmailService(String username,String email) {
		AppUser appUser = appUserRepository.findByUsername(username);
		int c = customerRepository.updateCustomerEmail(email,appUser.getUserId());
		if(c>0) {
			Customer cust = customerRepository.findById(appUser.getUserId()).get();
			if(cust!=null) {
				return cust;
			}
			throw new ApplicationException("Unable to find Customer ",404);
		}
			
		throw new ApplicationException("Can't update",400);
	}
	
	//To add customer details
	@Override
	public AppUser addCustomerDetailService(String username, Customer customer) {
		AppUser appUser = appUserRepository.findByUsername(username);
		System.out.println(appUser.getUsername());
		System.out.println(customer.getUserEmail());
		System.out.println(appUser.getUserId());
		int c =customerRepository.addCustomerDetails(customer.getActive(),customer.getAge(),customer.getBodyType().toString(),customer.getGender().toString(),customer.getHeight(),customer.getUserEmail(),customer.getWeight(),appUser.getUserId());
		System.out.println(c);
		if(c>0) {
			AppUser user = appUserRepository.findByUsername(appUser.getUsername());
		if(user!=null) {
			return user;
		}
		throw new ApplicationException("Unable to find Customer ",404);
	}
		
	throw new ApplicationException("Can't update",400);
	}

	//To update customer weight
	@Override
	public Customer updateCustomerWeightService(String username, float updatedWeight) {
		AppUser appUser =appUserRepository.findByUsername(username);
		Optional<Customer> cust = customerRepository.findById(appUser.getUserId());
		if(cust.isPresent()) {
			Customer c = cust.get();
			System.out.println(c.getUserId()+c.getWeight());
			System.out.println(updatedWeight);
		}
		int c = customerRepository.updateWeight(appUser.getUserId(), updatedWeight);
		System.out.println(c);
		if(c>0) {
			Customer cust1 = customerRepository.findById(appUser.getUserId()).get();
			return cust1;
		}
		throw new ApplicationException("Can't update",400);
	}
	
	//To update customer height
	@Override
	@Transactional
	public Customer updateCustomerHeightService(String username, int updatedHeight) {
		AppUser appUser =appUserRepository.findByUsername(username);
		System.out.println(updatedHeight);
		int c = customerRepository.updateHeight(appUser.getUserId(), updatedHeight);
		if(c>0) {
			Customer cust = customerRepository.findById(appUser.getUserId()).get();
			return cust;
		}
		throw new ApplicationException("Can't update",400);
	}
	
	//To get customer
	@Override
	public Customer getCustomerService(String username) {
		Customer cust = customerRepository.findByUsername(username);
		if (cust!=null) {
			return cust;
		}
		throw new ApplicationException("Can't update",400);
	}
	
	//To toggle customer status
	@Override
	public Customer toggleCustomerStatus(String userName) {
//		Customer customer=customerRepository.findByUsername(userName);
		
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
