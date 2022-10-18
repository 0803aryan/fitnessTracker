package com.cg.fitnesstracker.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.service.AdminService;
import com.cg.fitnesstracker.app.service.CustomerService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	public ResponseEntity<Admin> addAdmin(int userId, @RequestBody Admin ad){
		return new ResponseEntity<Admin>(adminService.addAdminDetailService(userId, ad),HttpStatus.OK);
	}
	
	@GetMapping(value = "/readAllCustomers", produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	public ResponseEntity<List<Customer>> readAllCustomer() {
		List<Customer> custList = adminService.readAllCustomerDetailService();
		return new ResponseEntity<List<Customer>>(custList,HttpStatus.OK);	
	}
	
	@GetMapping(value="/readCustomerById/{userId}", produces = {"application/json","application/xml"})
	public ResponseEntity<Customer> readCustomerDetailById(@PathVariable int userId){
		Customer cust = adminService.readCustomerDetailByIdService(userId);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteCustomerById/{userId}",  produces = {"application/json","application/xml"})
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable int userId){
		Customer cust = adminService.deleteCustomerByIdService(userId);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
}
