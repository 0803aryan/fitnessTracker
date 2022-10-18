package com.cg.fitnesstracker.app.service;

import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.Workout;

public interface ActivityService {
	
	public Cardio addCardioActivityService(String userName, Cardio cardioActivity);
	
	public Workout addWorkoutActivityService(String userName, Workout workoutActivity);

	public Cardio deleteCardioActivityService(String userName, int cardioId);
	
	public Workout deleteWorkoutActivityService(String userName, int workoutId);
	
	public Cardio updateCardioActivityService(int userId, Cardio cardioActivity);
	
	public Workout updateWorkoutActivityService(int userId, Workout workoutActivity);
}
