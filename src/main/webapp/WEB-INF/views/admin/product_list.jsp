<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<%@ include file="admin_header.jsp"%>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/adminlist.css">
 --%>
<head>
<meta charset="ISO-8859-1">
	<!-- <style>/* General Reset */
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    background-color: #f9f9f9;
    color: #333;
}

h1 {
    text-align: center;
    margin: 20px 0;
    font-size: 2em;
    color: #444;
}

/* Header */
header {
    background-color: #333;
    color: white;
    padding: 10px 20px;
    text-align: center;
}

header a {
    color: white;
    text-decoration: none;
    margin: 0 15px;
}

header a:hover {
    text-decoration: underline;
}

/* Table Styling */
.table-container {
    margin: 20px auto;
    padding: 10px;
    max-width: 90%;
    background: white;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

table {
    width: 100%;
    border-collapse: collapse;
    margin: 0 auto;
    overflow-x: auto;
}

table, th, td {
    border: 1px solid #ddd;
}

th, td {
    padding: 12px 15px;
    text-align: left;
}

th {
    background-color: #f4f4f4;
    color: #555;
    font-weight: bold;
}

td img {
    max-width: 100px;
    height: auto;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

/* Row Hover Effect */
tr:hover {
    background-color: #f9f9f9;
}

/* Responsive Design */
@media (max-width: 768px) {
    .table-container {
        padding: 5px;
    }

    table {
        font-size: 14px;
    }

    th, td {
        padding: 8px;
    }

    td img {
        max-width: 75px;
    }
}

/* Button Styles */
button {
    display: block;
    margin: 20px auto;
    padding: 10px 20px;
    font-size: 16px;
    color: white;
    background-color: #007bff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #0056b3;
}

/* Alerts or Messages */
.alert {
    text-align: center;
    font-size: 1.2em;
    color: #555;
    margin-top: 20px;
}
	
	</style> -->
<title>Product Details</title>
<link rel="stylesheet" type="text/css" href="/assets/css/adminlist.css">
</head>
<body>
	<br>
	<br>
	<br>
	<h1>Products List</h1>
	<br>
	<br>
	<form action="update_status" method="post"
		enctype="multipart/form-data">
		<table>

			<tr>
				<th>Product ID</th>
				<th>Product</th>
				<th>Product Type</th>
				<th>Product Status</th>
				<th>Change Status</th>
			</tr>

			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.id}</td>
					<td><img
						src="${product.img_org}" width="100"></td>
					<td>${product.type}</td>
					<td><input type="checkbox" name="status" value="${product.id}" />
					</td>

				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<button type="submit">Submit</button>
	</form>

</body>
</html>