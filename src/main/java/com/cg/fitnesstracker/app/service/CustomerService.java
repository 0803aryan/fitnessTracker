package com.cg.fitnesstracker.app.service;

import java.util.List;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;

public interface CustomerService {
	
	public List<Activity> addActivity(String userName, Activity activity);
	
	public List<Diet> addDiet(String userName, Diet diet);

	public Customer addCustomerDetailService(Customer customer);

	public Customer updateCustomerWeightService(String userName, float weight);

	public Customer updateCustomerHeightService(String userName, float height);

	public Customer updateCustomerActivityStatusService(String userName, boolean active);
}