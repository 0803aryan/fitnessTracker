package com.cg.fitnesstracker.app.service.implementation;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.service.AdminService;
@Component
public class AdminServiceImpl implements AdminService{

	@Override
	public Admin addAdminDetailService(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> readAllCustomerDetailService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer readCustomerDetailByIdService(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteCustomerByIdService(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
