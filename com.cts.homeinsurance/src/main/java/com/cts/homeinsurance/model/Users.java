package com.cts.homeinsurance.model;

public class Users {

	private int userId;
	private String userName;
	private String password;
	private String adminRole;
	
	//Constructors
	public Users() {
		super();		
	}

	public Users(int userId, String userName, String password, String adminRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.adminRole = adminRole;
	}

	public Users(String userName, String password, String adminRole) {
		this.userName = userName;
		this.password = password;
		this.adminRole = adminRole;
	}

	//Getters and Setters
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

}

