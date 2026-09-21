<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring view</title>
</head>
<body>
	<h2>Welcome to MG Page</h2>
	<hr color="blue">
	<br>
	<img alt="Spring mvc" src="<c:url value='/resources/images/spring.png'/>">
	<p>View Page in Spring MVC Web App</p>

	<br>
	<a href="ajax">Hello World</a>
</body>
</html>