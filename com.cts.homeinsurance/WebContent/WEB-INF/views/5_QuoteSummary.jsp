<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quote Summary</title>
<%@ include file="Header.html"%>
</head>
<body>
	<h1>Quote Summary</h1>
	<h2>Monthly Premium ${currentQuote.getMonthlyPremium()}</h2>
	<form action="/homeinsurance/buyQuote">
		<input type="submit" value="Buy Quote" />
	</form>

	<div class="row">
		<div class="column" style="background-color: #ddd;">
			<h3>Location Details</h3>
			<div>
				<label>Residence Type </label><small>${currentLocation.getResidenceType()}</small>
			</div>
			<div>
				<label>Address Line 1 </label><small>${currentLocation.getAddressLine1()}</small>
			</div>
			<div>
				<label>Address Line 2 </label><small>${currentLocation.getAddressLine2()}</small>
			</div>
			<div>
				<label>City </label><small>${currentLocation.getCity()}</small>
			</div>
			<div>
				<label>State </label><small>${currentLocation.getLocationState()}</small>
			</div>
			<div>
				<label>Zip Code </label><small>${currentLocation.getZipCode()}</small>
			</div>
			<div>
				<label>Residence Use </label><small>${currentLocation.getResidenceUse()}</small>
			</div>
		</div>
		<div class="column" style="background-color: #ddd;">
			<h3>Homeowner Details</h3>
			<div>
				<label>First Name </label><small>${currentHomeowner.getFirstName()}</small>
			</div>
			<div>
				<label>Last Name </label><small>${currentHomeowner.getLastName()}</small>
			</div>
			<div>
				<label>Date of Birth </label><small>${currentHomeowner.getDob()}</small>
			</div>
			<div>
				<label>Is Retired? </label><small>${currentHomeowner.isRetiredStatus()}</small>
			</div>
			<div>
				<label>Social Security Number </label><small>${currentHomeowner.getSsn()}</small>
			</div>
			<div>
				<label>Email Address </label><small>${currentHomeowner.getEmail()}</small>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="column" style="background-color: #ddd;">
			<h3>Property Details</h3>
			<div>
				<label>Market Value </label><small>${currentProperty.getMarketValue()}</small>
			</div>
			<div>
				<label>Year Built </label><small>${currentProperty.getYearBuilt()}</small>
			</div>
			<div>
				<label>Square Footage </label> <small>${currentProperty.getSquareFootage()}</small>
			</div>
			<div>
				<label>Dwelling Type </label><small>${currentProperty.getDwellingType()}</small>
			</div>
			<div>
				<label>Roof Material </label><small>${currentProperty.getRoofMaterial()}</small>
			</div>
			<div>
				<label>Type of Garage </label> <small>${currentProperty.getGarageType()}</small>
			</div>
			<div>
				<label>Number of full baths </label><small>${currentProperty.getFullBaths()}</small>
			</div>
			<div>
				<label>Number of half baths </label><small>${currentProperty.getHalfBaths()}</small>
			</div>
			<div>
				<label>Swimming Pool </label><small>${currentProperty.hasPool()}</small>
			</div>
		</div>
		<div class="column" style="background-color: #ddd;">
			<h3>Coverage Details</h3>
			<div>
				<label>Monthly Premium </label><small>${currentQuote.getMonthlyPremium()}</small>
			</div>
			<div>
				<label>Dwelling Coverage </label><small>${currentQuote.getDwellingCoverage()}</small>
			</div>
			<div>
				<label>Detached Structures </label> <small>${currentQuote.getDetachedStructures()}</small>
			</div>
			<div>
				<label>Personal Property </label> <small>${currentQuote.getPersonalProperty()}</small>
			</div>
			<div>
				<label>Additional living expenses </label> <small>${currentQuote.getAddLivingExp()}</small>
			</div>
			<div>
				<label>Medical Expense </label> <small>${currentQuote.getMedicalExpense()}</small>
			</div>
			<div>
				<label>Deductible </label> <small>${currentQuote.getDeductible()}</small>
			</div>
		</div>
	</div>
	<br>
	<form action="/homeinsurance/buyQuote">
		<input type="submit" value="Buy Quote" />
	</form>
</body>
<%@ include file="Footer.html"%>
</html>