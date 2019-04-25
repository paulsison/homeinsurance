package com.cts.homeinsurance.model;

public class Properties {
	
	private int locationId;
	private float marketValue;
	private int yearBuilt;
	private int squareFootage;
	private String dwellingType;
	private String roofMaterial;
	private String garageType;
	private int fullBaths;
	private int halfBaths;
	private boolean pool; //or BigDecimal to map Numeric type
	
	
	//Constructors
	public Properties() {
		super();		
	}
	public Properties(int locationId, float marketValue, int yearBuilt, int squareFootage, String dwellingType,
			String roofMaterial, String garageType, int fullBaths, int halfBaths, boolean pool) {
		super();
		this.locationId = locationId;
		this.marketValue = marketValue;
		this.yearBuilt = yearBuilt;
		this.squareFootage = squareFootage;
		this.dwellingType = dwellingType;
		this.roofMaterial = roofMaterial;
		this.garageType = garageType;
		this.fullBaths = fullBaths;
		this.halfBaths = halfBaths;
		this.pool = pool;
	}
	//Getters and Setters
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public float getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(float marketValue) {
		this.marketValue = marketValue;
	}
	public int getYearBuilt() {
		return yearBuilt;
	}
	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	public int getSquareFootage() {
		return squareFootage;
	}
	public void setSquareFootage(int squareFootage) {
		this.squareFootage = squareFootage;
	}
	public String getDwellingType() {
		return dwellingType;
	}
	public void setDwellingType(String dwellingType) {
		this.dwellingType = dwellingType;
	}
	public String getRoofMaterial() {
		return roofMaterial;
	}
	public void setRoofMaterial(String roofMaterial) {
		this.roofMaterial = roofMaterial;
	}
	public String getGarageType() {
		return garageType;
	}
	public void setGarageType(String garageType) {
		this.garageType = garageType;
	}
	public int getFullBaths() {
		return fullBaths;
	}
	public void setFullBaths(int fullBaths) {
		this.fullBaths = fullBaths;
	}
	public int getHalfBaths() {
		return halfBaths;
	}
	public void setHalfBaths(int halfBaths) {
		this.halfBaths = halfBaths;
	}
	public boolean hasPool() {
		return pool;
	}
	public void setPool(boolean pool) {
		this.pool = pool;
	}

	
	
}
