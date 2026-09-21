<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: auto;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        </style>
<body>
	<jsp:include page="header.jsp" />
		<h1>Login using Hibernate</h1>
		
		<%
			String error=(String)session.getAttribute("error");
		if (error!=null){
		%>
		<p style="color:red;font-style:bold"><%=error %></p>
		<%
			session.removeAttribute("error");}
		%>
		
		<form action="login" method="post">
			<label for="email">Email:</label>
			<input type="text" id="email" name="email" required><br><br>
			<label for="password">Password:</label>
			<input type="password" id="password" name="password" required><br><br>
			<input type="submit" value="Login">
		</form>
</body>
</html>
