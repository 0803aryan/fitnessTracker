package com.cg.fitnesstracker.app.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.cg.fitnesstracker.app.model.enums.ConsumeTime;
import com.cg.fitnesstracker.app.model.enums.DayOfWeek;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="DIET")
@XmlRootElement
public class Diet {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIET_SEQ")
    @SequenceGenerator(sequenceName = "DIET_seq", allocationSize = 1, name = "DIET_SEQ")
    private int dietId;
    
    @Enumerated(EnumType.STRING)
    private ConsumeTime consumeTime;
    
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
    
    private LocalDate date;
	
    @OneToMany(mappedBy="diet")
    @JsonManagedReference
    private List<Meal> mealList;

	@ManyToOne
	@JoinColumn(name="userId")
	@JsonBackReference
	private Customer customer;
	
	{
		this.date=LocalDate.now();
	}
    
	public Diet() {}
    
    public Diet(ConsumeTime consumeTime, DayOfWeek dayOfWeek) {
		super();
		this.consumeTime = consumeTime;
		this.dayOfWeek = dayOfWeek;
		
	}

	public Customer getCustomer() {
    	return customer;
    }
    
    public void setCustomer(Customer customer) {
    	this.customer = customer;
    }
    
 

    public List<Meal> getMealList() {
		return mealList;
	}

	public void setMealList(List<Meal> mealList) {
		this.mealList = mealList;
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
    
    
    public LocalDate getDate() {
		return date;
	}

	public void setDate() {
		this.date = LocalDate.now();
	}

	
    
}