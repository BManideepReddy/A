<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/customer.css">
</head>
<body>
	<center>
		<div class="header">
			<div class="main">
				<h2>Customer</h2>
			</div>

			<div class="viewproduct">
				<a class="btn" href="/view-all-productss">All
					Products</a>
			</div>

			<div class="productsearch">
				<a class="btn" href="/product-search">Products
					Search</a>
			</div>
			<div class="logout">
				<a class="btn" href="/customer-logout">Logout</a>
			</div>
		</div>


		<c:if test="${allProductListEmpty}">
			<h3>Empty</h3>
		</c:if>


		<c:if test="${isAllProductsList}">
			<h2>All Products</h2>
			<table class="alltable1">
				<thead class="thead-light">
					<tr style="height: 50px">
						<th class="t51">Category</th>
						<th class="t51">Type</th>
						<th class="t51">Name</th>
						<th class="t51">Price</th>
						<th class="t51">Seller</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allProductsList}" var="productList">
						<tr>
							<td class="td51">${productList.proCategory}</td>
							<td class="td51">${productList.proType}</td>
							<td class="td51">${productList.proName}</td>
							<td class="td51">${productList.proPrice}</td>
							<td class="td51">${productList.sellerName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>


		<c:if test="${productsearch}">
			<table class="prosearchtab">
				<tr>
					<form:form action="/product-search1" method="post"
						modelAttribute="productModel">
						<th>Select Category:</th>
						<td class="tabsel"><form:select path="proCategory">
								<form:option value="" label="Select" />
								<form:option value="Electronics" label="Electronics" />
								<form:option value="Clothing" label="Clothing" />
								<form:option value="Groceries" label="Groceries" />
							</form:select></td>

						<td><input type="submit" value="Search"></td>

					</form:form>
				</tr>
			</table>
		</c:if>

		<c:if test="${isElectronics}">
			<p>Electronics</p>
			<table>
				<tr>
					<form:form action="/product-search2" method="post"
						modelAttribute="productModel">
						<th>Select Type:</th>
						<td class="tabsel"><form:select path="proType">
								<form:option value="" label="Select" />
								<form:option value="Mobile" label="Mobile" />
								<form:option value="Laptop" label="Laptop" />
								<form:option value="Television" label="Television" />
							</form:select></td>

						<td><input type="submit" value="Search"></td>

					</form:form>
				</tr>
			</table>
		</c:if>



		<c:if test="${isClothing}">
			<p>Clothing</p>
			<table>
				<tr>
					<form:form action="/product-search2" method="post"
						modelAttribute="productModel">
						<th>Select Type:</th>
						<td class="tabsel"><form:select path="proType">
								<form:option value="" label="Select" />
								<form:option value="Mens" label="Mens" />
								<form:option value="Ladies" label="Ladies" />
								<form:option value="Kids" label="Kids" />
							</form:select></td>

						<td><input type="submit" value="Search"></td>

					</form:form>
				</tr>
			</table>
		</c:if>

		<c:if test="${isGroceries}">
			<h3>Groceries</h3>
			<table>
				<tr>
					<form:form action="/product-search2" method="post"
						modelAttribute="productModel">
						<th>Select Type:</th>
						<td class="tabsel"><form:select path="proType">
								<form:option value="" label="Select" />
								<form:option value="Fruits" label="Fruits" />
								<form:option value="Vegetables" label="Vegetables" />
							</form:select></td>

						<td class="cthhd2"><input type="submit" value="Search"></td>

					</form:form>
				</tr>
			</table>


		</c:if>

		<c:if test="${searchListempty}">
			<h3>Empty</h3>
		</c:if>


		<c:if test="${searchList}">
			<h3>All Products</h3>
			<table class="alltable1">
				<thead class="thead-light">
					<tr style="height: 50px">
						<th class="t51">Address</th>
						<th class="t51">Assigned Cleaner</th>
						<th class="t51">Pay Status</th>
						<th class="t51">Cleaning Status</th>

					</tr>

				</thead>
				<tbody>
					<c:forEach items="${searchProductsList}" var="productList">
						<tr>
							<td class="td51">${productList.proCategory}</td>
							<td class="td51">${productList.proType}</td>
							<td class="td51">${productList.proName}</td>
							<td class="td51">${productList.proPrice}</td>


						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>


		</div>

	</center>
</body>
</html>