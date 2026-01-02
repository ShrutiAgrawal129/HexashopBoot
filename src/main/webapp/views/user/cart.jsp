<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@ include file="user_header.jsp"%>
<head>

<meta charset="ISO-8859-1">
<title>User Profile</title>
<link rel="stylesheet" type="text/css" href="/assets/css/adminlist.css">
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<form action="orderPage" method="post" enctype="multipart/form-data">
		<c:if test="${cartEmpty}">
			<h2>Your cart is empty!</h2>
			<a href="/user/user_index">Continue Shopping</a>
			<!-- optional button -->
		</c:if>

		<c:if test="${not cartEmpty}">
			<table>
				<tr>
					<th>Product</th>
					<th>Product Description</th>
					<th>Product Price</th>
					<th>Product Quantity</th>
				</tr>

				<c:forEach var="product" items="${products}">
					<tr>
						<td><img
							src="${pageContext.request.contextPath}/assets/images/${product.img_org}"
							alt="Product Image" style="width: 100px; height: 100px; object-fit: cover;"></td>
						<td>${product.description}</td>
						<td>Rs. ${product.price}</td>
						<td><input type="hidden" name="productIds"
							value="${product.id}"> <select name="quantities" required>
								<c:forEach var="i" begin="1" end="${product.qty}">
									<option value="${i}">${i}</option>
								</c:forEach>
						</select></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<br>
			<div style="text-align: center;">
				<input type="submit" name="placeOrder" value="Place Order">
			</div>
		</c:if>
	</form>
</body>
</html>
