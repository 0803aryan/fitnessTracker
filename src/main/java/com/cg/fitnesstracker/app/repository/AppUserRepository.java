package com.cg.fitnesstracker.app.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
	Customer findByUserName(String userName);
/*
	@Modifying
	@Query("update login c set c.user_email = :user_email where c.userName = :name")
	
	int updateEmail(@Param("name") String userName, @Param("user_email") String user_email);

	@Modifying
	@Query("update login c set c.password = :password where c.userName = :name")
	
	int updatePassword(@Param("name") String userName, @Param("password") String password);
*/	
}
