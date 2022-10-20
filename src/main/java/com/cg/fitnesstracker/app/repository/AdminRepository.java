package com.cg.fitnesstracker.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.model.AppUser;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer>{
	
	@Query("update Admin a set a.userEmail = :newEmail where a.userId = :userId")
	@Modifying
	@Transactional
	int updateAdminEmail(@Param("newEmail") String newEmail,@Param("userId") int userId);
	
	
	
	@Query("update Admin a set a.username = :username where a.userId = :userId")
	@Modifying
	int updateAdminName(@Param("username") String username, @Param("userId") int userId);
	
	
	@Query(value= "insert into Admin (admin_name, user_email,user_id) values(:adminName,:userEmail,:userId)",nativeQuery=true)
	@Modifying
	@Transactional
	int addAdminDetails(@Param("adminName") String adminName,@Param("userEmail") String userEmail,@Param("userId") int userId);
	
//	@Query("insert into Admin a(a.admin) VALUES (:insertLink,?#{principal.id})")
//	Admin addAdminDetails(@Param("username") String username, Admin admin);
	
}
