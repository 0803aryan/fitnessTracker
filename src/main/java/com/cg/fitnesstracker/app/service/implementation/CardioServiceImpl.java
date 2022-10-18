package com.cg.fitnesstracker.app.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.enums.CardioType;
import com.cg.fitnesstracker.app.repository.CardioRepository;
import com.cg.fitnesstracker.app.service.CardioService;

@Component
public class CardioServiceImpl implements CardioService{

	@Override
	public Cardio addCardio(Cardio c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cardio removeCardio(int cardioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cardio getCardioByType(CardioType cardioType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cardio updateExistingCardio(int CardioId, Cardio c) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
