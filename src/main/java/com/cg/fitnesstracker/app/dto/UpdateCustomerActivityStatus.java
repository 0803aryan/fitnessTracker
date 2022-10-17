package com.cg.fitnesstracker.app.dto;

public class UpdateCustomerActivityStatus {
	
	private String userName;
	private boolean updatedActivityStatus;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isUpdatedActivityStatus() {
		return updatedActivityStatus;
	}
	public void setUpdatedActivityStatus(boolean updatedActivityStatus) {
		this.updatedActivityStatus = updatedActivityStatus;
	}
}
