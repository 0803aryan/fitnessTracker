package com.cg.fitnesstracker.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="FOOD_ITEM")
public class FoodItem {
    @Id
    @GeneratedValue
    private int foodId;
    @Column(length=40)
    private String foodName;
    private String foodQuantity;
    private int caloriesInFood;
    
    @ManyToOne
    @JoinColumn(name="dietId")
    @JsonBackReference
    private Diet diet;


	public FoodItem() {}
    
	public FoodItem(String foodName, String foodQuantity, int caloriesInFood) {
        super();
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