package com.cg.fitnesstracker.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	Customer findByUserName(String userName);
	
	@Query("update Customer c set c.weight = :weight where c.userName = :name")
	@Modifying
	int updateWeight(@Param("name") String userName, @Param("weight") float weight);
	
	@Query("update Customer c set c.height = :height where c.userName = :name")
	@Modifying
	int updateHeight(@Param("name") String userName, @Param("height") float height);
	
	@Query("update Customer c set c.active = :activityStatus where c.userName = :userName")
	@Modifying
	int updateActivityStatus(@Param("name") String userName, @Param("activityStatus") boolean active);
}
