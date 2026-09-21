<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* General Reset */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
}

/* Body Styling */
body {
  background: linear-gradient(135deg, #f0f4f8, #d9e2ec);
  color: #333;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
}

/* Header Include Styling */
header {
  width: 100%;
  background: #1e3a8a;
  color: #fff;
  padding: 15px 30px;
  text-align: center;
  font-size: 1.2rem;
  font-weight: 600;
  letter-spacing: 0.5px;
  box-shadow: 0 2px 6px rgba(0,0,0,0.15);
}

/* Dashboard Container */
.dashboard {
  margin-top: 40px;
  background: #fff;
  padding: 40px;
  border-radius: 12px;
  box-shadow: 0 6px 18px rgba(0,0,0,0.1);
  width: 80%;
  max-width: 900px;
  text-align: center;
  animation: fadeIn 0.8s ease-in-out;
}

/* Headings */
.dashboard h1 {
  font-size: 2rem;
  color: #1e3a8a;
  margin-bottom: 15px;
}

.dashboard h2 {
  font-size: 1.4rem;
  color: #374151;
  margin-bottom: 25px;
}

/* Welcome Email Highlight */
.dashboard h2 span {
  color: #2563eb;
  font-weight: bold;
}

/* Buttons (future dashboard actions) */
.btn {
  display: inline-block;
  padding: 12px 20px;
  margin: 10px;
  border-radius: 8px;
  background: #2563eb;
  color: #fff;
  text-decoration: none;
  font-weight: 500;
  transition: background 0.3s ease, transform 0.2s ease;
}

.btn:hover {
  background: #1e40af;
  transform: translateY(-2px);
}

/* Animation */
@keyframes fadeIn {
  from { opacity: 0; transform: translateY(20px); }
  to { opacity: 1; transform: translateY(0); }
}

/* Responsive */
@media (max-width: 600px) {
  .dashboard {
    width: 95%;
    padding: 20px;
  }

  .dashboard h1 {
    font-size: 1.6rem;
  }

  .dashboard h2 {
    font-size: 1.2rem;
  }
}

</style>
</head>
<body>
<jsp:include page="header.jsp" />
<% String email= (String) session.getAttribute("email"); 
   if (email == null) { response.sendRedirect("login.jsp"); return; } %>

<div class="dashboard">
  <h1>Welcome to the Student Dashboard</h1>
  <h2>Welcome, <span><%= email %></span>!</h2>
  <a href="StudentList.jsp" class="btn">View Students</a>
  <a href="logout.jsp" class="btn">Logout</a>
</div>

</body>
</html>