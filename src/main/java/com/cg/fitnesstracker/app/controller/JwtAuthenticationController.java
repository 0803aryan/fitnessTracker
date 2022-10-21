package com.cg.fitnesstracker.app.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.config.JwtTokenUtil;
import com.cg.fitnesstracker.app.dto.UserDto;
import com.cg.fitnesstracker.app.exceptions.ApplicationException;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.JwtRequest;
import com.cg.fitnesstracker.app.model.JwtResponse;
import com.cg.fitnesstracker.app.service.AppUserService;
import com.cg.fitnesstracker.app.service.implementation.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private AppUserService appUserService;
	
	//To login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		try {
			
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		}catch(Exception e){
			throw new ApplicationException("Enter valid credentials",404);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	//To register a user
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
		
		
		List<AppUser> userList = appUserService.getAllAppUsers();
		List<String> usernames = new ArrayList<>();
		List<String> roles =new ArrayList<>();
		roles.add("Admin");
		roles.add("Customer");
		userList.forEach(u->usernames.add(u.getUsername()));
	
		if(usernames.contains(user.getUserName())) {
			System.out.println(user.getUserName());
			throw new ApplicationException("User already exist, please choose a different username",400);
		}
		if(!roles.contains(user.getRole())) {
			throw new ApplicationException("Please select the valid Role",400);
		}
		if(user.getUserName().length()<1) {
			throw new ApplicationException("Enter valid username",400);
		}
		if(user.getPassword().length()<1) {
			throw new ApplicationException("Enter valid Password",400);
		}
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
