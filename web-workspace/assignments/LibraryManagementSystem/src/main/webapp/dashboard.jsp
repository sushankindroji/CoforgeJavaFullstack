<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Welcome, <%= user.getFullname() %>!</h2>
        <a href="addBook.jsp" class="btn">Add Book</a>
        <a href="ViewBooksServlet" class="btn">View Books</a>
        <a href="LogoutServlet" class="btn">Logout</a>
    </div>
</body>
</html>