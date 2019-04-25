<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homeowner Information</title>
<%@ include file="Header.html"%>

</head>
<body>

	<h1>Homeowner Information</h1>

	<form action="postHomeowner" method="post">
		<div>
			<label>First Name:</label> <input type="text" name="firstName" />
		</div>
		<div>
			<label>Last Name:</label> <input type="text" name="lastName" />
		</div>
		<div>
		<label>Date of Birth:</label> <input type="text" name="dob" placeholder="MM-DD-YY"/>
		</div>
		<div>
			<label>Are you retired?:</label> 
			<input type="radio" name="retiredStatus" value="1" />Yes 
			<input type="radio" name="retiredStatus" value="0" />No
		</div>
		<div>
			<label>Social Security Number:</label> <input type="text" name="ssn" />
		</div>
		<div>
			<label>Email Address:</label> <input type="text" name="email" />
		</div>
		<div>
			<input type="submit" value="Continue" />
		</div>
	</form>

</body>
<%@ include file="Footer.html" %>
</html>