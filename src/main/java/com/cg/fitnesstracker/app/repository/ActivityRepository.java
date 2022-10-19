package com.cg.fitnesstracker.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.Activity;
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

	@Query("delete from Activity w where w.activityId=:activityId")
	@Modifying//insert,update,delete
	int deleteByActivityId( @Param("activityId") int activityId);
	
//	@Query("select * from Activity a, Cardio c where a.activityId=c.activityId and c.cardioType=:cardioType")
//	@Query("select * from Activity")
//	@Modifying
//	List<Cardio> getCardioActivity(@Param("cardioType") CardioType cardioType);
	
}
