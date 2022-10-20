package com.cg.fitnesstracker.app.repository;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.enums.BodyType;
import com.cg.fitnesstracker.app.model.enums.Gender;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	Customer findByUsername(String username);
	
	@Query("update Customer c set c.weight = :weight where c.userId = :userId")
	@Modifying
	@Transactional
	int updateWeight(@Param("userId") int userId, @Param("weight") float weight);
	
	@Query("update Customer c set c.height = :height where c.userId = :userId")
	@Modifying
	int updateHeight(@Param("userId") int userId, @Param("height") int height);
	
	@Query("update Customer c set c.userEmail = :userEmail where c.userId = :userId")
	@Modifying
	int updateCustomerEmail(@Param("userEmail") String userEmail,@Param("userId") int userId);

	@Query(value= "insert into Customer (active,age,body_type,gender,height,user_email,weight,user_id) values(:active,:age,:bodyType,:gender,:height,:userEmail,:weight,:userId)",nativeQuery=true)
	@Modifying
	@Transactional
	int addCustomerDetails(@Param("active") boolean active,@Param("age") int age,@Param("bodyType") String bodyType,@Param("gender") String gender,@Param("height") int height,@Param("userEmail") String userEmail,@Param("weight") float weight,@Param("userId") int userId);
}
