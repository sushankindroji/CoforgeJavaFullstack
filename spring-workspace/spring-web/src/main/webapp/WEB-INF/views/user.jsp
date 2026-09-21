<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
</head>
<body background="<c:url value="/resources/images/back1.jpg"/>">
	<div style="color:white;text-align:center;padding:100px;">
		<h1>Expression Language is used to access Attributes in JSP</h1>
		<h1>Welcome to ${user} User Page</h1>

		<p>Page served on ${d}</p>

		<a href="spring">Click here for one more View</a>
	</div>
</body>
</html>