package com.cg.fitnesstracker.app.service.implementation;
import com.cg.fitnesstracker.app.service.AppUserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.service.AppUserService;
import com.cg.fitnesstracker.app.repository.*;

public class AppUserServiceImpl implements AppUserService{
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Transactional
	@Override
	public AppUser updateCustomerEmailService(String email,int userId) {

		int c=0;
		try {
			c = appUserRepository.updateEmail(email,userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c>0) {
			AppUser a = appUserRepository.findById(userId).get();
			return a;
		}
		throw new RuntimeException("Can't update");
	}
	@Transactional
	@Override
	public AppUser updateCustomerPasswordService(String password, int userId) {
		int c=0;
		try {
			c = appUserRepository.updatePassword(password,userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c>0) {
			AppUser a = appUserRepository.findById(userId).get();
			return a;
		}
		throw new RuntimeException("Can't update");
	}

}
