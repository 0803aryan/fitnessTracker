package com.cg.fitnesstracker.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.service.DietService;

@RestController
@RequestMapping("/Diet")
public class DietController {

		@Autowired
		DietService dietService;
		
		@GetMapping("{userName}/get-all-diets/")
	    public ResponseEntity<List<Diet>> getAllDietByUserName(@PathVariable String userName){
			
			return null;
		}
}
