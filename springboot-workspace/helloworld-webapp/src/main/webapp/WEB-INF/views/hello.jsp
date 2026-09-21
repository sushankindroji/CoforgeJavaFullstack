<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Boot JSP - Hello World</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
}

.container {
	max-width: 800px;
	margin: 0 auto;
	background: white;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.container h1 {
	color: brown;
	border-bottom: 2px solid #007bff;
	padding-bottom: 10px;
}

.hello-message {
	font-size: 1.5em;
	color: #007bff;
	margin: 20px 0;
}

.info {
	background-color: #e9ecef;
	padding: 15px;
	border-radius: 4px;
	margin-top: 20px;
}

.btn {
	display: inline-block;
	padding: 12px 24px;
	background-color: #3498db;
	color: white;
	text-decoration: none;
	border-radius: 5px;
	margin: 0 10px;
	transition: background-color 0.3s ease;
}

.btn:hover {
	background-color: #2980b9;
}
</style>
</head>
<body>
<div class="container">
		<h1>Spring Boot JSP Hello World</h1>

		<div class="hello-message">
			Hello, <strong>${name}</strong>! 👋
		</div>

		<div class="info">
			<h3>Try these URLs:</h3>
			<ul>
				<li><a href="/hello">hello (default)</a></li>
				<li><a href="/hello?name=Dave Syer">Dave Syer</a></li>
				<li><a href="/hello?name=Phil Webb">Phil Webb</a></li>
				<li><a href="/hello?name=ajax">ajax</a></li>
			</ul>
		</div>

		<div style="margin-top: 20px;">
			<p>
				<strong>Current Time:</strong>
				<%= new java.util.Date() %></p>
		</div>
		<div class="navigation" style="margin-top: 30px;">
			<a href="employees" class="btn">👥 View Employees</a>
		</div>
	</div>
</body>
</html>