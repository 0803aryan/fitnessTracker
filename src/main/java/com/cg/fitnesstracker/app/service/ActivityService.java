package com.cg.fitnesstracker.app.service;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Workout;
import com.cg.fitnesstracker.app.model.enums.WorkoutType;

public interface ActivityService {
	
	public Activity addCardioActivityService(String userName, Activity cardioActivity);
	
	public Activity addWorkoutActivityService(String userName, Activity workoutActivity);

	public Activity deleteCardioActivityService(String userName, int activityId);
	
	public Workout deleteWorkoutActivityService(String userName, WorkoutType workoutType);
	
//	public Cardio updateCardioActivityService(int userId, Cardio cardioActivity);
//	
//	public Workout updateWorkoutActivityService(int userId, Workout workoutActivity);
}
