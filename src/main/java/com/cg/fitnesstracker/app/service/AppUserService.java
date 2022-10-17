package com.cg.fitnesstracker.app.service;

import java.util.List;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;

public interface AppUserService {
	public Customer updateCustomerEmailService(Customer customer, Boolean active);
	public Customer updateCustomerPasswordService(Customer customer, Boolean active);
	

}
