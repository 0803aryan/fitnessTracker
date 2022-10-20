package com.cg.fitnesstracker.app.exceptions;

public class FoodItemException extends RuntimeException{
	public String message;
	public int status;
	
	public FoodItemException() {}

	public FoodItemException(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
	
}
