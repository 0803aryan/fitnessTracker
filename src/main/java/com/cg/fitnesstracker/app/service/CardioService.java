
package com.cg.fitnesstracker.app.service;

import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.enums.CardioType;

public interface CardioService {
	
	public Cardio addCardio(Cardio c,String userName);
	
	public Cardio removeCardio(int cardioId);
	
	public Cardio getCardioByType(CardioType cardioType);
	
	public Cardio updateExistingCardio(int CardioId, Cardio c);
}


