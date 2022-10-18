package com.cg.fitnesstracker.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.dto.UpdateCustomerHeight;
import com.cg.fitnesstracker.app.dto.UpdateCustomerWeight;
import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value ="/activity/{userName}",produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	public ResponseEntity<List<Activity>> addActivity(@PathVariable String userName, Activity activity){
		return new ResponseEntity<List<Activity>>(customerService.addActivity(userName, activity),HttpStatus.OK);
	}
	
	@PostMapping(value ="/diet/{userName}",produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	public ResponseEntity<List<Diet>> addDiet(@PathVariable String userName, Diet diet){
		return new ResponseEntity<List<Diet>>(customerService.addDiet(userName, diet),HttpStatus.OK);
	}
	
	@PostMapping(produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	public ResponseEntity<Customer> addCustomerDetails(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.addCustomerDetailService(customer),HttpStatus.OK);
	}
	
	@GetMapping("/updateWeight")
	@PutMapping(produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	public ResponseEntity<Customer> updateCustomerWeight(@RequestBody UpdateCustomerWeight ucw){
		Customer c =customerService.updateCustomerWeightService(ucw.getUserName(), ucw.getUpdatedWeight());
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	@GetMapping("/updateHeight")
	@PutMapping(produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	public ResponseEntity<Customer> updateCustomerHeight(@RequestBody UpdateCustomerHeight uch){
		Customer c = customerService.updateCustomerHeightService(uch.getUserName(), uch.getUpdatedHeight());
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
}
