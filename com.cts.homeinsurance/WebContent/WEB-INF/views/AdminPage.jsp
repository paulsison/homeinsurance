<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<style>
form {
	margin: 10px;
	width: 10px;
}
</style>
</head>
<body>
<img src="https://cdn0.iconfinder.com/data/icons/small-n-flat/24/678085-house-512.png" width="80" height="80">
<h1>Home Insurance</h1>
	<h2>Administration Login</h2>
	<form action="loginAdmin" method="post">
		<div>
			<label>Name:</label> <input type="text" name="userName" />
		</div>
		<div>
			<label>Password:</label> <input type="text" name="password" />
		</div>
		<div>
			<input type="submit" value="Login as Administrator" />
		</div>

	</form>

	<%@ page import="java.util.ArrayList"%>
	<a href="/homeinsurance/">Go Back to User Login Page</a> |

	<c:forEach items="${errorList}" var="error">
		<p style="color: red;">${error}</p>
	</c:forEach>


</body>
</html>