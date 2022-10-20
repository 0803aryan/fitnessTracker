package com.cg.fitnesstracker.app.dto;

import java.time.LocalDate;
import java.util.List;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Diet;

public class ReportDto {
	private LocalDate date;
	private String userName;
	private List<Diet> dietsConsumed;
	private List<Activity> activitiesDone;
	private int caloriesConsumed;
	private int caloriesBurned;
	private float BMI;
	
	public float getBMI() {
		return BMI;
	}
	public void setBMI(float BMI) {
		this.BMI = BMI;
	}
	public ReportDto() {
		
	}
	public ReportDto(String userName, List<Diet> dietsConsumed, List<Activity> activitiesDone,
			int caloriesConsumed, int caloriesBurned, float bMI) {
		super();
		this.userName = userName;
		this.dietsConsumed = dietsConsumed;
		this.activitiesDone = activitiesDone;
		this.caloriesConsumed = caloriesConsumed;
		this.caloriesBurned = caloriesBurned;
		BMI = bMI;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Diet> getDietsConsumed() {
		return dietsConsumed;
	}
	public void setDietsConsumed(List<Diet> dietsConsumed) {
		this.dietsConsumed = dietsConsumed;
	}
	public List<Activity> getActivitiesDone() {
		return activitiesDone;
	}
	public void setActivitiesDone(List<Activity> activitiesDone) {
		this.activitiesDone = activitiesDone;
	}
	public int getCaloriesConsumed() {
		return caloriesConsumed;
	}
	public void setCaloriesConsumed(int caloriesConsumed) {
		this.caloriesConsumed = caloriesConsumed;
	}
	public int getCaloriesBurned() {
		return caloriesBurned;
	}
	public void setCaloriesBurned(int caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	
	
}
