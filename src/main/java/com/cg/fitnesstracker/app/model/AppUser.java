package com.cg.fitnesstracker.app.model;
import com.cg.fitnesstracker.app.model.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "login")
@Inheritance(strategy = InheritanceType.JOINED)
public class AppUser{
    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(length=40,unique=true)
    private String userEmail;
    @JsonIgnore
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType; //Enum

	public AppUser() {
		super();
	}

	public AppUser(String userEmail, String password, UserType userType) {
		super();
		this.userEmail = userEmail;
		this.password = password;
		this.userType = userType;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

