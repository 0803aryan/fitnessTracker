package com.cg.fitnesstracker.app.model.enums;

public enum CardioType {
	RUNNING,
	JOGGING,
	SWIMING,
	WALKING,
	CYCLING;
	
	 public static CardioType fromInteger(int x) {
	        switch (x) {
	            case 0:
	                return RUNNING;
	            case 1:
	                return JOGGING;
	            case 2:
	            	return SWIMING;
	            case 3:
	            	return WALKING;
	            case 4:
	            	return CYCLING;
	        }
	        return null;
	    }
}
