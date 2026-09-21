<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.List,
    com.cofrge.training.hibernateweb.dao.UserDAO,
    com.cofrge.training.hibernateweb.model.User" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users Skills List</title>
    <link rel="stylesheet" type="text/css" href="styles/skills1.css">
</head>
<body>
    
    <%
    UserDAO dao = new UserDAO();
    List<User> users = dao.getAll();
%>
<jsp:include page="header.jsp" />
<h1>User List</h1>
<table style="width:80%; margin:auto; border-collapse: collapse;" border="1">
    <tr><th>ID</th><th>Name</th><th>Skills</th></tr>
    <% for(User u : users) { %>
    <tr>
        <td><%= u.getId() %></td>
        <td><%= u.getName() %></td>
        <td><%= (u.getSkills() != null && !u.getSkills().isEmpty()) 
                    ? String.join(", ", u.getSkills()) 
                    : "No Skills" %>
         </td>
    </tr>
    <% } %>
</table>
<a href="skills.html">Add Another User Skills</a>

</body>
</html>