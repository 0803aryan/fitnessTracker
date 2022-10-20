package com.cg.fitnesstracker.app.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.fitnesstracker.app.exceptions.ApplicationException;
import com.cg.fitnesstracker.app.response.ResponseMessage;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ResponseMessage> applicationExceptionHandler(ApplicationException e) {
		if(e.status==404) {
			ResponseMessage message=new ResponseMessage(e.message, 404);

			return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		}
		else if(e.status==204) {
			ResponseMessage message=new ResponseMessage(e.message, 204);

			return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
		}
		else if(e.status==406) {
			ResponseMessage message=new ResponseMessage(e.message, 406);

			return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
		}
		else 
		{
			ResponseMessage message=new ResponseMessage(e.message, 400);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

	}
}
