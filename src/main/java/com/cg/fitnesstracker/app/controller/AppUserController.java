package com.cg.fitnesstracker.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.service.AppUserService;

@RestController
@RequestMapping("/user/update")
public class AppUserController {
	@Autowired
	private AppUserService appUserService;
	
	@PostMapping(value = "/email",produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	public ResponseEntity<AppUser> updateEmail(int userId, String email){
		return new ResponseEntity<AppUser>(appUserService.updateCustomerEmailService(email,userId),HttpStatus.OK);
	}

	@PostMapping(value = "/password",produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	public ResponseEntity<AppUser> updatePassword(int userId, String password){
		return new ResponseEntity<AppUser>(appUserService.updateCustomerPasswordService(password,userId),HttpStatus.OK);
	}
}
