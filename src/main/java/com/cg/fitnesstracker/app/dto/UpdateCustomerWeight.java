package com.cg.fitnesstracker.app.dto;

public class UpdateCustomerWeight {
	private int userId;
	private float updatedWeight;
	
	public int getUserId() {
		return userId;
	}
	public void setUserName(int userId) {
		this.userId = userId;
	}
	public float getUpdatedWeight() {
		return updatedWeight;
	}
	public void setUpdatedWeight(float weight) {
		this.updatedWeight = weight;
	}

}
