package com.cg.fitnesstracker.app.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer>{
	
	@Query("update Admin a set a.userEmail = :userEmail where a.userId = :userId")
	@Modifying
	int updateAdminEmail(@Param("userEmail") String userEmail,@Param("userId") int userId);
}
