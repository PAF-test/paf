<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
				<a href="" class="navbar-brand"> Product Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listp"
					class="nav-link">Products</a></li>
			</ul>
		</nav>
	</header>
	<br><br><br><br><br><br><br><br><br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${product != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${product == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${product != null}">
            			Edit Product
            		</c:if>
						<c:if test="${product == null}">
            			Add New Product
            		</c:if>
					</h2>
				</caption>

				<c:if test="${product != null}">
					<input type="hidden" name="pid" value="<c:out value='${product.pid}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Product Name</label> <input type="text"
						value="<c:out value='${product.pname}' />" class="form-control"
						name="pname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Product Discription</label> <input type="text"
						value="<c:out value='${product.discription}' />" class="form-control"
						name="discription">
				</fieldset>

				<fieldset class="form-group">
					<label>Product Price</label> <input type="text"
						value="<c:out value='${discription.price}' />" class="form-control"
						name="price">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>




</body>
</html>