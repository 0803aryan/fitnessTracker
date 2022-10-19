package com.cg.fitnesstracker.app.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.fitnesstracker.app.response.ResponseMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({Exception.class})
	public ResponseEntity<ResponseMessage> handler(Exception e) {
		ResponseMessage message=new ResponseMessage(e.getMessage());
		return (ResponseEntity<ResponseMessage>) new ResponseEntity((Object) message, HttpStatus.NOT_FOUND);
	}
}
