package com.cg.fitnesstracker.app.model;
import com.cg.fitnesstracker.app.model.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "userlogin")
public class AppUser {
    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(length=20)
    private String username;
    @Column(length=40)
    private String userEmail;
    @JsonIgnore
    private String password;
    private UserType userType; //Enum
    private boolean isActive;
  
    public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UserType getUserType() {
		return userType;
	}

    public void setUserType(UserType userType) {
    	this.userType = userType;
    }
    
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

