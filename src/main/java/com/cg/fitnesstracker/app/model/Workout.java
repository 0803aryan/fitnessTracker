package com.cg.fitnesstracker.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.cg.fitnesstracker.app.model.enums.WorkoutType;

@Entity
public class Workout extends Activity {
//    @Id
//    private int workoutId;
    private WorkoutType workoutType;
    private int noOfReps;
    
    /*public Workout(int workoutId, WorkoutType workoutType, int noOfReps) {
        super();
        this.workoutId = workoutId;
        this.workoutType = workoutType;
        this.noOfReps = noOfReps;
    }*/
    
   public Workout() {}

//   public int getWorkoutId() {
//        return workoutId;
//    }

//   public void setWorkoutId(int workoutId) {
//        this.workoutId = workoutId;
//    }

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