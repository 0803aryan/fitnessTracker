package com.cg.fitnesstracker.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends AppUser {
	@Column(length=40,unique=true)
	private String adminName;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public Admin() {}
}
