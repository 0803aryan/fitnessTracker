package com.cg.fitnesstracker.app.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cg.fitnesstracker.app.model.enums.DayOfWeek;
import com.cg.fitnesstracker.app.model.enums.WorkoutType;

@Entity
public class Workout extends Activity {
	
	@Enumerated(EnumType.STRING)
    private WorkoutType workoutType;
    private int noOfReps;
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
    private boolean successFlag;
    
//    @NotNull
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(style = "dd-MM-yyyy")
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
//    private LocalDate date;
    
//    {
//		this.date = LocalDate.now();
//    }
    
    public Workout() {}
    
	public Workout(WorkoutType workoutType, int noOfReps,  DayOfWeek dayOfWeek, boolean successFlag) {
		super();
		this.workoutType = workoutType;
		this.noOfReps = noOfReps;
		this.dayOfWeek = dayOfWeek;
		this.successFlag = successFlag;
	}

//	public LocalDate getDate() {
//		return date;
//	}
//
//	public void setDate() {
//		this.date = LocalDate.now();
//	}

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