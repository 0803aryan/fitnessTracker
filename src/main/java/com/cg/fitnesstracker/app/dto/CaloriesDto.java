package com.cg.fitnesstracker.app.dto;

import java.time.LocalDate;

public class CaloriesDto {
	private int dietid;
	private LocalDate date;
	private String consumeTime;
	private int calories;
	public int getDietid() {
		return dietid;
	}
	public void setDietid(int dietid) {
		this.dietid = dietid;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getConsumeTime() {
		return consumeTime;
	}
	public void setConsumeTime(String consumeTime) {
		this.consumeTime = consumeTime;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	
}
