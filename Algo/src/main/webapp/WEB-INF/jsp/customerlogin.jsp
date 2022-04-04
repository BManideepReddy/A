<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login</title>
</head>
<body>
<center>
	<h2>
		<center>Customer Login Form</center>
	</h2>
	<hr>
	<div class="Loginform">
		<c:if test="${isCustomerCreated}">
			<p>${customerCreatedMessage}</p>
		</c:if>

		<form:form action="/customer-login-validate" method="post"
			modelAttribute="loginModel">
			<table align="center">
			<br>
				<tr>
					<th><label>Customer Id : </label></th>
					<td><form:input path="userId" placeholder="Enter customer ID" /></td>
				</tr>
				<tr>
					<th><label>Password:</label></th>
					<td><form:password path="password"
							placeholder="Enter password" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Login"> &nbsp;  &nbsp; <a href="/customer-register">Register Here</a></td>
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
