package com.cg.fitnesstracker.app.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.cg.fitnesstracker.app.model.enums.DayOfWeek;
import com.cg.fitnesstracker.app.model.enums.WorkoutType;

@Entity
public class Workout extends Activity {
	
	@Column(unique=true)
	private int workoutId;
    private WorkoutType workoutType;
    private int noOfReps;
    private DayOfWeek dayOfWeek;
    private LocalDate date;
    private boolean successFlag;

    public Workout() {}
    
	public Workout(int workoutId, WorkoutType workoutType, int noOfReps, DayOfWeek dayOfWeek, LocalDate date, boolean successFlag) {
		super();
		this.workoutId=workoutId;
		this.workoutType = workoutType;
		this.noOfReps = noOfReps;
		this.dayOfWeek = dayOfWeek;
		this.date = date;
		this.successFlag = successFlag;
	}

	
	
	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
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