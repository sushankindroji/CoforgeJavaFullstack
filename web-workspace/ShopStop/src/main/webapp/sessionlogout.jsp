<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SessionLogout</title>
<link rel="stylesheet" href="styles/session.css">
</head>
<body>
	<%@ include file="header.jsp" %>

	<div class="container">

		<h2 style="color: red;">You have successfully logged out.</h2>
		
		<! -- Access Application scope Attributes using servlet Context -->
		<% 
			String appName=(String) getServletContext().getAttribute("app");
		%>
		
		 <h2>Thank You for Using : <%=appName%></h2>
		

		<br> <a href="sessionlogin.html">
			<button>Login Again</button>
		</a>

	</div>

	<%@ include file="footer.jsp" %>
</body>
</html>