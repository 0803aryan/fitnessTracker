package com.cg.fitnesstracker.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.Diet;
@Repository
public interface DietRepository extends CrudRepository<Diet, Integer>{

}
