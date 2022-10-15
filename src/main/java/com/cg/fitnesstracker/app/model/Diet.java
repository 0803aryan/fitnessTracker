package com.cg.fitnesstracker.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    
    @OneToMany(mappedBy="diet")
    @JsonManagedReference
    private List<Food> foodList;
    
    public Diet() {
    }

    public Diet(int dietId, ConsumeTime consumeTime, DayOfWeek dayOfWeek) {
        super();
        this.dietId = dietId;
        consumeTime = consumeTime;
        this.dayOfWeek = dayOfWeek;
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
        consumeTime = consumeTime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
    
    
}