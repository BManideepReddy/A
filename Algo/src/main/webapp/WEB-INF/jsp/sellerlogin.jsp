<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<title>seller Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/sellerReg.css">
</head>
<body>
<center>
	<h1><center>Seller Login Form</center></h1>
	<hr>
	<div class="Loginform">
		<c:if test="${isSellerCreated}">
			<p>${sellerCreatedMessage}</p>
		</c:if>

		<form:form action="/seller-login-validate" method="post"
			modelAttribute="loginModel">
			<table class="SellerLoginTable" align="center" >
				<tr>
					<th class="th1"><label>Customer Id : </label></th>
					<td><form:input path="userId"
							placeholder="Enter Seller Id" /></td>
				</tr>
				
				<tr>
					<th class="th1"><label>Password : </label></th>
					<td><form:password path="password"
							placeholder="Enter password" /></td>
				</tr>
				<tr>
					<th class="th1"></th>
					<td><input type="submit" value="Login"> &nbsp;&nbsp; <a class="logbutton" href="/seller-register">Register Here</a></td>
				</tr>
				
			</table>
		</form:form>
		
		<c:if test="${inValidUser}">
		<p style="color: red;">${userName}${invalidUser}</p>
	</c:if>
	</div>
	</center>
</body>
</html>
