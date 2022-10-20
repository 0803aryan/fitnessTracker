package com.cg.fitnesstracker.app.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;

import com.cg.fitnesstracker.app.model.enums.DayOfWeek;
import com.cg.fitnesstracker.app.model.enums.WorkoutType;

@Entity
@XmlRootElement
public class Workout extends Activity {
	
	@Enumerated(EnumType.STRING)
    private WorkoutType workoutType;
    private int noOfReps;
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
    private boolean successFlag;
    
 
    public Workout() {}
    
	public Workout(WorkoutType workoutType, int noOfReps,  DayOfWeek dayOfWeek, boolean successFlag) {
		super();
		this.workoutType = workoutType;
		this.noOfReps = noOfReps;
		this.dayOfWeek = dayOfWeek;
		this.successFlag = successFlag;
	}

   public boolean getSuccessFlag() {
		return successFlag;
	}

	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}

public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}


   public WorkoutType getWorkoutType() {
        return workoutType;
    }

   public void setWorkoutType(WorkoutType workoutType) {
        this.workoutType = workoutType;
    }

   public int getNoOfReps() {
        return noOfReps;
    }

   public void setNoOfReps(int noOfReps) {
        this.noOfReps = noOfReps;
    }
    
}