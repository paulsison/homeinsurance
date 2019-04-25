package com.cts.homeinsurance.model;

public class Quotes {
	
	private int quoteId;
	private int locationId;
	private float monthlyPremium;
	private float dwellingCoverage;
	private float detachedStructures;
	private float personalProperty;
	private float addLivingExp;
	private float medicalExpense;
	private float deductible;
	
	
	//Constructors
	public Quotes() {
		super();		
	}
	public Quotes(int quoteId, int locationId, float monthlyPremium, float dwellingCoverage, float detachedStructures,
			float personalProperty, float addLivingExp, float medicalExpense, float deductible) {
		super();
		this.quoteId = quoteId;
		this.locationId = locationId;
		this.monthlyPremium = monthlyPremium;
		this.dwellingCoverage = dwellingCoverage;
		this.detachedStructures = detachedStructures;
		this.personalProperty = personalProperty;
		this.addLivingExp = addLivingExp;
		this.medicalExpense = medicalExpense;
		this.deductible = deductible;
	}
	
	//Getters and Setters
	public int getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public float getMonthlyPremium() {
		return monthlyPremium;
	}
	public void setMonthlyPremium(float monthlyPremium) {
		this.monthlyPremium = monthlyPremium;
	}
	public float getDwellingCoverage() {
		return dwellingCoverage;
	}
	public void setDwellingCoverage(float dwellingCoverage) {
		this.dwellingCoverage = dwellingCoverage;
	}
	public float getDetachedStructures() {
		return detachedStructures;
	}
	public void setDetachedStructures(float detachedStructures) {
		this.detachedStructures = detachedStructures;
	}
	public float getPersonalProperty() {
		return personalProperty;
	}
	public void setPersonalProperty(float personalProperty) {
		this.personalProperty = personalProperty;
	}
	public float getAddLivingExp() {
		return addLivingExp;
	}
	public void setAddLivingExp(float addLivingExp) {
		this.addLivingExp = addLivingExp;
	}
	public float getMedicalExpense() {
		return medicalExpense;
	}
	public void setMedicalExpense(float medicalExpense) {
		this.medicalExpense = medicalExpense;
	}
	public float getDeductible() {
		return deductible;
	}
	public void setDeductible(float deductible) {
		this.deductible = deductible;
	}
	
	


}
