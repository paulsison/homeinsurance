<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
<style>
form {
	margin: 10px;
	width: 10px;
}
</style>
</head>

<body>
	<h1>Registration Page</h1>
	<form action="registerUser" method="post">
		<div>
			<label>User Name:</label>
			<input type="text" name="userName" />
		</div>
		<div>
			<label>Password:</label>
			<input type="text" name="password" />
		</div>
		<div>
			<input type="submit" value="Register" />
		</div>
	</form>
	<a href="showLoginPage">Back to Login Page</a>
</body>
<%@ include file="Footer.html" %>
</html>