package com.cg.fitnesstracker.app.service;

import java.util.List;

import com.cg.fitnesstracker.app.model.Workout;
import com.cg.fitnesstracker.app.model.enums.WorkoutType;

public interface WorkoutService {
    public Workout addUserWorkout(Workout w);
    
    public Workout removeUserWorkout(int workoutId);
    
    public List<Workout> getWorkoutByType(WorkoutType workoutType);
    
    public Workout updateExistingWorkout(int workoutId, Workout w);
}