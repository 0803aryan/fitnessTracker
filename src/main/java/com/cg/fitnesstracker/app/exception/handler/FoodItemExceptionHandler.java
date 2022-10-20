package com.cg.fitnesstracker.app.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.fitnesstracker.app.exceptions.FoodItemException;
import com.cg.fitnesstracker.app.response.ResponseMessage;

@ControllerAdvice
public class FoodItemExceptionHandler {
   @ExceptionHandler(value = FoodItemException.class)
   public ResponseEntity<Object> handleException(FoodItemException exception) {
	   if (exception.status==404) {
		   return new ResponseEntity<>(new ResponseMessage(exception.message,404), HttpStatus.NOT_FOUND);
	   }
	   else {
		    return new ResponseEntity<>(new ResponseMessage(exception.message,400), HttpStatus.BAD_REQUEST);
	   }
	  
   }
}