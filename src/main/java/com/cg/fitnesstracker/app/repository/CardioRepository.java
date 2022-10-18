package com.cg.fitnesstracker.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.enums.CardioType;

public interface CardioRepository extends CrudRepository<Cardio, Integer>{
	
	
}
