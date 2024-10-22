package com.cg.fitnesstracker.app.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.model.Meal;
@Repository
public interface DietRepository extends CrudRepository<Diet, Integer>{
	@Query("delete from Diet d where d.dietId = :dietId")
	@Modifying
	int deleteDietById(@Param("dietId") int dietId);
	
	@Query("delete from Meal m where m.diet.dietId = :dietId and m.foodId = :foodId")
	@Modifying
	int deleteFoodFromDiet(@Param("dietId") int dietId, @Param("foodId") int foodId);
}
