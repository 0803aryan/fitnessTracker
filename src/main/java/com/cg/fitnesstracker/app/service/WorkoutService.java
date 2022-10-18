package com.cg.fitnesstracker.app.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Workout;
import com.cg.fitnesstracker.app.model.enums.WorkoutType;
import com.cg.fitnesstracker.app.repository.WorkoutRepository;
import com.cg.fitnesstracker.app.service.WorkoutService;

@Component
public class WorkoutServiceImpl implements WorkoutService{

	@Autowired
	private WorkoutRepository workoutRepository;
	
	@Override
	public Workout addUserWorkout(Workout c) {
		Workout workout=workoutRepository.save(c);
		return workout;
	}

	@Override
	public Workout removeUserWorkout(int activityId) {
		Optional<Workout> optionalWorkout=workoutRepository.findById(activityId);
		if(optionalWorkout.isPresent())
		{
			Workout workout=optionalWorkout.get();
			workoutRepository.deleteById(activityId);
			return workout;
		}
		return null;
	}

	@Override
	public List<Workout> getWorkoutByType(WorkoutType workoutType) {

		return workoutRepository.findByWorkoutType(workoutType);
	}

	@Override
	public Workout updateExistingWorkout(int workoutId, Workout w) {

		Optional<Workout> optionalWorkout =workoutRepository.findById(workoutId);
		if(optionalWorkout.isPresent())
		{
			Workout workout=optionalWorkout.get();
			
			workout.setActivityName(w.getActivityName());
			workout.setNoOfReps(w.getNoOfReps());
			workout.setDayOfWeek(w.getDayOfWeek());
			workout.setCaloriesBurned(w.getCaloriesBurned());
			workout.setWorkoutType(w.getWorkoutType());
			workout.setSuccessFlag(w.isSuccessFlag());
			
			
			return workout;
		}
		return null;
	}

}
