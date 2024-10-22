package com.cg.fitnesstracker.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.cg.fitnesstracker.app.model.enums.BodyType;
import com.cg.fitnesstracker.app.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="customer")
@XmlRootElement
public class Customer extends AppUser{
	@Column(length=40,unique=true)
    private String userEmail;
	@Enumerated(EnumType.STRING)
	private Gender gender; //Enum
	@Enumerated(EnumType.STRING)
	private BodyType bodyType; //Enum
	private float weight;
	private int height;
	private int age;
	private boolean active=true;
	private String firstName;
	private String lastName;
	
	public Customer() {
		super();
	}
	public Customer(String userEmail, Gender gender, BodyType bodyType, float weight, int height, int age,
			boolean active, List<Activity> activities, List<Diet> diet,String firstName, String lastName) {
		super();
		this.userEmail = userEmail;
		this.gender = gender;
		this.bodyType = bodyType;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.active = active;
		this.activities = activities;
		this.diet = diet;
		this.firstName =firstName;
		this.lastName = lastName;
	}
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="customer", cascade = { CascadeType.REMOVE})
	@JsonManagedReference
	private List<Activity> activities;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="customer", cascade = { CascadeType.REMOVE})
	@JsonManagedReference
	private List<Diet> diet;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
