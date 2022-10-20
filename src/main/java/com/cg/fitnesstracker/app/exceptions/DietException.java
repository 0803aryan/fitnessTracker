package com.cg.fitnesstracker.app.exceptions;

public class DietException extends RuntimeException {
	public String message;
	public int status;
	
	public DietException() {}

	public DietException(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
	
}
