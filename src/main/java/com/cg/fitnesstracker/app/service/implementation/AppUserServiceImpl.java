package com.cg.fitnesstracker.app.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.service.AppUserService;
import com.cg.fitnesstracker.app.repository.*;

public class AppUserServiceImpl implements AppUserService{
	@Autowired
	private AppUserRepository appUserRepository;
	@Transactional
	@Override
	public Customer updateCustomerEmailService(String userName,String email) {
		int c=0;
		try {
			c = appUserRepository.updateEmail(userName, email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c>0) {
			Customer cust = appUserRepository.findByUserName(userName);
			return cust;
		}
		throw new RuntimeException("Can't update");
	}
	@Transactional
	@Override
	public Customer updateCustomerPasswordService(String userName, String password) {
		int c=0;
		try {
			c = appUserRepository.updatePassword(userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c>0) {
			Customer cust = appUserRepository.findByUserName(userName);
			return cust;
		}
		throw new RuntimeException("Can't update");
	}

}
