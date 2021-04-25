<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Product Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	>
</head>
<body style="background-color:grey;">

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="" class="navbar-brand"> Product
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a a href="<%=request.getContextPath()%>/listp"
					class="nav-link">Products</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Products</h3>
			<hr>
			<div class="container text-left">

				<a href="http://localhost:8088/Admin_pro/productform.jsp" class="btn btn-success">Add
					New Product</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>PID</th>
						<th>Product Name</th>
						<th>Product Discription</th>
						<th>Product Price</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="product" items="${listProduct}">

						<tr>
							<td><c:out value="${product.pid}" /></td>
							<td><c:out value="${product.pname}" /></td>
							<td><c:out value="${product.discription}" /></td>
							<td><c:out value="${product.price}" /></td>
							<td><a href="edit?id=<c:out value='${product.pid}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${product.pid}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>