<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coverage Details</title>
<%@ include file="Header.html"%>
</head>
<body>
	<h2>Coverage Details</h2>
	<div class="column" style="background-color: #ddd;">
		<div>
			<label>Quote ID</label>
			<small>${currentQuote.getQuoteId()}</small>
		</div>
		<div>
			<label>Monthly Premium</label>
			<small>${currentQuote.getMonthlyPremium()}</small>
		</div>
		<div>
			<label>Dwelling Coverage</label>
			<small>${currentQuote.getDwellingCoverage()}</small>
		</div>
		<div>
			<label>Detached Structures</label>
			<small>${currentQuote.getDetachedStructures()}</small>
		</div>
		<div>
			<label>Personal Property</label>
			<small>${currentQuote.getPersonalProperty()}</small>
		</div>
		<div>
			<label>Additional living expenses</label>
			<small>${currentQuote.getAddLivingExp()}</small>
		</div>
		<div>
			<label>Medical Expense</label>
			<small>${currentQuote.getMedicalExpense()}</small>
		</div>
		<div>
			<label>Deductible</label>
			<small>${currentQuote.getDeductible()}</small>
		</div>
	</div>
	<br>
	<form action="/homeinsurance/showQuoteSummary">
		<input type="submit" value="Proceed to Buy" />
	</form>
	<br>
</body>
<%@ include file="Footer.html"%>
</html>