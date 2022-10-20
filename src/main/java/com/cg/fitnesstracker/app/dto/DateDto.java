package com.cg.fitnesstracker.app.dto;

import java.time.LocalDate;

public class DateDto {
	private LocalDate date;
	{
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public DateDto(LocalDate date) {
		super();
		this.date = date;
	}
	
	public DateDto() {
		
	}
}
