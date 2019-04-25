<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Page</title>
<%@ include file="Header.html"%>
</head>
<body>

	<h2>Policy Details</h2>
	<div class="column" style="background-color: #ddd;">
		<div>
			<label>Policy ID</label> <small>${policyToView.getPolicyId()}</small>
		</div>
		<div>
			<label>Quote ID</label> <small>${policyToView.getQuoteId()}</small>
		</div>
		<div>
			<label>Effective Date</label> <small>${policyToView.getEffectiveDate()}</small>
		</div>
		<div>
			<label>End Date</label> <small>${policyToView.getEndDate()}</small>
		</div>
		<div>
			<label>Term</label> <small>${policyToView.getTerm()}</small>
		</div>
		<div>
			<label>Policy Status</label> <small>${policyToView.getPolicyStatus()}</small>
		</div>
	</div>

</body>
</html>