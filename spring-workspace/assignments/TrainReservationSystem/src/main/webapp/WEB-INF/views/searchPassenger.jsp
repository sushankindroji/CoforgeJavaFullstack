<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<html>
<head>
    <title>Search Passenger</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h2>Search Passenger by ID</h2>

    <form action="${pageContext.request.contextPath}/passenger/search" method="post">
        Enter Passenger ID: 
        <input type="number" name="passengerId" required min="1">
        <input type="submit" value="Search">
    </form>

    <br>

    <!-- Error Message -->
    <c:if test="${not empty error}">
        <p style="color: red; font-weight: bold;">${error}</p>
    </c:if>

    <!-- Passenger Details -->
    <c:if test="${not empty passenger}">
        <h3 style="color: green;">Passenger Found</h3>
        <table border="1" cellpadding="10">
            <tr><th>ID</th><td>${passenger.passengerId}</td></tr>
            <tr><th>Name</th><td>${passenger.passengerName}</td></tr>
            <tr><th>Age</th><td>${passenger.age}</td></tr>
            <tr><th>Gender</th><td>${passenger.gender}</td></tr>
            <tr><th>Mobile</th><td>${passenger.mobile}</td></tr>
            <tr><th>Email</th><td>${passenger.email}</td></tr>
            <tr><th>Aadhaar</th><td>${passenger.aadhaarNumber}</td></tr>
            <tr><th>Source Station</th><td>${passenger.sourceStation}</td></tr>
            <tr><th>Destination Station</th><td>${passenger.destinationStation}</td></tr>
            <tr>
                <th>Journey Date</th>
                <td>
                    <fmt:formatDate value="${passenger.journeyDate}" pattern="dd-MM-yyyy"/>
                </td>
            </tr>
            <tr><th>Seat Class</th><td>${passenger.seatClass}</td></tr>
            <tr><th>Ticket Fare</th><td>₹ ${passenger.ticketFare}</td></tr>
        </table>
    </c:if>

    <br><br>
    <a href="${pageContext.request.contextPath}/">Home</a> |
    <a href="${pageContext.request.contextPath}/passenger/list">View All Passengers</a>
</body>
</html>