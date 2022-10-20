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
	public AppUser addCustomerDetailService(String username,Customer customer);

	public Customer updateCustomerWeightService(String username, float weight);

	public Customer updateCustomerHeightService(String username, int height);
	
	public Customer updateCustomerEmailService(String username,String email);

	//public Customer updateCustomerActivityStatusService(String username, boolean active);

}