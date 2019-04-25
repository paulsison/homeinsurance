<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location Page</title>
<%@ include file="Header.html"%>

</head>
<body>
	<h2 align="center">Get quote:</h2>
	<form action="postLocation" method="post">
		<div>
			<label>Residence Type:</label> <select name="residenceType">
				<option value="single family home">Single-Family Home</option>
				<option value="condo">Condo</option>
				<option value="townhouse">Townhouse</option>
				<option value="rowhouse">Rowhouse</option>
				<option value="duplex">Duplex</option>
				<option value="apartment">Apartment</option>
			</select>
		</div>
		<div>
			<label>Address Line 1:</label> <input type="text" name="addressLine1" />
		</div>
		<div>
			<label>Address Line 2:</label> <input type="text" name="addressLine2" />
		</div>
		<div>
			<label>City:</label> <input type="text" name="city" />
		</div>
		<div>
			<label>State:</label> <input type="text" name="locationState" />
		</div>
		<div>
			<label>Zip Code:</label> <input type="text" name="zipCode" />
		</div>
		<div>
			<label>Residence Use:</label> <select name="residenceUse">
				<option value="primary">Primary</option>
				<option value="secondary">Secondary</option>
				<option value="rental property">Rental Property</option>
			</select>
		</div>
		<div>
			<input type="submit" value="Continue" />
		</div>
	</form>
</body>
<%@ include file="Footer.html"%>
</html>