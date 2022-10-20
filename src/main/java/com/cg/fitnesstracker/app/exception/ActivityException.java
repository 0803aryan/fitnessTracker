package com.cg.fitnesstracker.app.exception;

public class ActivityException extends RuntimeException{
	public String message;
	public int status;
	
	public ActivityException() {}

	public ActivityException(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
}
