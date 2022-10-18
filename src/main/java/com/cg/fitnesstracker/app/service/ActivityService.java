package com.cg.fitnesstracker.app.service;

import com.cg.fitnesstracker.app.model.Activity;

public interface ActivityService {
	
	public Activity addCardioActivityService(String userName, Activity cardioActivity);
	
	public Activity addWorkoutActivityService(String userName, Activity workoutActivity);

	public Activity deleteActivity(String userName, int activityId);
	
//	public Workout deleteActivity(String userName, WorkoutType workoutType);
	
//	public Cardio updateCardioActivityService(int userId, Cardio cardioActivity);
//	
//	public Workout updateWorkoutActivityService(int userId, Workout workoutActivity);
}
