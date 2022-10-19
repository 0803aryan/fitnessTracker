package com.cg.fitnesstracker.app.service;

import java.util.List;

import com.cg.fitnesstracker.app.model.Activity;

public interface ActivityService {
	
	public Activity addCardioActivityService(String userName, Activity cardioActivity);
	
	public Activity addWorkoutActivityService(String userName, Activity workoutActivity);

	public Activity deleteActivity(String userName, int activityId);
	
	public List<Activity> getActivity(String userName);
	
//	public List<Cardio> getCardioActivity(CardioType cardioType);
	
//	public List<Activity> getWorkoutActivity(String userName);
//	public Workout deleteActivity(String userName, WorkoutType workoutType);
	
//	public Cardio updateCardioActivityService(int userId, Cardio cardioActivity);
//	
//	public Workout updateWorkoutActivityService(int userId, Workout workoutActivity);
}
