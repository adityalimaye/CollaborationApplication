<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- Bootstrap -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="<c:url value="/resources/css/sty1.css" />" rel="stylesheet">

<title>Add Category</title>

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

	<div align="center" style="color: #404040; font-size: 30px">
		<b>CATEGORY DETAILS</b>
	</div>
	<div align="center" class="container fluid">
		<form:form action="savecategory" modelAttribute="categoryMall"
			enctype="multipart/form-data">
			<table>
				<tr>
					<c:choose>
						<c:when test="${!empty categoryMallEdit.id}">
							<td><form:label path="id">ID</form:label></td>
							<td><form:input path="id" readonly="true" required="true" /></td>
						</c:when>
					</c:choose>
				</tr>

				<tr>
					<td><form:label path="cat_name">NAME</form:label></td>
					<td><form:input path="cat_name" placeholder="Enter CategoryName" value="${categoryMallEdit.cat_name}" required="true" /></td>
				</tr>

				<tr>
					<td><form:label path="description">DESCRIPTION</form:label></td>
					<td><form:input path="description" placeholder="Enter CategoryDescription" value="${categoryMallEdit.description}" required="true" /></td>
				</tr>

				<tr>
					<td>PICK A FILE:</td>
					<td><input type="file" name="fileUpload" size="50" /></td>
				</tr>

				<c:choose>
					<c:when test="${!empty categoryMallEdit.id}">
						<tr>
							<td colspan="2"><button type="submit" value="UpdateCategory">UPDATE</button></td>
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


	<div align="center" style="color: #303030; font-size: 30px">
		<b>DISPLAY CATEGORY DETAILS</b>
	</div>
	<div align="center" class="container fluid">
		<c:if test="${!empty categoryMallList}">

			<div class="container">
				<!-- <div class="table-responsive"> -->

				<table id="example" class="table table-responsive table-stripped table-hover" cellspacing="0" width="60%">
					<thead>
						<tr style="background-color: #595959; color: #FAEBD7; text-align: center;" height="40px">
							<td>ID</td>
							<td>NAME</td>
							<td>DESCRIPTION</td>
							<td>EDIT</td>
							<td>DELETE</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${categoryMallList}" var="categoryMall">
							<tr class="active" style="background-color: #C0C0C0; color: #1a1a1a; text-align: center;" height="30px">

								<td><c:out value="${categoryMall.id}" /></td>
								<td><c:out value="${categoryMall.cat_name}" /></td>
								<td><c:out value="${categoryMall.description}" /></td>
								<td><a href="EditCat?id=${categoryMall.id}">Edit</a></td>
								<td><a href="DeleteCat?id=${categoryMall.id}">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

		</c:if>
	</div>
</body>
</html>