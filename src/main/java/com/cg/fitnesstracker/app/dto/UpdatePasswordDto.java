package com.cg.fitnesstracker.app.dto;

public class UpdatePasswordDto {
private int userId;
private String newPassword;

public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getNewPassword() {
	return newPassword;
}
public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
}

}
