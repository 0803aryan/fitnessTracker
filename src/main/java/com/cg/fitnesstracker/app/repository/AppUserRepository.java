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
	
	AppUser findByUserName(String userName);

	@Query("update AppUser c set c.password = :password where c.userId = :userId")
	@Modifying
	int updatePassword(@Param("password") String password,@Param("userId") int userId);

}
