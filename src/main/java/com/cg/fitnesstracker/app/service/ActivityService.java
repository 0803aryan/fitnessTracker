package com.cg.fitnesstracker.app.service;

import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.Workout;

public interface ActivityService {
	
	public Cardio addCardioActivityService(String userName, Cardio cardioActivity);
	
	public Workout addWorkoutActivityService(String userName, Workout workoutActivity);

	public Cardio deleteCardioActivityService(String userName, Cardio cardioActivity);
	
	public Workout deleteWorkoutActivityService(String userName, Workout workoutActivity);
	
	public Cardio updateCardioActivityService(String userName, Cardio cardioActivity);
	
	public Workout updateWorkoutActivityService(String userName, Workout workoutActivity);
}