package com.cg.fitnesstracker.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends AppUser {
	@Column(length=40,unique=true)
	private String adminName;
	
	@Column(length=40,unique=true)
    private String userEmail;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Admin(String adminName) {
		super();
		this.adminName = adminName;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public Admin() {}
}
