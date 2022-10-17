package com.cg.fitnesstracker.app.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.model.enums.CardioType;
import com.cg.fitnesstracker.app.repository.CardioRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.service.CardioService;

@Component
public class CardioServiceImpl implements CardioService{
	@Autowired
	CardioRepository cardioRepository;
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Cardio addCardio(Cardio c, String userName) {
		Customer cust =customerRepository.findByUserName(userName);
		if(cust!=null) {
			List<Activity> activities = cust.getActivities();
			
		}
		throw new RuntimeException("Can't update");
	}

	@Override
	public Cardio removeCardio(int activityId) {
	return null;
	}
		

	@Override
	public Cardio getCardioByType(CardioType cardioType) {
		// TODO Auto-generated method stub
		return null;
	}

}
