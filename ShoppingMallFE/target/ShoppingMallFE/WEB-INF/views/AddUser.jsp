<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add User</title>


</head>
<body>
	<center>
			<div style="color: teal; font-size: 30px">User Details</div>
			<form:form action="saveuser" modelAttribute="userDetailsMall" enctype="multipart/form-data">

		
							<table>

								<tr>

									<td><form:label path="id">Id</form:label></td>
									<c:choose>
										<c:when test="${!empty userDetailsMallEdit.id}">
											<td><form:input path="id" readonly="true" /></td>
										</c:when>
										<c:otherwise>
											<td><form:input path="id" size="8" /></td>
										</c:otherwise>
									</c:choose>

								</tr>


								<tr>
									<td><form:label path="name">Name</form:label></td>
									<td><form:input path="name" value="${userDetailsMallEdit.name}" /></td>
								</tr>
								
								<tr>
									<td><form:label path="address">Address</form:label></td>
									<td><form:input path="address" value="${userDetailsMallEdit.address}" /></td>
								</tr>



								<tr>
									<td><form:label path="contactNumber">Contact Number</form:label></td>
									<td><form:input path="contactNumber" value="${userDetailsMallEdit.contactNumber}" /></td>
								</tr>


								<tr>
									<td><form:label path="mailID">Email_id</form:label></td>
									<td><form:input path="mailID" value="${userDetailsMallEdit.mailID}" /></td>
								</tr>

								<tr>
									<td><form:label path="password" type="password">Password</form:label></td>
									<td><form:input path="password" type="password" value="${userDetailsMallEdit.password}" /></td>
								</tr>

								<tr>
									<td>Pick file #1:</td>
									<td><input type="file" name="fileUpload" size="50" /></td>
								</tr>


								<c:choose>
									<c:when test="${!empty userDetailsMallEdit.id}">
										<tr>
											<td colspan="2"><input type="submit" value="Update_User" /></td>
										</tr>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="2"><input type="submit" value="Submit" /></td>
										</tr>

										<tr>
											<td colspan="2"><input type="button" value="Reset" /></td>
										</tr>
									</c:otherwise>
								</c:choose>
							</table>
				</form:form>
				
				<a href="Login">Go For Login!</a>
			
		<br>


		<div style="color: teal; font-size: 30px">View User Details</div>

		<c:if test="${!empty userDetailsMallList}">

			<div class="container">
				<!-- <div class="table-responsive"> -->

				<table id="example" class="table table-hover" cellspacing="0"
					width="60%" border="1">
					<thead>



						<tr
							style="background-color: #595959; color: #FAEBD7; text-align: center;"
							height="40px">

							<td>Id</td>
							<td>Name</td>
							<td>Address</td>
							<td>Contact Number</td>
							<td>Email_id</td>
							<td>Password</td>
							<td>Edit</td>
							<td>Delete</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${userDetailsMallList}" var="userDetailsMall">

							<tr
								style="background-color: #C0C0C0; color: #1a1a1a; text-align: center;"
								height="30px">

								<td><c:out value="${userDetailsMall.id}" /></td>
								<td><c:out value="${userDetailsMall.name}" /></td>
								<td><c:out value="${userDetailsMall.address}" /></td>
								<td><c:out value="${userDetailsMall.contactNumber}" /></td>
								<td><c:out value="${userDetailsMall.mailID}" /></td>
								<td><c:out value="${userDetailsMall.password}" /></td>
								
								<td><a href="EditUs?id=${userDetailsMall.id}">Edit</a></td>
								<td><a href="DeleteUs?id=${userDetailsMall.id}">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</c:if>
		<br>

	</center>
</body>
</html> --%>