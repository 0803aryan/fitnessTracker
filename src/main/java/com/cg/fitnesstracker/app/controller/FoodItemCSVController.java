package com.cg.fitnesstracker.app.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cg.fitnesstracker.app.csvoperations.CSVHelper;
import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.response.ResponseMessage;
import com.cg.fitnesstracker.app.service.implementation.CSVServiceImpl;



@Controller
@RequestMapping("/fitness")
public class FoodItemCSVController {
    @Autowired
    CSVServiceImpl fileService;
    
    public void setCSVService(final CSVServiceImpl fileService) {
        this.fileService=fileService;
    }
    
    @PostMapping(value="/food_items/upload")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file)
    {
        String message = "";

       if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();

               return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,""));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,""));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message,""));
    }

    @GetMapping("/food_items")
    @PreAuthorize("hasAnyRole('Customer','Admin')")
    public ResponseEntity<List<FoodItem>> getAllInfo() {
        try {
            List<FoodItem> foodItems = fileService.getAllFoodItems();



           if (foodItems.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            
            return new ResponseEntity<>(foodItems, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}