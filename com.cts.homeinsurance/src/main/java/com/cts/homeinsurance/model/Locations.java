package com.cts.homeinsurance.model;

public class Locations {

	private int locationId;
	private int userId;
	private String residenceType;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String locationState;
	private String zipCode;
	private String residenceUse;
	
	//Constructors
	public Locations() {
		super();		
	}
	
	public Locations(int userId, String residenceType, String addressLine1, String addressLine2,
			String city, String locationState, String zipCode, String residenceUse) {
		
		
		this.userId = userId;
		this.residenceType = residenceType;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.locationState = locationState;
		this.zipCode = zipCode;
		this.residenceUse = residenceUse;
	}
	
	//Getters and Setters
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getResidenceType() {
		return residenceType;
	}
	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocationState() {
		return locationState;
	}
	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getResidenceUse() {
		return residenceUse;
	}
	public void setResidenceUse(String residenceUse) {
		this.residenceUse = residenceUse;
	}
	

}
