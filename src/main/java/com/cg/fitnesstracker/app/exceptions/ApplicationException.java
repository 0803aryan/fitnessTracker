package com.cg.fitnesstracker.app.exceptions;

public class ApplicationException extends RuntimeException{
	public String message;
	public int status;
	
	public ApplicationException() {}

	public ApplicationException(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
}
