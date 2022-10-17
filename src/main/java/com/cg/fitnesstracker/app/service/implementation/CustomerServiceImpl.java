package com.cg.fitnesstracker.app.service.implementation;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService{

	@Override
	public List<Activity> addActivity(String userName, Activity activity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diet> addDiet(String userName, Diet diet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addCustomerDetailService(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomerWeightService(String userName, float weight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomerHeightService(String userName, float height) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomerActivityStatusService(String userName, boolean active) {
		// TODO Auto-generated method stub
		return null;
	}

}
