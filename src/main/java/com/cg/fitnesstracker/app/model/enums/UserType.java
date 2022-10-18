package com.cg.fitnesstracker.app.model.enums;

public enum UserType {
	ADMIN,
	CUSTOMER;
	
	 public static UserType fromInteger(int x) {
	        switch (x) {
	            case 0:
	                return ADMIN;
	            case 1:
	            	return CUSTOMER;
	        }
	        return null;
	    }
}
