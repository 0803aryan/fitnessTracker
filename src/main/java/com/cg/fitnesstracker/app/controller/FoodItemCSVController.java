package com.cg.fitnesstracker.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cg.fitnesstracker.app.exceptions.ApplicationException;
import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.response.ResponseMessage;
import com.cg.fitnesstracker.app.service.implementation.CSVServiceImpl;
import com.cg.fitnesstracker.app.utils.csv.CSVHelper;


@CrossOrigin
@Controller
@RequestMapping("/fitness/file")
public class FoodItemCSVController {
    @Autowired
    CSVServiceImpl fileService;
    
    public void setCSVService(final CSVServiceImpl fileService) {
        this.fileService=fileService;
    }
    
    //To upload a food items csv file
    @PostMapping(value="/food_items")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file)
    {
        String message = "";

       if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();


               return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,200));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,417));
            }
        }
        throw new ApplicationException("File is not of CSV format", 406);            
    }
    
    //TO get all the food items uploaded
    @GetMapping("/food_items")
    @PreAuthorize("hasAnyRole('Customer','Admin')")
    public ResponseEntity<List<FoodItem>> getAllInfo() {
        
            List<FoodItem> foodItems = fileService.getAllFoodItems();


           if (foodItems.isEmpty()) {
                throw new ApplicationException("No content", 400);
            }
            
            return new ResponseEntity<>(foodItems, HttpStatus.OK);
        
    }
}