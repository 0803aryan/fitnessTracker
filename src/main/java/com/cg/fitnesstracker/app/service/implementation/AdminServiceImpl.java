package com.cg.fitnesstracker.app.service.implementation;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.repository.AdminRepository;
import com.cg.fitnesstracker.app.repository.AppUserRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.service.AdminService;

@Component
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	
	public Admin addAdminDetailService(String username, Admin admin) {
		AppUser appUser = appUserRepository.findByUsername(username);
		System.out.println(appUser.getUsername());
		System.out.println(admin.getAdminName());
		System.out.println(admin.getUserEmail());
		System.out.println(appUser.getUserId());
		int c = adminRepository.addAdminDetails(admin.getAdminName(), admin.getUserEmail(), appUser.getUserId());
		System.out.println(c);
		if(c>0) {
			admin = adminRepository.findById(appUser.getUserId()).get();
			if(admin!=null) {
				return admin;
			}
		}
		throw new RuntimeException("Can't update");
	}

	@Override
	public List<Customer> readAllCustomerDetailService() {
		List<Customer> custList = new ArrayList<>();
		Iterable<Customer> customer = customerRepository.findAll();
		customer.forEach(c->custList.add(c));
		return custList;
	}

	@Override
	public Customer readCustomerDetailByIdService(String username) {
		AppUser appUser = appUserRepository.findByUsername(username);
		Customer cust = customerRepository.findById(appUser.getUserId()).get();
		if(cust!=null) {
			return cust;
		}
		throw new RuntimeException("User Id is incorrect");
	}

	@Override
	public Customer deleteCustomerByIdService(String username) {
		Customer cust = readCustomerDetailByIdService(username);
		AppUser appUser = appUserRepository.findByUsername(username);
		if(cust!=null) {
			customerRepository.deleteById(appUser.getUserId());
		}
		return cust;
	}
	
	@Transactional
	@Override
	public AppUser updateAdminEmailService(String email,String username) {
		AppUser appUser = appUserRepository.findByUsername(username);
		int c = adminRepository.updateAdminEmail(email,appUser.getUserId());
		if(c>0)
			return adminRepository.findById(appUser.getUserId()).get();
		throw new RuntimeException("Can't update");
	}

}
