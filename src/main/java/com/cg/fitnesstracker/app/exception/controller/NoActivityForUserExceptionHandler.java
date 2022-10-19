package com.cg.fitnesstracker.app.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.fitnesstracker.app.exception.ActivityException;
import com.cg.fitnesstracker.app.response.ResponseMessage;

@RestControllerAdvice
public class NoActivityForUserExceptionHandler {
	@ExceptionHandler(ActivityException.class)
	public ResponseEntity<ResponseMessage> activityNotFoundHandler(Exception e) {
		ResponseMessage message=new ResponseMessage("User Does Not have this Activity");
		
		return (ResponseEntity<ResponseMessage>) new ResponseEntity((Object) message, HttpStatus.NOT_FOUND);
	}
}
