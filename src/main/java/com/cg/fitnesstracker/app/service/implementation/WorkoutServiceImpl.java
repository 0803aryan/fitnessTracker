package com.cg.fitnesstracker.app.service.implementation;

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
	public Workout getWorkoutByType(WorkoutType workoutType) {

		return workoutRepository.findByWorkoutType(workoutType);
	}
	

//	@Override
//	public Workout updateExistingWorkout(WorkoutType workoutType, Workout w) {
//
//		Workout workout =workoutRepository.findByWorkoutType(workoutType);
//		if(workout!=null)
//		{
//			
//			workout.setNoOfReps(w.getNoOfReps());
//			workout.setDayOfWeek(w.getDayOfWeek());
//			workout.setWorkoutType(w.getWorkoutType());
//			workout.setSuccessFlag(w.isSuccessFlag());
//			
//			
//			return workout;
//		}
//		return null;
//	}

}
