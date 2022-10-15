package com.cg.fitnesstracker.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cg.fitnesstracker.app.model.enums.BodyType;
import com.cg.fitnesstracker.app.model.enums.Gender;

@Entity
public class UserDetails {
	@Id
	@GeneratedValue
	private int userDatailId;
	private Gender gender; //Enum
	private BodyType bodyType; //Enum
	private float weight;
	private int height;
	private int age;
	
	@OneToOne
	@JoinColumn(name ="userId")
	private AppUser user;
	
	public AppUser getUser() {
		return user;
	}
	public void setUser(AppUser user) {
		this.user = user;
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
