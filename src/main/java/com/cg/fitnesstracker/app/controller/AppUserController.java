package com.cg.fitnesstracker.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.fitnesstracker.app.dto.UpdatePasswordDto;
import com.cg.fitnesstracker.app.exceptions.ApplicationException;
import com.cg.fitnesstracker.app.dto.UpdateEmailDto;
import com.cg.fitnesstracker.app.dto.UpdatePasswordDto;
import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.service.AppUserService;


@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/fitness/user")
public class AppUserController {
	@Autowired
	private AppUserService appUserService;
	
	//To add app user details
	@PostMapping(produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	public ResponseEntity<AppUser> addAppUser(@RequestBody AppUser appUser){
		return new ResponseEntity<AppUser>(appUserService.addAppUserService(appUser),HttpStatus.OK);
	}
	
	//to update app user password
	@PutMapping(value = "/password",produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	@PreAuthorize("hasAnyRole('Admin','Customer')")
	public ResponseEntity<AppUser> updatePassword(Principal p,@RequestBody UpdatePasswordDto updatePasswordDto){
		AppUser appUser = appUserService.updateCustomerPasswordService(updatePasswordDto.getNewPassword(),p.getName());
		return new ResponseEntity<AppUser>(appUser,HttpStatus.OK);
	}
}
