package com.cg.fitnesstracker.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.enums.CardioType;

@Repository
public interface WorkoutRepository extends CrudRepository<Cardio, CardioType>{

}
