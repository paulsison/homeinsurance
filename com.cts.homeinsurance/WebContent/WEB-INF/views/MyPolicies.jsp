<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Policies</title>
<%@ include file="Header.html"%>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>Active Policies:</h1>
	<table>
		<tr>
			<th>Policy ID</th>
			<th>Quote ID</th>
			<th>Effective Date</th>
			<th>End Date</th>
			<th>Term</th>
			<th>Policy Status</th>			
		</tr>
		<c:forEach items="${policiesList}" var="Policies">
			<tr>
				<td>${Policies.getPolicyId()}</td>
				<td>${Policies.getQuoteId()}</td>
				<td>${Policies.getEffectiveDate()}</td>
				<td>${Policies.getEndDate()}</td>
				<td>${Policies.getTerm()}</td>
				<td>${Policies.getPolicyStatus()}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>