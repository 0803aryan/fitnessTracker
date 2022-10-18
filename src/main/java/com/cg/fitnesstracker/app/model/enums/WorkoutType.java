package com.cg.fitnesstracker.app.model.enums;

public enum WorkoutType {
	CHESTWORKOUT,
	BACKWORKOUT,
	LEGSWORKOUT,
	SHOULDERWORKOUT,
	BICEPSWORKOUT,
	TRICEPSWORKOUT,
	ABSWORKOUT;
	
	public static WorkoutType fromInteger(int x) {
        switch (x) {
            case 0:
                return CHESTWORKOUT;
            case 1:
                return BACKWORKOUT;
            case 2:
                return LEGSWORKOUT;
            case 3:
                return SHOULDERWORKOUT;
            case 4:
                return BICEPSWORKOUT;
            case 5:
                return TRICEPSWORKOUT;
            case 6:
                return ABSWORKOUT;

        }
        return null;
    }
}
