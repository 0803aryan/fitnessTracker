package com.cg.fitnesstracker.app.service;

import java.util.List;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;

public interface CustomerService {
	
	/*public List<Activity> addActivity(String username, Activity activity);
	
	public List<Diet> addDiet(String username, Diet diet);
	*/
	public Customer addCustomerDetailService(String username,Customer customer);

	public Customer updateCustomerWeightService(String username, float weight);

	public Customer updateCustomerHeightService(String username, float height);
	
	public AppUser updateCustomerEmailService(String email,String username);

	//public Customer updateCustomerActivityStatusService(String username, boolean active);

}