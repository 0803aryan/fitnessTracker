package com.cg.fitnesstracker.app.controller;

import java.security.Principal;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.dto.UpdateEmailDto;
import com.cg.fitnesstracker.app.exceptions.ApplicationException;
import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.repository.AppUserRepository;
import com.cg.fitnesstracker.app.service.AdminService;
import com.cg.fitnesstracker.app.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/fitness/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private CustomerService customerService;
	
	//To add admin details
	@PostMapping(produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<AppUser> addAdmin(Principal p, @RequestBody Admin ad){
		Pattern pattern =Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
		Matcher m=pattern.matcher(ad.getUserEmail());
		if(!m.find()) {
			throw new ApplicationException("Please enter a valid email",400);
		}
		
		if(ad.getAdminName().length()<1) {
			throw new ApplicationException("Please enter valid Admin Name",400);
		}
		return new ResponseEntity<AppUser>(adminService.addAdminDetailService(p.getName(),ad),HttpStatus.OK);
	}
	
	//To add customer details
	@GetMapping(value = "/customers", produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<List<Customer>> readAllCustomer() {
		List<Customer> custList = adminService.readAllCustomerDetailService();
		if(custList.size() == 0) {
			throw new ApplicationException("No Customer Exist",404);
		}
		return new ResponseEntity<List<Customer>>(custList,HttpStatus.OK);	
	}
	
	//To get customer with given username
	@GetMapping(value="/customer/{username}", produces = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Customer> readCustomerDetailById(@PathVariable String username){
		List<Customer> custList = adminService.readAllCustomerDetailService();
		if(!custList.contains(username)) {
			throw new ApplicationException("Customer doesn't exist with this user Name, Please enter a valid Username",404);
		}
		Customer cust = adminService.readCustomerDetailByIdService(username);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	//To delete customer with given username
	@DeleteMapping(value = "/customer/{username}",  produces = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable String username){
		List<Customer> custList = adminService.readAllCustomerDetailService();
		if(!custList.contains(username)) {
			throw new ApplicationException("Customer doesn't exist with this user Name, Please enter a valid Username",404);
		}
		Customer cust = adminService.deleteCustomerByIdService(username);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	//To update admin email
	@PutMapping(value = "/email",produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Admin> updateEmail(Principal p, @RequestBody UpdateEmailDto updateEmailDto){
		Pattern pattern =Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
		Matcher m=pattern.matcher(updateEmailDto.getNewEmail());
		if(!m.find()) {
			throw new ApplicationException("Please enter a valid email",400);
		}
		Admin admin = adminService.updateAdminEmailService(updateEmailDto.getNewEmail(),p.getName());
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	}
}
