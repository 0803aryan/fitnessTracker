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

	@Autowired
	private CardioRepository cardioRepository;
	
	@Override
	public Cardio addCardio(Cardio c) {
		Cardio cardio=cardioRepository.save(c);
		return cardio;
	}

	@Override
	public Cardio removeCardio(int activityId) {
		Optional<Cardio> optionalCardio=cardioRepository.findById(activityId);
		if(optionalCardio.isPresent())
		{
			Cardio cardio=optionalCardio.get();
			cardioRepository.deleteById(activityId);
			return cardio;
		}
		return null;
	}

	@Override
	public Cardio getCardioByType(CardioType cardioType) {
		return (Cardio) cardioRepository.findByCardioType(cardioType);
	}

	@Override
	public Cardio updateExistingCardio(int cardioId, Cardio c) {

		Optional<Cardio> optionalCardio =cardioRepository.findById(cardioId);
		if(optionalCardio.isPresent())
		{
			Cardio cardio=optionalCardio.get();
			
			cardio.setActivityName(c.getActivityName());
			cardio.setCaloriesBurned(c.getCaloriesBurned());
			cardio.setDayOfWeek(c.getDayOfWeek());
			cardio.setCardioType(c.getCardioType());
			cardio.setDistance(c.getDistance());
			cardio.setSuccesFlag(c.isSuccesFlag());
			cardio.setTimeInMinutes(c.getTimeInMinutes());
			
			
			return cardio;
		}
		return null;
	}

}
