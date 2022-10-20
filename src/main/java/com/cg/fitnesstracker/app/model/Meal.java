package com.cg.fitnesstracker.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="Meal")
@Component
@Scope("prototype")
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEAL_SEQ")
    @SequenceGenerator(sequenceName = "meal_seq", allocationSize = 1, name = "MEAL_SEQ")
    private int mealId;
	private int foodId;
    private String foodName;
    private String foodQuantity;
    private int caloriesInFood;
    
    @ManyToOne
    @JoinColumn(name="dietId")
    @JsonBackReference
    private Diet diet;
    

	public Meal() {}
    
	public Meal(int foodId, String foodName, String foodQuantity, int caloriesInFood) {
        super();
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodQuantity = foodQuantity;
        this.caloriesInFood = caloriesInFood;
    }
    
  
    public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public void setFoodQuantity(String foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuant(String foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public int getCaloriesInFood() {
        return caloriesInFood;
    }

    public void setCaloriesInFood(int caloriesInFood) {
        this.caloriesInFood = caloriesInFood;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }
   
}