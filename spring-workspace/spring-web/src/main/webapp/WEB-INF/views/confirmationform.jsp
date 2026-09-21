<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>

<style>
/* General container */
.reservation-card {
  max-width: 600px;
  margin: 40px auto;
  padding: 25px 30px;
  background: #ffffff;
  border-radius: 12px;
  box-shadow: 0 6px 18px rgba(0, 0, 0, 0.1);
  font-family: "Segoe UI", Roboto, sans-serif;
  color: #333;
  line-height: 1.6;
}

/* Heading */
.reservation-card h3 {
  color: #2e7d32; /* green tone for success */
  font-size: 1.6rem;
  margin-bottom: 10px;
  text-align: center;
}

/* Subtext */
.reservation-card p {
  font-size: 1rem;
  color: #555;
  margin-bottom: 20px;
  text-align: center;
}

/* Labels and values */
.reservation-card .detail {
  margin-bottom: 12px;
  font-size: 1rem;
}

.reservation-card .detail strong {
  color: #444;
  display: inline-block;
  width: 120px;
}

/* Meals list */
.reservation-card ul {
  list-style: none;
  padding: 0;
  margin: 8px 0 20px 0;
}

.reservation-card ul li {
  background: #f1f8e9;
  color: #33691e;
  padding: 6px 10px;
  margin-bottom: 6px;
  border-radius: 6px;
  font-size: 0.95rem;
}

/* Footer info */
.reservation-card .route {
  margin-top: 15px;
  font-size: 1rem;
}

.reservation-card .route span {
  font-weight: bold;
  color: #1976d2;
}

</style>
</head>
<body>
	

<div class="reservation-card">
  <h3>Your reservation is confirmed successfully.</h3>
  <p>Please, re-check the details.</p>

  <div class="detail"><strong>First Name:</strong> ${reserve1.firstName}</div>
  <div class="detail"><strong>Last Name:</strong> ${reserve1.lastName}</div>
  <div class="detail"><strong>Gender:</strong> ${reserve1.gender}</div>

  <div class="detail"><strong>Meals:</strong></div>
  <ul>
    <c:forEach var="meal" items="${reserve1.food}">
      <li>${meal}</li>
    </c:forEach>
  </ul>

  <div class="route">
    <span>Leaving From:</span> ${reserve1.cityFrom} <br>
    <span>Going To:</span> ${reserve1.cityTo}
  </div>
</div>
	
</body>
</html>