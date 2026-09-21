<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.*" %>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Books</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container" style="width: 90%; max-width: 1000px;">
        <h2>All Books</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Type</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <% if (books != null && !books.isEmpty()) {
                for (Book b : books) { %>
            <tr>
                <td><%= b.getId() %></td>
                <td><%= b.getTitle() %></td>
                <td><%= b.getAuthor() %></td>
                <td><%= (b instanceof PrintedBook) ? "Printed" : "EBook" %></td>
                <td>₹<%= b.getPrice() %></td>
                <td>
                    <a href="DeleteBookServlet?id=<%= b.getId() %>" 
                       onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
            <% } } else { %>
            <tr>
                <td colspan="6" style="text-align:center;">No books found</td>
            </tr>
            <% } %>
        </table>
        <br>
        <a href="dashboard.jsp" class="btn">Back to Dashboard</a>
        <a href="addBook.jsp" class="btn">Add New Book</a>
    </div>
</body>
</html>