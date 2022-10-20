package com.cg.fitnesstracker.app.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.fitnesstracker.app.exceptions.ActivityException;
import com.cg.fitnesstracker.app.response.ResponseMessage;

@RestControllerAdvice
public class ActivityExceptionHandler {

	@ExceptionHandler(ActivityException.class)
	public ResponseEntity<ResponseMessage> activityNotFoundHandler(ActivityException e) {

		if(e.status==404) {
			ResponseMessage message=new ResponseMessage(e.message, 404);

			return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		}
		if(e.status==204) {
			ResponseMessage message=new ResponseMessage(e.message, 204);

			return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
		}

		if(e.status==400) {
			ResponseMessage message=new ResponseMessage(e.message, 400);

			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
