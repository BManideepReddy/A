<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Seller</title>
<link rel="stylesheet" type="text/css" href="/css/seller.css">
</head>
<body>
	<center>
		<div class="header">
			<div class="main">
				<h2>Seller</h2>
			</div>
			

			<div class="addproduct">
				<a class="btnprimary" href="/addproduct-service?user=${userName}">Add Product</a>
			</div>

			<div class="viewmyproduct">
				<a class="btnprimary" href="/myproducts">My Products</a>
			</div>


			<div class="viewproduct">
				<a class="btnprimary" href="/view-all-products">All
					Products</a>
			</div>

			<div class="productsearch">
				<a class="btnprimary" href="/product-search00">Products
					Search</a>
			</div>
			<div class="logout">
				<a  class="btnprimary" href="/seller-logout">Logout</a>
			</div>
		</div>

		<c:if test="${isAdded}">
			<h3>${AddedMessage}</h3>
		</c:if>

		<c:if test="${allProductListEmpty}">
			<h3>Empty</h3>
		</c:if>

		<c:if test="${isAddProductService}">
			<center>
				<h3>Add Product</h3>
				<table class="tb12">
					<form:form action="/addProduct-service" method="post"
						modelAttribute="productModel">
						<tr>
							<th><label>User : </label></th>
							<td><center><form:input class="input-group-text" path="SellerName"
									value="${userName}" readonly="true" /></center></td>

						</tr>

						<tr>
							<th></th>
							<td><form:errors path="sellerName" /></td>
						</tr>
						<tr>
							<th><label>Product Category </label></th>
							<td class="tabaddpro"><form:select path="proCategory">
									<form:option value="" label="Select" />
									<form:option value="Electronics" label="Electronics" />
									<form:option value="Clothing" label="Clothing" />
									<form:option value="Groceries" label="Groceries" />
								</form:select></td>
						</tr>
						<tr>
						</tr>
						<tr>
							<th><label>Product Type </label></th>
							<td class="tabaddpro"><form:select path="proType">
									<form:option value="" label="Select" />
									<form:option value="Mobile" label="Mobile" />
									<form:option value="Laptop" label="Laptop" />
									<form:option value="Television" label="Television" />
									<form:option value="Mens" label="Mens" />
									<form:option value="Ladies" label="Ladies" />
									<form:option value="Kids" label="Kids" />
									<form:option value="Fruits" label="Fruits" />
									<form:option value="Vegetables" label="Vegetables" />

								</form:select></td>
							<th></th>
							<td></td>
						</tr>


						<tr>
							<th><label>Product Name : </label></th>
							<td class="tabaddpro"><form:input path="ProName" /></td>

						</tr>
						<tr>
							<th></th>
							<td><form:errors path="ProName" /></td>
						</tr>
						<tr>
							<th><label>Product Price : </label></th>
							<td class="tabaddpro"><form:input path="ProPrice" /></td>
						</tr>
						<tr>
							<th></th>
							<td><form:errors path="ProPrice" /></td>
						</tr>

						<table>
							<tr>
								<th></th>
								<td><input type="submit" value="Add"></td>
							</tr>
						</table>
					</form:form>
				</table>
			</center>
		</c:if>
		<c:if test="${myProductsListEmpty }">
			<p>No Products</p>
		</c:if>
		<c:if test="${ismyProductsList}">
			<h2>My Products</h2>
			<table class="alltable1">
				<thead class="thead-light">
					<tr style="height: 50px">
						<th class="t51">Category</th>
						<th class="t51">Type</th>
						<th class="t51">Name</th>
						<th class="t51">Price</th>

					</tr>

				</thead>
				<tbody>
					<c:forEach items="${myProductsList}" var="productList">
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
		<c:if test="${isAllProductsList}">
			<h2>All Products</h2>
			<table class="alltable1">
				<thead class="thead-light">
					<tr style="height: 50px">
						<th class="t51">Category</th>
						<th class="t51">Type</th>
						<th class="t51">Product Name</th>
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
			<br>
			<table>
				<tr>
					<form:form action="/product-search11" method="post"
						modelAttribute="productModel">
						<th>Select Category:</th>
						<td class="tabsel"><form:select path="proCategory">
								<form:option value="" label="Select" />
								<form:option value="Electronics" label="Electronics" />
								<form:option value="Clothing" label="Clothing" />
								<form:option value="Groceries" label="Groceries" />
							</form:select></td>

						<td class="cthhd2"><input type="submit" value="Search"></td>

					</form:form>
				</tr>
			</table>


		</c:if>





		<c:if test="${isElectronics}">
			<p>Electronics</p>
			<table>
				<tr>
					<form:form action="/product-search22" method="post"
						modelAttribute="productModel">
						<th>Select Type:</th>
						<td class="tabsel"><form:select path="proType">
								<form:option value="" label="Select" />
								<form:option value="Mobile" label="Mobile" />
								<form:option value="Laptop" label="Laptop" />
								<form:option value="Television" label="Television" />
							</form:select></td>

						<td class="cthhd2"><input type="submit" value="Search"></td>

					</form:form>
				</tr>
			</table>


		</c:if>



		<c:if test="${isClothing}">
			<p>Clothing</p>
			<table>
				<tr>
					<form:form action="/product-search22" method="post"
						modelAttribute="productModel">
						<th>Select Type:</th>
						<td class="tabsel"><form:select path="proType">
								<form:option value="" label="Select" />
								<form:option value="Mens" label="Mens" />
								<form:option value="Ladies" label="Ladies" />
								<form:option value="Kids" label="Kids" />
							</form:select></td>

						<td class="cthhd2"><input type="submit" value="Search"></td>

					</form:form>
				</tr>
			</table>


		</c:if>




		<c:if test="${isGroceries}">
			<p>Groceries</p>
			<table>
				<tr>
					<form:form action="/product-search22" method="post"
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
			<h2>Products</h2>
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
					<c:forEach items="${searchProductsList}" var="productList">
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
	</center>
	</div>
</body>
</html>