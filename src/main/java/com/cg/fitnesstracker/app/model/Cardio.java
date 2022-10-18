package com.cg.fitnesstracker.app.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.cg.fitnesstracker.app.model.enums.CardioType;
import com.cg.fitnesstracker.app.model.enums.DayOfWeek;

@Entity
public class Cardio extends Activity{

	@Column(unique=true)
	private int cardioId;
    private CardioType cardioType;
    private int distance;
    private int timeInMinutes;
    private DayOfWeek dayOfWeek;
    private boolean succesFlag;
    private LocalDate date;
    
    public Cardio() {}

	public Cardio(int cardioId, CardioType cardioType, int distance, int timeInMinutes, DayOfWeek dayOfWeek, boolean succesFlag,
			LocalDate date) {
		super();
		this.cardioId=cardioId;
		this.cardioType = cardioType;
		this.distance = distance;
		this.timeInMinutes = timeInMinutes;
		this.dayOfWeek = dayOfWeek;
		this.succesFlag = succesFlag;
		this.date = date;
	}
	
	

	public int getCardioId() {
		return cardioId;
	}

	public void setCardioId(int cardioId) {
		this.cardioId = cardioId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate() {
		this.date = LocalDate.now();
	}
    
    public boolean isSuccesFlag() {
		return succesFlag;
	}

	public void setSuccesFlag(boolean succesFlag) {
		this.succesFlag = succesFlag;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

    public CardioType getCardioType() {
        return cardioType;
    }
    public void setCardioType(CardioType cardioType) {
        this.cardioType = cardioType;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public int getTimeInMinutes() {
        return timeInMinutes;
    }
    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }
    
    
    
}