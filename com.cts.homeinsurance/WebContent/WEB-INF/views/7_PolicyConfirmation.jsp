<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Confirmation</title>
</head>
<%@ include file="Header.html"%>
<body>
	<h1>Policy Confirmation</h1>
	<div class="column" style="background-color: #ddd;">
		<div>
			<label>Quote ID</label> <small>${currentPolicy.getQuoteId()}</small>
		</div>
		<div>
			<label>Policy Key</label> <small>${currentPolicy.getQuoteId()}<span>&#95;</span>${currentPolicy.getPolicyId()}</small>
		</div>
		<div>
			<label>Policy Effective Date</label> <small>${currentPolicy.getEffectiveDate()}</small>
		</div>
		<div>
			<label>Policy End Date</label> <small>${currentPolicy.getEndDate()}</small>
		</div>
		<div>
			<label>Policy Term</label> <small>${currentPolicy.getTerm()} year</small>
		</div>
		<div>
			<label>Policy Status</label> <small>${currentPolicy.getPolicyStatus()}</small>
		</div>
	</div>

</body>
<%@ include file="Footer.html"%>
</html>