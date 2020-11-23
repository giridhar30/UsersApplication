<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users application</title>
</head>
<body>
	<h1 align="center">Users App for Webtutplus</h1>
	
	
	
	<%
		if ((session.getAttribute("loggedIn")!=null && (boolean)session.getAttribute("loggedIn")) || request.getAttribute("mode").equals("MODE_LOGGEDIN")) {
			response.sendRedirect("/dashboard");
		} 
	%>
	
	<%
		if (request.getAttribute("mode").equals("MODE_HOME")) {
	%>

	<a href="/register">Register</a><br><br>
	<a href="/login">Login</a>

	<%
		} else if (request.getAttribute("mode").equals("MODE_REGISTER")) {
	%>
	
	<form action="/saveUser" method="post">
		Name: <input type="text" name="name" required /><br> 
		userName: <input type="text" name="userName" required /><br> 
		Password: <input type="password" name="password" required /><br><br>
		<input type="submit" value="Register" />
	</form>
	
	<%
		} else if (request.getAttribute("mode").equals("MODE_LOGIN")) {
	%>
	
	<form action="/checkUser" method="post">
		userName: <input type="text" name="userName" required /><br> 
		Password: <input type="password" name="password" required /><br><br>
		<input type="submit" value="Login" />
	</form>
	
	<%
		}
	%>


</body>
</html>