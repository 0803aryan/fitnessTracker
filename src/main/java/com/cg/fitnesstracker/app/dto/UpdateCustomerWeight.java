package com.cg.fitnesstracker.app.dto;

public class UpdateCustomerWeight {
	private String userName;
	private float updatedWeight;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public float getUpdatedWeight() {
		return updatedWeight;
	}
	public void setUpdatedWeight(float weight) {
		this.updatedWeight = weight;
	}

}
