<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<style>
form {
	margin: 10px;
	width: 10px;
}
</style>
</head>
<img
	src="https://cdn0.iconfinder.com/data/icons/small-n-flat/24/678085-house-512.png"
	width="100" height="100">
<body>
	<h1>Home Insurance</h1>
	<p>Welcome to our portal. This site will provide registered users
		with quotes and help them manage their policy details.</p>
	<p>
		<i>Please click on New User Registration below, if you do not have
			a login and password with our site.</i>
	</p>

	<form action="login" method="post">
		<div>
			<label>Name:</label> <input type="text" name="userName" />
		</div>
		<div>
			<label>Password:</label> <input type="text" name="password" />
		</div>
		<div>
			<input type="submit" value="Login" />
		</div>

	</form>
	<br>

	<%@ page import="java.util.ArrayList"%>
	<a id="reset_login" href="showLogin">Reset Login Page</a> |
	<a id="reg_page" href="showRegistrationPage">New User Registration</a> |
	<a id="admin_page" href="/homeinsurance/admin/AdminPage">Admin Login</a>

	<c:forEach items="${errorList}" var="error">
		<p style="color: red;">${error}</p>
	</c:forEach>

</body>
<%@ include file="Footer.html"%>
</html>