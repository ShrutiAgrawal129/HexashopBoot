<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<%@ include file="admin_header.jsp"%>

<head>
<meta charset="ISO-8859-1">
<title>Order List</title>
<link rel="stylesheet" type="text/css" href="/assets/css/adminlist.css">

</head>
<body>
<%-- <h1>${sessionScope.pid}</h1>
<h2>${sessionScope.sname}</h2>
<h2>${sessionScope.date}</h2> --%>

	<br>
	<br>
	<br>
	<h1>Order List</h1>
	<br>
	<br>
	<!-- <form action="accpet_order" method="post"
		enctype="multipart/form-data"> -->
		<table border="1">
		    <tr>
		        <th>User</th>
		        <th>Order Date</th>
		        <th>Total Price</th>
		        <th>Products</th>
		    </tr>
		    <c:forEach var="order" items="${orders}">
		        <tr>
		            <td>${order.user_name}</td>
		            <td>${order.order_date}</td>
		            <td>Rs. ${order.total_price}</td>
		            <td>
		                <c:forEach var="product" items="${order.productIds}">
		                    Product ID: ${product} <br>
		                </c:forEach>
		            </td>
		        </tr>
		    </c:forEach>
		</table>

		<br>
		<br>
		
	<!-- </form> -->

	
</body>
</html>