<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Policy</title>
</head>
<%@ include file="Header.html"%>
<body>
	<h1>Buy Policy</h1>
	<h2>Quote ID: ${currentQuote.getQuoteId()}</h2>
	<p>
		<b><font color="red">Note:</font>Policy Date cannot be more than
			60 days from today's date.</b>
	</p>
	<form action="buyPolicy" method="post">
		<div>
			<label>Enter Policy Start Date:</label> <input type="text"
				name="effectiveDate" /> mm/dd/yyyy
		</div>
		<div>
			<input type="submit" value="Buy" />
		</div>
	</form>

</body>
<%@ include file="Footer.html"%>
</html>