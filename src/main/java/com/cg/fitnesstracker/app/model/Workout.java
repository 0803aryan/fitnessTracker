package com.cg.fitnesstracker.app.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.cg.fitnesstracker.app.model.enums.DayOfWeek;
import com.cg.fitnesstracker.app.model.enums.WorkoutType;

@Entity
public class Workout extends Activity {
//    @Id
//    private int workoutId;
    private WorkoutType workoutType;
    private int noOfReps;
    private DayOfWeek dayOfWeek;
    private LocalDate date;
    private boolean successFlag;

    public Workout() {}
    
	public Workout(WorkoutType workoutType, int noOfReps, DayOfWeek dayOfWeek, LocalDate date, boolean successFlag) {
		super();
		this.workoutType = workoutType;
		this.noOfReps = noOfReps;
		this.dayOfWeek = dayOfWeek;
		this.date = date;
		this.successFlag = successFlag;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate() {
		this.date = LocalDate.now();
	}

   public boolean isSuccessFlag() {
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