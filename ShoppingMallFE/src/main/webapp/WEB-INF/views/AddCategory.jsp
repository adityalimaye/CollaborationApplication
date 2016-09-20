<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Category</title>
</head>
<body>
<center>
<div style="color: teal; font-size: 30px">Category Details</div>

		<form:form action="savecategory" modelAttribute="categoryMall" enctype="multipart/form-data">
			<table>
				<tr>

					<td><form:label path="id">Id</form:label></td>
					<c:choose>
						<c:when test="${!empty categoryMallEdit.id}">
							<td><form:input path="id" readonly="true" /></td>
						</c:when>
						<c:otherwise>
							<td><form:input path="id" size="8" /></td>
						</c:otherwise>
					</c:choose>

				</tr>
				
				<tr>
					<td><form:label path="description">Description</form:label></td>
					<td><form:input path="description" value="${categoryMallEdit.description}" /></td>
				</tr>
				
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" value="${categoryMallEdit.name}" /></td>
				</tr>
				
				<tr>
					<td>Pick file #1:</td>
					<td><input type="file" name="fileUpload" size="50" /></td>
				</tr>

				<c:choose>
					<c:when test="${!empty categoryMallEdit.id}">
						<tr>
							<td colspan="2"><input type="submit" value="Update_Category" /></td>
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
		<br>
		
		
		<div style="color: teal; font-size: 30px">View Category Details</div>

		<c:if test="${!empty categoryMallList}">

			<div class="container">
				<!-- <div class="table-responsive"> -->

					<table id="example" class="table table-hover" cellspacing="0" width="60%" border="1">
						<thead>

							<tr style="background-color: #595959; color: #FAEBD7; text-align: center;"height="40px">

								<td>Id</td>
								<td>Description</td>
								<td>Name</td>
								<td>Edit</td>
								<td>Delete</td>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${categoryMallList}" var="categoryMall">

								<tr style="background-color: #C0C0C0; color: #1a1a1a; text-align: center;"height="30px">

									<td><c:out value="${categoryMall.id}" /></td>
									<td><c:out value="${categoryMall.description}" /></td>
									<td><c:out value="${categoryMall.name}" /></td>
									<td><a href="EditCat?id=${categoryMall.id}">Edit</a></td>
									<td><a href="DeleteCat?id=${categoryMall.id}">Delete</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>

		</c:if>
		<br>
		
	<%--  <div style="color: teal; font-size: 30px">Upload a Suitable Image File</div>
		<form method="post" action="uploadFile.do"
			enctype="multipart/form-data">
			<table border="0">
				<tr>
					<td>Description:</td>
					<td><input type="text" name="description" size="50" /></td>
				</tr>
				<tr>
					<td>Pick file #1:</td>
					<td><input type="file" name="fileUpload" size="50" /></td>
				</tr>
				<!-- <tr>
                    <td>Pick file #2:</td>
                    <td><input type="file" name="fileUpload" size="50" /></td>
                </tr> -->
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Upload" /></td>
				</tr>
			</table>
		</form> --%> 
</center>
</body>
</html>