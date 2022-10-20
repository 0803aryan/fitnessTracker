package com.cg.fitnesstracker.app.service.implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.repository.AppUserRepository;
import com.cg.fitnesstracker.app.service.AppUserService;
import com.cg.fitnesstracker.app.repository.*;
@Component
public class AppUserServiceImpl implements AppUserService{
	@Autowired
	private AppUserRepository appUserRepository;


	@Override
	public AppUser addAppUserService(AppUser appUser) {
		AppUser user = appUserRepository.save(appUser);
		return user;
	}
	
	@Transactional
	@Override
	public AppUser updateCustomerPasswordService(String password, String username) {
		AppUser appUser = appUserRepository.findByUsername(username);
		int c=appUserRepository.updatePassword(password,appUser.getUserId());
		if(c>0) 
			return appUserRepository.findById(appUser.getUserId()).get();
		throw new RuntimeException("Can't update");
	}
}
