package com.cg.fitnesstracker.app.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.fitnesstracker.app.exceptions.DietException;
import com.cg.fitnesstracker.app.response.ResponseMessage;

@RestControllerAdvice
public class DietExceptionHandler {
   @ExceptionHandler(value = DietException.class)
   public ResponseEntity<Object> handleException(DietException exception) {
	   if (exception.status==404) {
		   return new ResponseEntity<>(new ResponseMessage(exception.message,404), HttpStatus.NOT_FOUND);
	   }
	   else {
		  
		   return new ResponseEntity<>(new ResponseMessage(exception.message,400), HttpStatus.BAD_REQUEST);
	   }
   }  
}