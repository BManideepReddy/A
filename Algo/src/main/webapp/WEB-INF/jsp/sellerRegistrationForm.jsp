<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seller Registration</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/sellerReg.css">
</head>
<body>
<center>
	<h2>Seller Registration Form</h2>
	<hr>
	<form:form action="/seller-register" method="post" modelAttribute="sellerRegistration">
		<table class="table1">
			<tr>
				<th class="th1"><label>First Name : </label></th>
				<td><form:input path="firstName" placeholder="First Name" /></td>
				<td><form:errors path="firstName"/></td>
			</tr>
			<tr>
				<th class="th1"><label>Last Name : </label></th>
				<td><form:input path="lastName" placeholder="Last Name" /></td>
				<td><form:errors path="lastName"/></td>
			</tr>
			<tr>
				<th  class="th1"><label>Date of Birth : </label></th>
				<td><form:input type="date" path="dob" /></td>
				<td><form:errors path="dob"></form:errors></td>
			</tr>
			<tr>
				<th class="th1"><label>Gender : </label></th>
				<td><form:radiobutton path="gender" value="Male" /> Male 
				<form:radiobutton path="gender" value="Female" /> Female</td>
				<td><form:errors path="gender"/></td>
			</tr>
			<tr>
				<th class="th1"><label>Phone Number : </label></th>
				<td><form:input type="text" path="phoneNumber"  /></td>
				<td><form:errors path="phoneNumber"></form:errors></td>
			</tr>
			<tr>
				<th class="th1"><label>Email ID : </label></th>
				<td><form:input type="email" path="emailId" /></td>
				<td><form:errors path="emailId"></form:errors></td>
			</tr>
			
			<tr>
				<th class="th1"><label>User ID :</label></th>
				<td><form:input path="sellerId" placeholder="Seller Id" /></td>
				<td><form:errors path="sellerId"></form:errors></td>
			</tr>
			<tr>
				<th class="th1"><label>Password : </label></th>
				<td><form:password path="password" placeholder="password" /></td>
				<td><form:errors path="password"/></td>
			</tr>
			<tr>
				<th class="th1"><label>Confirm Password : </label></th>
				<td><form:password path="verifypassword" placeholder="Re-Enter password"/></td>
				<td><form:errors path="verifypassword"/></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" value="Register"> &nbsp; &nbsp; <a class="logbutton" href="/seller-login">Login here</a></td>
			</tr>
			
		</table>
	</form:form>
	
</center>

</body>
</html>