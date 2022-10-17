package com.cg.fitnesstracker.app.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.repository.AdminRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.service.AdminService;

@Component
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Admin addAdminDetailService(int userId, Admin admin) {
		Admin ad =adminRepository.findById(userId).get();
		return ad;
	}

	@Override
	public List<Customer> readAllCustomerDetailService() {
		List<Customer> custList = new ArrayList<>();
		Iterable<Customer> customer = customerRepository.findAll();
		customer.forEach(c->custList.add(c));
		return custList;
	}

	@Override
	public Customer readCustomerDetailByIdService(int userId) {
		Customer cust = customerRepository.findById(userId).get();
		if(cust!=null) {
			return cust;
		}
		throw new RuntimeException("User Id is incorrect");
	}

	@Override
	public Customer deleteCustomerByIdService(int userId) {
		Customer cust = readCustomerDetailByIdService(userId);
		if(cust!=null) {
			customerRepository.deleteById(userId);
		}
		return cust;
	}

}
