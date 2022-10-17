package com.cg.fitnesstracker.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

}
