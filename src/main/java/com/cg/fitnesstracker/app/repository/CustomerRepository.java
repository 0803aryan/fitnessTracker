package com.cg.fitnesstracker.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fitnesstracker.app.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	Customer findByUserName(String userName);
}
