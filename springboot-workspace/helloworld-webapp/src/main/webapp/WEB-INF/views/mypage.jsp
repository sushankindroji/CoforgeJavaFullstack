<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
}

h1 {
	color: brown;
	border-bottom: 2px solid #007bff;
	padding-bottom: 10px;
}

h2 {
	font-size: 1.5em;
	color: #007bff;
	margin: 20px 0;
}
</style>
</head>
<body>

	<h1>Hello World from Spring Boot</h1>
	<h2>Spring Boot View created using JSP</h2>
	<hr>
	<h2>My Page Created By : ${name} at ${date}</h2>
</body>
</html>
