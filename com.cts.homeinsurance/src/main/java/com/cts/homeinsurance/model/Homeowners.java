package com.cts.homeinsurance.model;
import java.sql.Date;

public class Homeowners {

	private int userID;
	private String firstName; 
	private String lastName;
	private Date dob;
	private boolean retiredStatus; 
	private String ssn;
	private String email;

	//Constructors
	public Homeowners() {
		super();
	}

	public Homeowners(int userID, String firstName, String lastName, Date dob, boolean retiredStatus, String ssn,
			String email) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.retiredStatus = retiredStatus;
		this.ssn = ssn;
		this.email = email;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isRetiredStatus() {
		return retiredStatus;
	}

	public void setRetiredStatus(boolean retiredStatus) {
		this.retiredStatus = retiredStatus;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}






}
