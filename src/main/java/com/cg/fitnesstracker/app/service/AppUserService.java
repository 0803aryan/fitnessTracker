package com.cg.fitnesstracker.app.service;

import java.util.List;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;

public interface AppUserService {
	public Customer updateCustomerEmailService(String userName,String email);
	public Customer updateCustomerPasswordService(String userName,String password);
	

}
