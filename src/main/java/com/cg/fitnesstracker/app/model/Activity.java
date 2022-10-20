package com.cg.fitnesstracker.app.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@XmlRootElement
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTIVITY_SEQ")
    @SequenceGenerator(sequenceName = "activity_seq", allocationSize = 1, name = "ACTIVITY_SEQ")
    private int activityId;
    private String activityName;
    private double caloriesBurned;
    private LocalDate date;
    {
		this.date = LocalDate.now();
    }

	@ManyToOne
    @JoinColumn(name="userId")
	@JsonBackReference
    private Customer customer;

	public Activity() {}
    
    public Activity(String activityName, double caloriesBurned, Customer customer) {
		super();
		this.activityName = activityName;
		this.caloriesBurned = caloriesBurned;
		this.customer = customer;
	}

    public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate localDate) {
		this.date = LocalDate.now();
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