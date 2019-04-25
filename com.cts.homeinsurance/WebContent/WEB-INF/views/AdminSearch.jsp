<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Screen</title>
<%@ include file="Header2.html"%>
</head>
<body>
<br>
<form action="searchUser" method="post">
		<div>
			<label>User Name:</label> <input type="text" name="userName" />
		</div>
		
		<div>
			<input type="submit" value="Search" />
		</div>

	</form>
</body>
</html>