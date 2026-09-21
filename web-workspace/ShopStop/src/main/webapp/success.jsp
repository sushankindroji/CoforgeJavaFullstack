<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Successful</title>
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
    <div class="login-box">
        <h2 style="color: #4ade80;">✓ Login Successful</h2>
        
        <h3>Welcome, <%= request.getAttribute("user") %>!</h3>
        
        <p><strong>Organization:</strong> <%= request.getAttribute("company") %></p>
        
        <p>You have successfully logged into the ShopStop application.</p>
        
        <%
            LocalDateTime loginTime = (LocalDateTime) request.getAttribute("loginDateTime");
            String formattedTime = "";
            if(loginTime != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, hh:mm:ss a");
                formattedTime = loginTime.format(formatter);
            }
        %>
        
        <p><strong>Login Time:</strong> <%= formattedTime %></p>
        
        <div class="button-group" style="margin-top: 30px;">
            <a href="index.html">
                <button style="width: 100%; background: #60a5fa;">Go to Home</button>
            </a>
        </div>
    </div>
</body>
</html>