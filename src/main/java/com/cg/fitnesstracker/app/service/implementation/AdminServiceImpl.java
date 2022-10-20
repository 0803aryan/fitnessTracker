package com.cg.fitnesstracker.app.service.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.exceptions.ApplicationException;
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
	
	//To add admin details
	@Override
	public AppUser addAdminDetailService(String username, Admin admin) {
		AppUser appUser = appUserRepository.findByUsername(username);
		System.out.println(appUser.getUsername());
		System.out.println(admin.getAdminName());
		System.out.println(admin.getUserEmail());
		System.out.println(appUser.getUserId());
		int c = adminRepository.addAdminDetails(admin.getAdminName(), admin.getUserEmail(), appUser.getUserId());
		System.out.println(c);
		if(c>0) {
			AppUser user = appUserRepository.findByUsername(appUser.getUsername());

			if(admin!=null) {
				return user;
			}
			else
			{
				throw new ApplicationException("Unable to find Admin ",404);
			}
		}
		throw new ApplicationException("Can't update",400);
	}
	
	//To get all customers
	@Override
	public List<Customer> readAllCustomerDetailService() {
		List<Customer> custList = new ArrayList<>();
		Iterable<Customer> customer = customerRepository.findAll();
		customer.forEach(c->custList.add(c));
		return custList;
	}
	
	//To get customer by username 
	@Override
	public Customer readCustomerDetailByIdService(String username) {
		AppUser appUser = appUserRepository.findByUsername(username);
		Customer cust = customerRepository.findById(appUser.getUserId()).get();
		if(cust!=null) {
			return cust;
		}
		throw new ApplicationException("User Id is incorrect",400);
	}
	
	// To delete customer by username
	@Override
	public Customer deleteCustomerByIdService(String username) {
		Customer cust = readCustomerDetailByIdService(username);
		AppUser appUser = appUserRepository.findByUsername(username);
		if(cust!=null) {
			customerRepository.deleteById(appUser.getUserId());
		}
		return cust;
	}
	//To get admin by userId
	@Override
	public Admin getAdminByIdService(int userId) {
		Admin ad = adminRepository.findById(userId).get();
		if(ad!=null) {
			return ad;
		}
		throw new ApplicationException("No admin found", 404);
	}

	//To update admin email
	@Override
	@Transactional
	public Admin updateAdminEmailService(String newEmail,String username) {
		AppUser appUser =appUserRepository.findByUsername(username);
		System.out.println(newEmail);
		System.out.println(appUser.getUserId());
		int c = adminRepository.updateAdminEmail(newEmail,appUser.getUserId());
		System.out.println(c);
		if(c>0)
			return getAdminByIdService(appUser.getUserId());
		throw new ApplicationException("User not found. Can't update",404);

	}

}
