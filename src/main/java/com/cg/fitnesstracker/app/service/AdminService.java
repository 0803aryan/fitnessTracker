package com.cg.fitnesstracker.app.service;

import java.util.List;

import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;

public interface AdminService {
	
	public Admin addAdminDetailService(String username, Admin admin);
	
	//inject customerRepository to get all customers
	public List<Customer> readAllCustomerDetailService();
	
	public Customer readCustomerDetailByIdService(String username);
	
	public Customer deleteCustomerByIdService(String username);
	
	public Admin updateAdminEmailService(String email,String userName);
}
