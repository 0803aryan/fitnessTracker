package com.cg.fitnesstracker.app.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;

import com.cg.fitnesstracker.app.model.enums.CardioType;
import com.cg.fitnesstracker.app.model.enums.DayOfWeek;

@Entity
@XmlRootElement
public class Cardio extends Activity{
	
	@Enumerated(EnumType.STRING)
    private CardioType cardioType;
    private int distance;
    private int timeInMinutes;
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
    private boolean succesFlag;
    
    public Cardio() {}

	  public Cardio(CardioType cardioType, int distance, int timeInMinutes, DayOfWeek dayOfWeek, boolean succesFlag) {
		super();
		this.cardioType = cardioType;
		this.distance = distance;
		this.timeInMinutes = timeInMinutes;
		this.dayOfWeek = dayOfWeek;
		this.succesFlag = succesFlag;
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