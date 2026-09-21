<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>


<link rel="stylesheet" href="styles/session.css">
</head>
<body>
	
<%@ include file="header.jsp" %>
<%
HttpSession session1 = request.getSession(false);

if(session1 == null || session1.getAttribute("username") == null)
{
    response.sendRedirect("sessionlogin.html?msg=expired");
    return;
}

String user = (String)session1.getAttribute("username");
%>

	<div class="container">

		<h2>
			Welcome <%=user%></h2>

		<p>
			<b>Session ID :</b>
			<%=session1.getId()%></p>

		<p>
			<b>Session Created :</b>
			<%=new java.util.Date(session1.getCreationTime())%></p>

		<p>
			<b>Last Access :</b>
			<%=new java.util.Date(session1.getLastAccessedTime())%></p>

		<p>
			<b>Max Inactive Interval :</b>
			<%=session1.getMaxInactiveInterval()%>
			Seconds
		</p>

		<br> <a href="sessiondemo.jsp">
			<button>Session Attributes</button>
		</a>
		

	</div>

	<%@ include file="footer.jsp" %>
	
</body>
</html>