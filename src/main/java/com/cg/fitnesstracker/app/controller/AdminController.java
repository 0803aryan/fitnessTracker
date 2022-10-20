package com.cg.fitnesstracker.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.dto.UpdateEmailDto;
import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.repository.AppUserRepository;
import com.cg.fitnesstracker.app.service.AdminService;
import com.cg.fitnesstracker.app.service.CustomerService;

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
		return new ResponseEntity<AppUser>(adminService.addAdminDetailService(p.getName(),ad),HttpStatus.OK);
	}
	
	//To add customer details
	@GetMapping(value = "/customers", produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<List<Customer>> readAllCustomer() {
		List<Customer> custList = adminService.readAllCustomerDetailService();
		return new ResponseEntity<List<Customer>>(custList,HttpStatus.OK);	
	}
	
	//To get customer with given username
	@GetMapping(value="/customer/{username}", produces = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Customer> readCustomerDetailById(@PathVariable String username){
		Customer cust = adminService.readCustomerDetailByIdService(username);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	//To delete customer with given username
	@DeleteMapping(value = "/customer/{username}",  produces = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable String username){
		Customer cust = adminService.deleteCustomerByIdService(username);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	//To update admin email
	@PutMapping(value = "/email",produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Admin> updateEmail(Principal p, @RequestBody UpdateEmailDto updateEmailDto){
		Admin admin = adminService.updateAdminEmailService(updateEmailDto.getNewEmail(),p.getName());
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	}
}
