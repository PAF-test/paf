<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator Login</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	>
</head>


<style>
.submit {
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

.textview {
  background-color: white;
  border: none;
  color: black;
  padding: 16px 32px;
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


</style>





<body style="background-color:grey;">

<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="http://localhost:8080/Admin_pro/" class="navbar-brand"> Administrator Login</a>
			</div>
			</nav>

<br><br><br><br><br><br><br><br>
<header>


			<br>
</header>
<div align ="center">
<h1>Administrator Login</h1>

<br><br>
<form action ="login" method="post">
<table>

<tr><td >User Name: </td><td><input type="text" class="textview" name="username"></td></tr>

<tr><td >Password: </td><td><input type="password" class="textview" name="password"></td></tr>

<tr><td></td><td><input type="submit" value="Submit" class="submit" ></td></tr>
</table>


</form>

</div>



</body>
</html>