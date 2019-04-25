<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Quotes</title>
<%@ include file="Header.html"%>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
<h1>My Quotes</h1>
	<table>
		<tr>
			<th>Quote ID</th>
			<th>Location ID</th>
			<th>Dwelling Coverage</th>
			<th>Personal Property</th>
			<th>Add Living Expense</th>
			<th>Medical Expense</th>
			<th>Deductible</th>			
		</tr>
		<c:forEach items="${quotesList}" var="Quotes">
			<tr>
				<td>${Quotes.getQuoteId()}</td>
				<td>${Quotes.getLocationId()}</td>
				<td>${Quotes.getDwellingCoverage()}</td>
				<td>${Quotes.getPersonalProperty()}</td>
				<td>${Quotes.getAddLivingExp()}</td>
				<td>${Quotes.getMedicalExpense()}</td>
				<td>${Quotes.getDeductible()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>