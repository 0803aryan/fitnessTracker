package com.cg.fitnesstracker.app.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.fitnesstracker.app.model.enums.ConsumeTime;
import com.cg.fitnesstracker.app.model.enums.DayOfWeek;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="DIET")
public class Diet {
    @Id
    @GeneratedValue
    private int dietId;
    private ConsumeTime consumeTime;
    private DayOfWeek dayOfWeek;
    private LocalDate date;
    
    public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

//	@OneToMany //(mappedBy="diet")
    @JsonManagedReference
//	@JoinColumn(name="foodId")
    private List<FoodItem> foodList;

	@ManyToOne
    @JoinColumn(name="userName")
    private Customer customer;
    
    public Diet() {
    }

    
    public Diet(ConsumeTime consumeTime, DayOfWeek dayOfWeek, LocalDate date, List<FoodItem> foodList,
			Customer customer) {
		super();
		this.consumeTime = consumeTime;
		this.dayOfWeek = dayOfWeek;
		this.date = date;
		this.foodList = foodList;
		this.customer = customer;
	}

	public Customer getCustomer() {
    	return customer;
    }
    
    public void setCustomer(Customer customer) {
    	this.customer = customer;
    }
    
    public List<FoodItem> getFoodList() {
    	return foodList;
    }
    
    public void setFoodList(List<FoodItem> foodList) {
    	this.foodList = foodList;
    }

    public int getDietId() {
        return dietId;
    }

    public void setDietId(int dietId) {
        this.dietId = dietId;
    }

    public ConsumeTime getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(ConsumeTime consumeTime) {
        this.consumeTime = consumeTime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    

	
    
}