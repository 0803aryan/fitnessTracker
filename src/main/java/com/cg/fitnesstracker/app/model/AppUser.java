package com.cg.fitnesstracker.app.model;
import com.cg.fitnesstracker.app.model.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "login")
@Inheritance(strategy = InheritanceType.JOINED)
public class AppUser{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPUSER_SEQ")
    @SequenceGenerator(sequenceName = "appUser_seq", allocationSize = 1, name = "APPUSER_SEQ")
    private int userId;
    public int getUserId() {
		return userId;
	}

	  public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(length=40,unique=true)
	  private String username;
    @JsonIgnore
    private String password;

    private String role; 

	public AppUser() {
		super();
	}

	  public AppUser(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	  public String getRole() {
		return role;
	}

    public void setRole(String role) {
    	this.role = role;
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

