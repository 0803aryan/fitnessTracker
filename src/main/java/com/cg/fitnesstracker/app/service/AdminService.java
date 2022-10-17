package com.cg.fitnesstracker.app.service;

import java.util.List;

import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.model.Customer;

public interface AdminService {
	
	public Admin addAdminDetailService(int userId,Admin admin);
	
	//inject customerRepository to get all customers
	public List<Customer> readAllCustomerDetailService();
	
	public Customer readCustomerDetailByIdService(int userId);
	
	public Customer deleteCustomerByIdService(int userId);
}
