<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image:url('<c:url value="/resources/images/back2.jpg"/>');
             background-size:cover;
             background-repeat:no-repeat;
             background-position:center;">
	<div align="center" style="color:white;">
    <h1>expression language is used to access attribute in jsp</h1>

    <h1>Welcome to ${user} user page</h1>

    <p>Page saved on ${d}</p>

    <a href="spring">Click here for one more view</a>
</div>
</body>
</html>