<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/session.css">
</head>
<body>
<%@ include file="header.jsp" %>
	<%
		HttpSession session1 = request.getSession(false);

	if (session1 == null) {
		response.sendRedirect("sessionlogin.html");
		return;
	}

	String user = (String) session1.getAttribute("username");
	String college = (String) session1.getAttribute("college");
	%>

	<div class="container">	
        <h1 style="color: crimson;">Session Attributes</h1>
	
		<h2>Welcome <%=user%></h2>
		<h2>Institute <%=college%></h2>
		
		<br> <a href="logout1">
			<button>Logout</button>
		</a>
        
    </div>
    <%@ include file="footer.jsp" %>


</body>
</html>