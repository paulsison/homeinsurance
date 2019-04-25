<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Started Page</title>
</head>
<%@ include file="Header.html"%>

<body>
	
	<h1>Welcome ${currentUser.getUserName()}!</h1>
	<h1>Get Started Page</h1>

	<form action="showLocationPage" method="get">
		<input type="submit" value="Get a Quote"
			style="height: 40px; width: 160px" />
	</form>

	<form action="showMyQuotesPage" method="get">
		<input type="submit" value="Retrieve a Quote"
			style="height: 40px; width: 160px" />
	</form>
	<br>
	<a href="logout">Logout</a>

</body>
<%@ include file="Footer.html"%>
</html>