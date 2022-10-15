package com.cg.fitnesstracker.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import com.cg.fitnesstracker.app.model.enums.DayOfWeek;

@MappedSuperclass
//@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class Activity {
    @Id
    @GeneratedValue
    private int activityId;
    private String activityName;
    private DayOfWeek dayOfWeek;
    
    public Activity() {}
    
    /*public Activity(int activityId, String activityName, DayOfWeek dayOfWeek) {
        super();
        this.activityId = activityId;
        this.activityName = activityName;
        this.dayOfWeek = dayOfWeek;
    }*/
    
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
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    
    
    
}