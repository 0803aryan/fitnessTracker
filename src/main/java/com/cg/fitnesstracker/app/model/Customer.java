package com.cg.fitnesstracker.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.fitnesstracker.app.model.enums.BodyType;
import com.cg.fitnesstracker.app.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="userdetails")
public class Customer extends AppUser{
	@Column(length=40,unique=true)
	private String userName;
	@Enumerated(EnumType.STRING)
	private Gender gender; //Enum
	@Enumerated(EnumType.STRING)
	private BodyType bodyType; //Enum
	private float weight;
	private int height;
	private int age;
	private boolean active=true;
	
	public Customer() {
		super();
	}
	public Customer(String userName, Gender gender, BodyType bodyType, float weight, int height, int age,
			boolean active, List<Activity> activities, List<Diet> diet) {
		super();
		this.userName = userName;
		this.gender = gender;
		this.bodyType = bodyType;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.active = active;
		this.activities = activities;
		this.diet = diet;
	}
	@OneToMany(mappedBy="customer")
	private List<Activity> activities;
	@JsonManagedReference
	@OneToMany(mappedBy="customer")
	private List<Diet> diet;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	public List<Diet> getDiet() {
		return diet;
	}
	public void setDiet(List<Diet> diet) {
		this.diet = diet;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public BodyType getBodyType() {
		return bodyType;
	}
	public void setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
