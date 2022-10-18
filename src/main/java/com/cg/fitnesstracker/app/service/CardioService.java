package com.cg.fitnesstracker.app.service;

import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.enums.CardioType;

public interface CardioService {
	
	public Cardio addCardio(Cardio c);
	
	public Cardio removeCardio(int activityId);
	
	public Cardio getCardioByType(CardioType cardioType);

	public Cardio updateExistingCardio(int catdioId, Cardio c);
}
