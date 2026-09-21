<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Train Reservation System</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h1>Train Reservation System – Passenger Management</h1>

    <div class="menu">
        <a href="${pageContext.request.contextPath}/passenger/add">Add Passenger</a>
        <a href="${pageContext.request.contextPath}/passenger/list">View Passengers</a>
        <a href="${pageContext.request.contextPath}/passenger/search">Search Passenger</a>
    </div>
</body>
</html>