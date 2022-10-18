package com.cg.fitnesstracker.app.model.enums;

public enum BodyType {
	ENDOMORPH,
	MESOMORPH,
	ECTOMORPH;
	
	 public static BodyType fromInteger(int x) {
        switch (x) {
            case 0:
                return ENDOMORPH;
            case 1:
                return MESOMORPH;
            case 2:
            	return ECTOMORPH;
        }
        return null;
    }
}
