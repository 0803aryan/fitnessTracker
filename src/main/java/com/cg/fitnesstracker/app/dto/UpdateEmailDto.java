package com.cg.fitnesstracker.app.dto;

import javax.validation.constraints.NotEmpty;

public class UpdateEmailDto {

private int userId;
private String newEmail;

public UpdateEmailDto() {
	super();
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getNewEmail() {
	return newEmail;
}
public void setNewEmail(String newEmail) {
	this.newEmail = newEmail;
}
}

