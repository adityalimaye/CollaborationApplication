<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

<style>
/* Bordered form */
form {
	border: 3px #f1f1f1;
}

/* Full-width inputs */
input[type=text] {
	width: 100%;
	padding: 4px 8px;
	margin: 4px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 6px 10px;
	margin: 4px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Agent's Details</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="FlyAroundTheGlobe">Fly Around The Globe</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="Home">Home</a></li>
			<li><a href="AddProduct">Add Product</a></li>
			<li><a href="AddCategory">Add Category</a></li>
			<li><a href="AddSupplier">Add Travel Agent's Details</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:url value="j_spring_security_logout" var="logoutUrl" />
    	<li><a href="logout?${logoutUrl}"><span class="glyphicon glyphicon-user"></span> Logout </a></li>
			<!-- <li><a href="AddUser"><span class="glyphicon glyphicon-user"></span>
					Sign Up </a></li>
			<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>
					Login </a></li> -->
		</ul>
	</div>
	</nav>

	<center>
		<div class= "container-fluid">
		<div style="color: teal; font-size: 30px">Travel Agent's Details</div>

		<form:form action="savesupplier" modelAttribute="supplierMall" enctype="multipart/form-data">
			<table>
				<tr>

					<td><form:label path="id"><!-- Id --></form:label></td>
					<c:choose>
						<c:when test="${!empty supplierMallEdit.id}">
							<td><form:input path="id" readonly="true" /></td>
						</c:when>
						<c:otherwise>
							<%-- <td><form:label path="id">Id</form:label></td> --%>
							<%-- <td><form:input path="id" size="8" /></td> --%>
						</c:otherwise>
					</c:choose>

				</tr>
				
				<tr>
					<td><form:label path="supp_name">Name</form:label></td>
					<td><form:input path="supp_name" value="${supplierMallEdit.supp_name}" /></td>
				</tr>
				
				<tr>
					<td><form:label path="description">Description</form:label></td>
					<td><form:input path="description" value="${supplierMallEdit.description}" /></td>
				</tr>

				<tr>
					<td><form:label path="address">Address</form:label></td>
					<td><form:input path="address" value="${supplierMallEdit.address}" /></td>
				</tr>

				<tr>
					<td><form:label path="email_id">Email_id</form:label></td>
					<td><form:input path="email_id" value="${supplierMallEdit.email_id}" /></td>
				</tr>
				
				<tr>
					<td><form:label path="contact_number">Contact Number</form:label></td>
					<td><form:input path="contact_number" value="${supplierMallEdit.contact_number}" /></td>
				</tr>
				
				<tr>
                    <td>Pick file #1:</td>
                    <td><input type="file" name="fileUpload" size="50" /></td>
                </tr>

				<c:choose>
					<c:when test="${!empty supplierMallEdit.id}">
						<tr>
							<td colspan="2"><button type="submit" value="UpdateTravelAgents">Update_TravelAgents</button></td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="2"><button type="submit" value="Submit">Submit</button></td>
						</tr>

						<tr>
							<td colspan="2"><button type="button" value="Reset" onClick="this.form.reset()">Reset</button></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</form:form>
		</div>
		<br>

		<div class="container-fluid">
		<div style="color: teal; font-size: 30px">View Travel Agent's Details</div>

		<c:if test="${!empty supplierMallList}">

			<div class="container">
				<!-- <div class="table-responsive"> -->

				<table id="example" class="table table-responsive table-stripped table-hover" cellspacing="0" width="60%">
					<thead>

						<tr style="background-color: #595959; color: #FAEBD7; text-align: center;"height="40px">

							<td>Id</td>
							<td>Name</td>
							<td>Description</td>
							<td>Address</td>
							<td>Email_id</td>
							<td>Contact_Number</td>
							<td>Edit</td>
							<td>Delete</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${supplierMallList}" var="supplierMall">

							<tr class="active" style="background-color: #C0C0C0; color: #1a1a1a; text-align: center;"height="30px">

								<td><c:out value="${supplierMall.id}" /></td>
								<td><c:out value="${supplierMall.supp_name}" /></td>
								<td><c:out value="${supplierMall.description}" /></td>
								<td><c:out value="${supplierMall.address}" /></td>
								<td><c:out value="${supplierMall.email_id}" /></td>
								<td><c:out value="${supplierMall.contact_number}" /></td>
								<td><a href="EditSup?id=${supplierMall.id}">Edit</a></td>
								<td><a href="DeleteSup?id=${supplierMall.id}">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

		</c:if>
		</div>
		<br>
</center>
</body>
</html>