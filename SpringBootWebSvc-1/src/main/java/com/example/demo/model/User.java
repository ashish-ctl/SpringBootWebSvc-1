package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="User Entity -- All Fields are Mandatory.")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(notes="UserId cannot be 0")
	private int userId;
	@ApiModelProperty(notes="UserName cannnot be Admin.")
	private String userName;
	private String userRole;
	private String userCity;
	private String userState;
	private String userCountry;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public User(int userId, String userName, String userRole, String userCity, String userState, String userCountry) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
		this.userCity = userCity;
		this.userState = userState;
		this.userCountry = userCountry;
	}

	public User() {
		super();
	}

}
