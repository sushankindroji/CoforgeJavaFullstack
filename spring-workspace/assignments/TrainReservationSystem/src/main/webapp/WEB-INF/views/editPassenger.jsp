<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Edit Passenger</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h2>Edit Passenger</h2>

    <form:form action="${pageContext.request.contextPath}/passenger/update" 
               modelAttribute="passenger" method="post">

        <form:hidden path="passengerId"/>

        Name: <form:input path="passengerName" required="true"/><br><br>
        Age: <form:input path="age" type="number" required="true"/><br><br>
        Gender: 
        <form:select path="gender">
            <form:option value="Male">Male</form:option>
            <form:option value="Female">Female</form:option>
            <form:option value="Other">Other</form:option>
        </form:select><br><br>
        Mobile: <form:input path="mobile" required="true"/><br><br>
        Email: <form:input path="email" type="email" required="true"/><br><br>
        Aadhaar: <form:input path="aadhaarNumber" required="true"/><br><br>
        Source Station: <form:input path="sourceStation" required="true"/><br><br>
        Destination Station: <form:input path="destinationStation" required="true"/><br><br>
        Journey Date: <form:input path="journeyDate" type="date" required="true"/><br><br>
        Seat Class: 
        <form:select path="seatClass">
            <form:option value="Sleeper">Sleeper</form:option>
            <form:option value="AC 3 Tier">AC 3 Tier</form:option>
            <form:option value="AC 2 Tier">AC 2 Tier</form:option>
            <form:option value="AC First">AC First</form:option>
        </form:select><br><br>
        Ticket Fare: <form:input path="ticketFare" type="number" step="0.01" required="true"/><br><br>

        <input type="submit" value="Update Passenger">
    </form:form>

    <br>
    <a href="${pageContext.request.contextPath}/passenger/list">Back to List</a> |
    <a href="${pageContext.request.contextPath}/">Home</a>
</body>
</html>