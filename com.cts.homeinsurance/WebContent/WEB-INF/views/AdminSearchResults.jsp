<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Search Results</title>
<%@ include file="Header2.html"%>
</head>
<body>
<h1>${userName} Policies</h1>
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
				<td><a
					href="/homeinsurance/admin/renewUserPolicy?id1=${Policies.getPolicyId()}">Renew</a>
				<td><a
					href="/homeinsurance/admin/cancelUserPolicy?id2=${Policies.getPolicyId()}">Cancel</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>