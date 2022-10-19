package com.cg.fitnesstracker.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.Meal;



@Repository
public interface MealRepository extends CrudRepository<Meal, Integer>{
	
	
}
