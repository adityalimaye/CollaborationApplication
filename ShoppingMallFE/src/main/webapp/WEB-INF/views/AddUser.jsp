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
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/jquery-3.1.1.min.js"></script>
<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/sty1.css" />" rel="stylesheet">

<title>Add User</title>
</head>

<body>
	<div class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="FlyAroundTheGlobe">Fly Around The
					Globe</a>
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

	<div align="center" style=" color: #404040; font-size: 30px">USER DETAILS</div>
	<div align="center" class="container-fluid">
	<form:form action="saveuser" modelAttribute="userDetailsMall" enctype="multipart/form-data">

		<table>
			<tr>
				<td><form:label path="name">NAME</form:label></td>
				<td><form:input path="name" placeholder="Enter the Name" value="${userDetailsMallEdit.name}" required="true" /></td>
			</tr>

			<tr>
				<c:choose>
					<c:when test="${!empty userDetailsMallEdit.id}">
						<td><form:label path="id">USER_ID</form:label></td>
						<td><form:input path="id" placeholder="Enter the User_ID" readonly="true" required="true" /></td>
					</c:when>
				</c:choose>

			</tr>

			<tr>
				<td><form:label path="email_id">EMAIL-ID</form:label></td>
				<td><form:input path="email_id" placeholder="Enter the Email_ID" value="${userDetailsMallEdit.email_id}" required="true" /></td>
			</tr>

			<tr>
				<td><form:label path="password" type="password">PASSWORD</form:label></td>
				<td><form:input path="password" placeholder="Enter the Password" type="password" value="${userDetailsMallEdit.password}" required="true" /></td>
			</tr>


			<tr>
				<td><form:label path="contact">MOBILE #:</form:label></td>
				<td><form:input path="contact" placeholder="Enter the Contact Number" value="${userDetailsMallEdit.contact}" required="true" /></td>
			</tr>

			<tr>
				<td><form:label path="user_address">ADDRESS</form:label></td>
				<td><form:input path="user_address" placeholder="Enter the Address" value="${userDetailsMallEdit.user_address}" required="true" /></td>
			</tr>

			<tr>
				<td><form:input type="hidden" path="enabled" value="TRUE" /></td>
			</tr>

			<tr>
				<td>PICK A FILE :</td>
				<td><input type="file" name="fileUpload" size="50" /></td>
			</tr>


			<c:choose>
				<c:when test="${!empty userDetailsMallEdit.id}">
					<tr>
						<td colspan="2"><button type="submit" value="UpdateUsers">UPDATE</button></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="2"><button type="submit" value="Submit">SUBMIT</button> <button type="submit" class="resetbtn" value="Reset" onClick="this.form.reset()">Reset</button></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</form:form>
	</div>
	
	<div align="center" class="container fluid"><a href="login"><span class="glyphicon glyphicon-user"> GO FOR LOGIN! </span></a></div>
	<br>


	<%-- <div class="container-fluid">
		<div style="color: teal; font-size: 30px">View User Details</div>

		<c:if test="${!empty userDetailsMallList}">

			<div class="container">
				<!-- <div class="table-responsive"> -->

				<table id="example" class="table table-responsive table-stripped table-hover" cellspacing="0"
					width="60%">
					<thead>
						<tr
							style="background-color: #595959; color: #FAEBD7; text-align: center;"
							height="40px">

							<td>Name</td>
							<td>User-Id</td>
							<td>Email-id</td>
							<td>Password</td>
							<td>Contact</td>
							<td>Address</td>
							<!-- <td>Enabled</td> -->
							<td>Edit</td>
							<td>Delete</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${userDetailsMallList}" var="userDetailsMall">

							<tr
								style="background-color: #C0C0C0; color: #1a1a1a; text-align: center;"
								height="30px">
								
								<td><c:out value="${userDetailsMall.name}" /></td>
								<td><c:out value="${userDetailsMall.id}" /></td>
								<td><c:out value="${userDetailsMall.email_id}" /></td>
								<td><c:out value="${userDetailsMall.password}" /></td>
								<td><c:out value="${userDetailsMall.contact}" /></td>
								<td><c:out value="${userDetailsMall.user_address}" /></td>
								<td><c:out value="${userDetailsMall.enabled}" /></td>
								
								<td><a href="EditUsr?id=${userDetailsMall.id}">Edit</a></td>
								<td><a href="DeleteUsr?id=${userDetailsMall.id}">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</c:if>
		</div> --%>
	<br>

	</center>
</body>
</html>