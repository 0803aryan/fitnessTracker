package com.cg.fitnesstracker.app.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.Activity;
@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {

	@Query("delete from Activity w where w.activityId=:activityId")
	@Modifying//insert,update,delete
	int deleteByActivityId( @Param("activityId") int activityId);
	
}
