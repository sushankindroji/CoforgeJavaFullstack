<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/mystyles.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">

		<h2>Customer Registered Successfully</h2>

		<table>

			<tr>
				<th>Customer ID</th>
				<td><%=request.getAttribute("id")%></td>
			</tr>

			<tr>
				<th>Customer Name</th>
				<td><%=request.getAttribute("name")%></td>
			</tr>

			<tr>
				<th>Email</th>
				<td><%=request.getAttribute("email")%></td>
			</tr>

			<tr>
				<th>Mobile</th>
				<td><%=request.getAttribute("mobile")%></td>
			</tr>

			<tr>
				<th>City</th>
				<td><%=request.getAttribute("city")%></td>
			</tr>

			<tr>
				<th>Interested Categories</th>
				<td><%=request.getAttribute("categories")%></td>
			</tr>

			<tr>
				<th>Interested Categories</th>
				<td><%=request.getAttribute("rdate")%></td>
			</tr>

		</table>

		<br> <a href="register.html">
			<button>Register Another Customer</button>
		</a>
		
		<br> <a href="index.html">
			<button>Home Page</button>
		</a>




	</div>

	<%@ include file="footer.jsp"%>

</body>
</html>