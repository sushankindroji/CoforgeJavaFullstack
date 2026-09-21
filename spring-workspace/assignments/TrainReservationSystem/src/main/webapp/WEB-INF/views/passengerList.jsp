<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Passenger List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h2>Passenger List</h2>

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Mobile</th>
            <th>Email</th>
            <th>Source</th>
            <th>Destination</th>
            <th>Journey Date</th>
            <th>Class</th>
            <th>Fare</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="p" items="${passengers}">
            <tr>
                <td>${p.passengerId}</td>
                <td>${p.passengerName}</td>
                <td>${p.age}</td>
                <td>${p.gender}</td>
                <td>${p.mobile}</td>
                <td>${p.email}</td>
                <td>${p.sourceStation}</td>
                <td>${p.destinationStation}</td>
                <td><fmt:formatDate value="${p.journeyDate}" pattern="yyyy-MM-dd"/></td>
                <td>${p.seatClass}</td>
                <td>${p.ticketFare}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/passenger/edit/${p.passengerId}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/passenger/delete/${p.passengerId}"
                       onclick="return confirm('Are you sure you want to delete this passenger?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/passenger/add">Add New Passenger</a> |
    <a href="${pageContext.request.contextPath}/">Home</a>
</body>
</html>