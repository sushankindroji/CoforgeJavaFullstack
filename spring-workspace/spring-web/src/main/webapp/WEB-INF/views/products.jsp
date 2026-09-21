<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products List</title>




<style>
/* Google Font */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap');

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

body{
    background:linear-gradient(135deg,#1d3557,#457b9d,#a8dadc);
    min-height:100vh;
    padding:40px;
}

/* Heading */

.title{
    text-align:center;
    color:white;
    font-size:40px;
    margin-bottom:35px;
    letter-spacing:2px;
    text-shadow:3px 3px 10px rgba(0,0,0,.4);
}

/* Table */

.productTable{
    width:95%;
    margin:auto;
    border-collapse:collapse;
    background:rgba(255,255,255,.92);
    border-radius:18px;
    overflow:hidden;
    box-shadow:0 15px 35px rgba(0,0,0,.35);
}

/* Header */

.productTable th{
    background:linear-gradient(90deg,#0f4c81,#0077b6);
    color:white;
    padding:18px;
    font-size:18px;
    text-transform:uppercase;
    letter-spacing:1px;
}

/* Cells */

.productTable td{
    padding:15px;
    text-align:center;
    font-size:16px;
    color:#333;
    transition:.3s;
}

/* Alternate Rows */

.productTable tr:nth-child(even){
    background:#f8f9fa;
}

/* Hover */

.productTable tr:hover{
    background:#d7f3ff;
    transform:scale(1.01);
    transition:.3s;
}

/* Border */

.productTable td,
.productTable th{
    border-bottom:1px solid #ddd;
}

/* Price */

.productTable td:nth-child(5){
    color:#0b8457;
    font-weight:bold;
}

/* Stock */

.productTable td:last-child{
    font-weight:bold;
    color:#d62828;
}

/* Rounded Header */

.productTable th:first-child{
    border-top-left-radius:18px;
}

.productTable th:last-child{
    border-top-right-radius:18px;
}

</style>

</head>
<body>
	
	<h2 class="title">Products List - ClassicMoodels Database using SpringORM - Hibernate</h2>

	<table class="productTable">

		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Line</th>
			<th>Vendor</th>
			<th>Price</th>
			<th>Stock</th>
		</tr>

		<c:forEach items="${productsList}" var="p">

			<tr>

				<td>${p.productCode}</td>
				<td>${p.productName}</td>
				<td>${p.productLine}</td>
				<td>${p.productVendor}</td>
				<td>₹ ${p.buyPrice}</td>
				<td>${p.quantityInStock}</td>

			</tr>

		</c:forEach>

	</table>
	
	
</body>
</html>