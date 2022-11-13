package com.cg.fitnesstracker.app.controller;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.dto.ReportDto;
import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.service.CustomerService;
import com.cg.fitnesstracker.app.service.DietService;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/fitness/report")
public class ReportController {

	@Autowired
	private DietService dietService;
		
	@Autowired
	private CustomerService customerService;
	
	//To get a report
	@GetMapping
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<ReportDto> getReport(Principal p){
			ReportDto report = new ReportDto();
//			LocalDate date = report.getDate();
			LocalDate date=LocalDate.now();
			Customer cust = customerService.getCustomerService(p.getName());
		
			int height = cust.getHeight();
			float weight = cust.getWeight();
			float BMI = weight*10000/(height*height);
			
			List<Diet> consumedDiets = cust.getDiet().stream().filter(d->d.getDate().equals(date)).toList();
			List<Activity> activities = cust.getActivities().stream().filter(a->a.getDate().equals(date)).toList();
			
			int caloriesConsumed = 0;
			for (Diet diet : consumedDiets) {
				caloriesConsumed += dietService.getTotalCaloriesService(p.getName(), diet.getDietId());
			}
			int caloriesBurned = 0;
			for (Activity activity : activities) {
				caloriesBurned += activity.getCaloriesBurned();
			}
			
			report = new ReportDto(p.getName(),consumedDiets,activities,caloriesConsumed,caloriesBurned,BMI);
			
			return new ResponseEntity<>(report, HttpStatus.OK);
			
	}
}
