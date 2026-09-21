<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
        <p>Available Courses (Demo)</p>
        <ul>
            <li>Java Programming</li>
            <li>Web Development</li>
            <li>Database Systems</li>
        </ul>
        <a href="LogoutServlet" class="btn">Logout</a>
    </div>
</body>
</html>