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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/sty1.css" />" rel="stylesheet">

<title>Travel Agent's Details</title>
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

		<div align="center" style="color: #404040; font-size: 30px">TRAVEL AGENT'S DETAILS</div>
		<div align="center" class="container fluid">
		<form:form action="savesupplier" modelAttribute="supplierMall" enctype="multipart/form-data">
			<table>
				<tr>
					<c:choose>
						<c:when test="${!empty supplierMallEdit.id}">
							<td><form:label path="id">ID</form:label></td>
							<td><form:input path="id" readonly="true" /></td>
						</c:when>
					</c:choose>

				</tr>
				
				<tr>
					<td><form:label path="supp_name">NAME</form:label></td>
					<td><form:input path="supp_name" value="${supplierMallEdit.supp_name}" required="true"/></td>
				</tr>
				
				<tr>
					<td><form:label path="description">DESCRIPTION</form:label></td>
					<td><form:input path="description" value="${supplierMallEdit.description}" required="true"/></td>
				</tr>

				<tr>
					<td><form:label path="address">ADDRESS</form:label></td>
					<td><form:input path="address" value="${supplierMallEdit.address}" required="true"/></td>
				</tr>

				<tr>
					<td><form:label path="email_id">EMAIL_ID</form:label></td>
					<td><form:input path="email_id" value="${supplierMallEdit.email_id}" required="true"/></td>
				</tr>
				
				<tr>
					<td><form:label path="contact_number">CONTACT NUMBER</form:label></td>
					<td><form:input path="contact_number" value="${supplierMallEdit.contact_number}" required="true"/></td>
				</tr>
				
				<tr>
                    <td>PICK A FILE:</td>
                    <td><input type="file" name="fileUpload" size="50" /></td>
                </tr>

				<c:choose>
					<c:when test="${!empty supplierMallEdit.id}">
						<tr>
							<td colspan="2"><button type="submit" value="UpdateTravelAgents">UPDATE</button></td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="2"><button type="submit" value="Submit">SUBMIT</button></td>
						</tr>

						<tr>
							<td colspan="2"><button type="button" value="Reset" onClick="this.form.reset()">RESET</button></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</form:form>
		</div>
		<br>

		
		<div align="center" style="color: #404040; font-size: 30px">VIEW TRAVEL AGENT'S DETAILS</div>
		<div align="center" class="container fluid">
		<c:if test="${!empty supplierMallList}">

			<div class="container">
				<!-- <div class="table-responsive"> -->

				<table id="example" class="table table-responsive table-stripped table-hover" cellspacing="0" width="60%">
					<thead>

						<tr style="background-color: #595959; color: #FAEBD7; text-align: center;"height="40px">

							<td>ID</td>
							<td>NAME</td>
							<td>DESCRIPTION</td>
							<td>ADDRESS</td>
							<td>EMAIL_ID</td>
							<td>CONTACT_NUMBER</td>
							<td>EDIT</td>
							<td>DELETE</td>
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
	
</body>
</html>