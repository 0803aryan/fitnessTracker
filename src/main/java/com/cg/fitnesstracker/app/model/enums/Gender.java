package com.cg.fitnesstracker.app.model.enums;

public enum Gender {
	MALE,
	FEMALE;
	
	 public static Gender fromInteger(int x) {
	        switch (x) {
	            case 0:
	                return MALE;
	            case 1:
	                return FEMALE;
	        }
	        return null;
	    }
}
