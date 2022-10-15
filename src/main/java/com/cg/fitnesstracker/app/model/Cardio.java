package com.cg.fitnesstracker.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.cg.fitnesstracker.app.model.enums.CardioType;

@Entity
public class Cardio extends Activity{
//    @Id
//    private int cardioId;
    private CardioType cardioType;
    private int frequency;
    private int timeInMinutes;
    
    public Cardio() {}
    
    /*public Cardio(int cardioId, Enum cardioType, int frequency, int timeInMinutes) {
    	super();
    	this.cardioId = cardioId;
    	this.cardioType = cardioType;
    	this.frequency = frequency;
    	this.timeInMinutes = timeInMinutes;
    }*/
    
//    public int getCardioId() {
//        return cardioId;
//    }
//    public void setCardioId(int cardioId) {
//        this.cardioId = cardioId;
//    }
    public CardioType getCardioType() {
        return cardioType;
    }
    public void setCardioType(CardioType cardioType) {
        this.cardioType = cardioType;
    }
    public int getFrequency() {
        return frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    public int getTimeInMinutes() {
        return timeInMinutes;
    }
    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }
    
    
    
}