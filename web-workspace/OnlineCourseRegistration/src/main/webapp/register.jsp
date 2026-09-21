<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Register</h2>
        <% if(request.getAttribute("error") != null) { %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <% } %>
        <form action="RegisterServlet" method="post">
            <input type="text" name="fullname" placeholder="Full Name" required><br>
            <input type="email" name="email" placeholder="Email" required><br>
            <input type="text" name="mobile" placeholder="Mobile Number" required><br>
            <input type="password" name="password" placeholder="Password" required><br>
            <input type="password" name="confirmPassword" placeholder="Confirm Password" required><br>
            <button type="submit">Register</button>
        </form>
        <p>Already have account? <a href="login.jsp">Login here</a></p>
    </div>
</body>
</html>