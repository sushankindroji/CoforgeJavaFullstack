<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Success!</h2>
        <p><%= request.getAttribute("message") %></p>
        <a href="login.jsp" class="btn">Go to Login</a>
    </div>
</body>
</html>