package com.cg.fitnesstracker.app.service;

import java.util.List;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;

public interface CustomerService {
	
	public AppUser addCustomerDetailService(String username,Customer customer);

	public Customer updateCustomerWeightService(String username, float weight);

	public Customer updateCustomerHeightService(String username, int height);
	
	public Customer getCustomerService(String username);

	public Customer updateCustomerEmailService(String username,String email);

	//public Customer updateCustomerActivityStatusService(String username, boolean active);

}