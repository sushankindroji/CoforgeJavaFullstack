<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.coforge.training.empsoft.dao.EmployeeDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>

	<jsp:useBean id="emp"
		class="com.coforge.training.empsoft.model.Employee"></jsp:useBean>
	<jsp:setProperty property="*" name="emp" />

	<%
	int i = EmployeeDAO.save(emp);
	if (i > 0) {
		response.sendRedirect("AddUserSuccess.jsp");
	} else {
		response.sendRedirect("AddUserError.jsp");
	}
	%>
</body>
</html>