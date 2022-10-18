package com.cg.fitnesstracker.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.cg.fitnesstracker.app.model.enums.DayOfWeek;
import com.fasterxml.jackson.annotation.JsonBackReference;

//@MappedSuperclass
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class Activity {
    @Id
    @GeneratedValue
    private int activityId;
    private String activityName;
    private double caloriesBurned;
    
	@ManyToOne
    @JoinColumn(name="userName")
	@JsonBackReference
    private Customer customer;

	public Activity() {}
    
    public Activity(String activityName, double caloriesBurned, Customer customer) {
		super();
		this.activityName = activityName;
		this.caloriesBurned = caloriesBurned;
		this.customer = customer;
	}



	public double getCaloriesBurned() {
		return caloriesBurned;
	}

	public void setCaloriesBurned(double caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	
    public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

    
    public int getActivityId() {
        return activityId;
    }
    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
    public String getActivityName() {
        return activityName;
    }
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    
}