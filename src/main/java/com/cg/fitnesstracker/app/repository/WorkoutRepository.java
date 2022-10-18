package com.cg.fitnesstracker.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.Workout;
import com.cg.fitnesstracker.app.model.enums.WorkoutType;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Integer>{

	List<Workout> findByWorkoutType(WorkoutType workoutType);
	
	
}
