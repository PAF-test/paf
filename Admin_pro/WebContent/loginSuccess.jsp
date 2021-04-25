<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator Managements</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	>
	
</head>
<header>

<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="http://localhost:8080/Admin_pro/" class="navbar-brand"> Administrator Login</a>
			</div>
			</nav>
			<br>
</header>

<style>
.button {
  background-color: #002424;
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;
  opacity: 0.6;
  transition: 0.3s;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
  width: 400px;
  height:50px;
}

.button:hover {opacity: 1}
</style>



<body style="background-color:grey;">


	<div align ="center">
	<h1 >Welcome</h1>
	
	<br><br><br>
	</div>
<center>	
	<button onclick="document.location='http://localhost:8088/Admin_pro/list'" class="button">User Management</button><br><br>
	<button onclick="document.location='http://localhost:8088/Admin_pro/listp'" class="button">Reserchers Management</button><br><br>
	<button onclick="document.location='http://localhost:8088/Admin_pro/listproduct.jsp'" class="button">Product Management</button>
	
</center>
</body>


</html>