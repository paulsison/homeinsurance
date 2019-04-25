package com.cts.homeinsurance.model;



import java.sql.Date;

public class Policies {
	
	private int policyId;
	private int quoteId;
	private int userId;
	private Date effectiveDate;
	private Date endDate;
	private int term;
	private String policyStatus;
	
	//Constructors
	public Policies() {
		super();		
	}
	public Policies(int policyId, int quoteId, int userId, Date effectiveDate, Date endDate, int term,
			String policyStatus) {
		super();
		this.policyId = policyId;
		this.quoteId = quoteId;
		this.userId = userId;
		this.effectiveDate = effectiveDate;
		this.endDate = endDate;
		this.term = term;
		this.policyStatus = policyStatus;
	}
	//Getters and Setters
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	
	


}
