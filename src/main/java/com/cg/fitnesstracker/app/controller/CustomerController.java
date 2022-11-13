package com.cg.fitnesstracker.app.controller;

import java.security.Principal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.dto.UpdateCustomerHeight;
import com.cg.fitnesstracker.app.dto.UpdateCustomerWeight;
import com.cg.fitnesstracker.app.dto.UpdateEmailDto;
import com.cg.fitnesstracker.app.exceptions.ApplicationException;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.service.CustomerService;


@CrossOrigin(origins = "http://localhost:3000/")

@RestController
@RequestMapping("/fitness/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//To add customer details
	@PostMapping(produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<AppUser> addCustomerDetails(Principal p,@RequestBody Customer customer){
		System.out.println("Hi");
		Pattern pattern =Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
		Matcher m=pattern.matcher(customer.getUserEmail());
		if(!m.find()) {
			throw new ApplicationException("Please enter a valid email",400);
		}
		if(customer.getFirstName().length()<1) {
			throw new ApplicationException("Please enter valid first Name",400);
		}
		if(customer.getLastName().length()<1) {
			throw new ApplicationException("Please enter valid last Name",400);
		}
		if(customer.getWeight()>200 || customer.getWeight()<0) {
			throw new ApplicationException("Enter a valid weight",400);
		}
		if((float)customer.getWeight()!=customer.getWeight()) {
			throw new ApplicationException("Please enter a float value",400);
		}
		if(customer.getHeight()>250 || customer.getHeight()<0) {
			throw new ApplicationException("Enter a valid height",400);
		}
		if((int)customer.getHeight()!=customer.getHeight()) {
			throw new ApplicationException("Please enter a int value",400);
		}
		return new ResponseEntity<AppUser>(customerService.addCustomerDetailService(p.getName(),customer),HttpStatus.OK);
	}
	
	//To update customer weight
	@PutMapping(value="/weight",produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<Customer> updateCustomerWeight(Principal p,@RequestBody UpdateCustomerWeight ucw){
		if(ucw.getUpdatedWeight()>200 || ucw.getUpdatedWeight()<0) {
			throw new ApplicationException("Enter a valid weight",400);
		}
		if((float)ucw.getUpdatedWeight()!=ucw.getUpdatedWeight()) {
			throw new ApplicationException("Please enter a float value",400);
		}
		Customer c =customerService.updateCustomerWeightService(p.getName(), ucw.getUpdatedWeight());
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	//To update customer height
	@PutMapping(value="/height",produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<Customer> updateCustomerHeight(Principal p,@RequestBody UpdateCustomerHeight uch){
		if(uch.getUpdatedHeight()>250 || uch.getUpdatedHeight()<0) {
			throw new ApplicationException("Enter a valid height",400);
		}
		if((int)uch.getUpdatedHeight()!=uch.getUpdatedHeight()) {
			throw new ApplicationException("Please enter a int value",400);
		}
		Customer c = customerService.updateCustomerHeightService(p.getName(), uch.getUpdatedHeight());
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	//To update customer email
	@PutMapping(value = "/email",produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<AppUser> updateEmail(Principal p,@RequestBody UpdateEmailDto updateEmailDto){
		Pattern pattern =Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
		Matcher m=pattern.matcher(updateEmailDto.getNewEmail());
		if(!m.find()) {
			throw new ApplicationException("Please enter a valid email",400);
		}
		AppUser appUser = customerService.updateCustomerEmailService(p.getName(),updateEmailDto.getNewEmail());
		return new ResponseEntity<AppUser>(appUser,HttpStatus.OK);
	}
	
	@GetMapping()
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<Customer> readCustomerDetailById(Principal p){
		Customer cust = customerService.getCustomerService(p.getName());
		if(cust.getFirstName().equals(null)) {
			throw new ApplicationException("No customer Found",404);
		}
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}

}
