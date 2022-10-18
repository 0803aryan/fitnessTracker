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

	@Override
	public Workout addUserWorkout(Workout w) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Workout removeUserWorkout(int workoutId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Workout> getWorkoutByType(WorkoutType workoutType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Workout updateExistingWorkout(int workoutId, Workout w) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
