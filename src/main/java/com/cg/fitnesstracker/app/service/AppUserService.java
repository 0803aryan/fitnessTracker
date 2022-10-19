package com.cg.fitnesstracker.app.service;

import java.util.List;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;

public interface AppUserService {

	public AppUser addAppUserService(AppUser appUser);
	public AppUser updateCustomerPasswordService(String password,String username);

}
