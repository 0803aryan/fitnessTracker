package com.cg.fitnesstracker.app.service;

import java.util.List;

import com.cg.fitnesstracker.app.model.Activity;

public interface ActivityService {

	public Activity addCardioActivityService(String username, Activity cardioActivity);

	public Activity addWorkoutActivityService(String username, Activity workoutActivity);

	public Activity deleteActivity(String userName, int activityId);

	public List<Activity> getActivity(String userName);

	public int getCaloriesBurned(String userName, int activityId);

	public Activity getActivityById(int activityId);

	//	public List<Cardio> getCardioActivity(CardioType cardioType);

	//	public List<Activity> getWorkoutActivity(String userName);
	//	public Workout deleteActivity(String userName, WorkoutType workoutType);

	//	public Cardio updateCardioActivityService(int userId, Cardio cardioActivity);
	//	
	//	public Workout updateWorkoutActivityService(int userId, Workout workoutActivity);
}
