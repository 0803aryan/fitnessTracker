package com.cg.fitnesstracker.app.model.enums;

public enum DayOfWeek {
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY;
	
	 public static DayOfWeek fromInteger(int x) {
        switch (x) {
            case 0:
                return SUNDAY;
            case 1:
                return MONDAY;
            case 2:
            	return TUESDAY;
            case 3:
            	return WEDNESDAY;
            case 4:
            	return THURSDAY;
            case 5:
            	return FRIDAY;
            case 6:
            	return SATURDAY;
        }
        return null;
    }
}
