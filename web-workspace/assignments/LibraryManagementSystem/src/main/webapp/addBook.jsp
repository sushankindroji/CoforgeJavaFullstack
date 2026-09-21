<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
    <link rel="stylesheet" href="css/style.css">
    <script>
        function showFields() {
            var type = document.getElementById("bookType").value;
            document.getElementById("printedFields").style.display = (type === "Printed") ? "block" : "none";
            document.getElementById("ebookFields").style.display = (type === "EBook") ? "block" : "none";
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>Add New Book</h2>
        <form action="AddBookServlet" method="post">
            <select name="bookType" id="bookType" onchange="showFields()" required>
                <option value="">-- Select Book Type --</option>
                <option value="Printed">Printed Book</option>
                <option value="EBook">E-Book</option>
            </select>

            <input type="text" name="title" placeholder="Title" required>
            <input type="text" name="author" placeholder="Author" required>
            <input type="text" name="publisher" placeholder="Publisher">
            <input type="text" name="isbn" placeholder="ISBN">
            <input type="number" step="0.01" name="price" placeholder="Price" required>
            <input type="text" name="category" placeholder="Category">

            <div id="printedFields" style="display:none;">
                <input type="number" name="pages" placeholder="Number of Pages">
                <input type="text" name="shelfNo" placeholder="Shelf Number">
                <input type="text" name="edition" placeholder="Edition">
            </div>

            <div id="ebookFields" style="display:none;">
                <input type="text" name="fileFormat" placeholder="File Format (PDF/EPUB)">
                <input type="number" step="0.1" name="fileSize" placeholder="File Size (MB)">
                <input type="text" name="downloadLink" placeholder="Download Link">
            </div>

            <button type="submit">Save Book</button>
        </form>
        <br>
        <a href="dashboard.jsp" class="btn">Back to Dashboard</a>
    </div>
</body>
</html>