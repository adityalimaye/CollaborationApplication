<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<!-- Bootstrap -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/jquery-3.1.1.min.js"></script>

<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<link href="<c:url value="/resources/css/sty1.css" />" rel="stylesheet">

<title>Add Product</title>

</head>

<body>
	<div class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="FlyAroundTheGlobe">Fly Around The Globe</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="Home">HOME</a></li>
			<li><a href="AddProduct">ADD PRODUCT</a></li>
			<li><a href="AddCategory">ADD CATEGORY</a></li>
			<li><a href="AddSupplier">ADD TRAVEL AGENT'S DETAILS</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="AddUser"><span class="glyphicon glyphicon-user"></span>SIGN UP </a></li>
			<c:url value="j_spring_security_logout" var="logoutUrl" />
			<li><a href="logout?${logoutUrl}"><span class="glyphicon glyphicon-user"></span> LOGOUT </a></li>
		</ul>
	</div>
	</div>

	<div align="center" style="color: #404040; font-size: 30px">PRODUCT DETAILS</div>
	<div align="center" class="container fluid">
		<form:form action="saveproduct" method="post" modelAttribute="productMall" enctype="multipart/form-data">
			<table>
				<tr>
					<c:choose>
						<c:when test="${!empty productMallEdit.id}">
							<td><form:label path="id"> Id </form:label></td>
							<td><form:input path="id" readonly="true" /></td>
						</c:when>
					</c:choose>
				</tr>

				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" value="${productMallEdit.name}" required="true" /></td>
				</tr>

				<tr>
					<td><form:label path="description">Description</form:label></td>
					<td><form:input path="description" value="${productMallEdit.description}" required="true" /></td>
				</tr>

				<tr>
					<td><form:label path="price">Price</form:label></td>
					<td><form:input path="price" value="${productMallEdit.price}" required="true" /></td>
				</tr>

				<tr>
					<td><form:label path="categoryMall.id">Category Name</form:label></td>
					<td><form:select path="categoryMall.id" value="${productMallEdit.categoryMall.id}" required="true">
							<option value="-1">Choose a category...</option>
							<c:forEach items="${categoryMallList}" var="categoryMall">
								<option value="${categoryMall.id}">${categoryMall.cat_name}</option>
							</c:forEach>
						</form:select></td>

				</tr>

				<tr>
					<td><form:label path="supplierMall.id">Supplier Name</form:label></td>
					<td><form:select path="supplierMall.id" value="${productMallEdit.supplierMall.id}" required="true">
							<option value="-1">Choose a supplier...</option>
							<c:forEach items="${supplierMallList}" var="supplierMall">
								<option value="${supplierMall.id}">${supplierMall.supp_name}</option>
							</c:forEach>
						</form:select></td>

				</tr>

				<tr>
					<td><form:label for="fileData" path="fileData">PICK A FILE :</form:label></td>
					<td><form:input path="fileData" id="image" type="file" name="filea" /></td>
				</tr>

				<c:choose>
					<c:when test="${!empty productMallEdit.id}">
						<tr>
							<td colspan="2"><button type="submit" value="UpdateProduct">UPDATE</button></td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="2"><button type="submit" value="Submit">SUBMIT</button> <button type="button" class="resetbtn" value="Reset" onClick="this.form.reset()">RESET</button></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</form:form>
	</div>
	<br>


	<div align="center" style="color: #404040; font-size: 30px">VIEW PRODUCT DETAILS</div>
	<div align="center" class="container-fluid">
		<c:if test="${!empty productMallList}">

				<table class="table table-responsive table-stripped table-hover" cellspacing="0" width="60%">
					<thead>
						<tr style="background-color: #595959; color: #FAEBD7; text-align: center;" height="40px">
							<td>ID</td>
							<td>NAME</td>
							<td>DESCRIPTION</td>
							<td>PRICE</td>
							<td>CATEGORY NAME</td>
							<td>SUPPLIER NAME</td>
							<td>IMAGE PATH</td>
							<td>EDIT</td>
							<td>DELETE</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${productMallList}" var="productMall">
							<tr class="active" style="background-color: #C0C0C0; color: #1a1a1a; text-align: center;" height="30px">
								<td><c:out value="${productMall.id}" /></td>
								<td><c:out value="${productMall.name}" /></td>
								<td><c:out value="${productMall.description}" /></td>
								<td><c:out value="${productMall.price}" /></td>
								<td><c:out value="${productMall.categoryMall.cat_name}" /></td>
								<td><c:out value="${productMall.supplierMall.supp_name}" /></td>
								<td><c:out value="${productMall.imagepath}"/></td>
								<td><a href="Edit?id=${productMall.id}">Edit</a></td>
								<td><a href="Delete?id=${productMall.id}">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:if>	
		</div>
</body>
</html>