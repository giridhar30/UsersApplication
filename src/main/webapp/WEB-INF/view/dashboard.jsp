<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<%
		if((boolean)session.getAttribute("loggedIn")) {
	%>
	
	<h1 align="center">Users App for Webtutplus</h1><br>
	<h1 align="center">Hi <%=session.getAttribute("userName") %>!</h1>
	<h2 align="center">You are logged in!</h2><br>
	<a href="/logout">logout</a>
	
	<%
		} else response.sendRedirect("/login");
	%>
</body>
</html>