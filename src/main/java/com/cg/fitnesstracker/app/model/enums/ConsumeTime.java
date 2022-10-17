package com.cg.fitnesstracker.app.model.enums;

public enum ConsumeTime {
	BREAKFAST,
	BRUNCH,
	LUNCH,
	SNACKS,
	DINNER,
	FASTING;
	
	 public static ConsumeTime fromInteger(int x) {
	        switch (x) {
	            case 0:
	                return BREAKFAST;
	            case 1:
	                return BRUNCH;
	            case 2:
	            	return LUNCH;
	            case 3:
	            	return SNACKS;
	            case 4:
	            	return DINNER;
	            case 5:
	            	return FASTING;
	        }
	        return null;
	    }
}
