<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Add Product</title>
<link rel="stylesheet" href="resources/css/edittable.css">
</head>
<body>

	<h2>Product Details</h2>

	<form:form action="saveproduct" modelAttribute="productMall">
		<table>
			<tr>

				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id"/></td>
			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:input path="description" /></td>
			</tr>

			<tr>
				<td><form:label path="price">Price</form:label></td>
				<td><form:input path="price" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="button" value="Reset" /></td>
			</tr>

		</table>
	</form:form>
	<br>


	
	 <h2>Edit Product Details</h2>

	<form:form action="Edit" modelAttribute="productMall">
		<table>
			<tr>

				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id" readonly="true" size="8" disabled="true"  /></td>
				<form:hidden path="id" />
			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:input path="description" /></td>
			</tr>

			<tr>
				<td><form:label path="price">Price</form:label></td>
				<td><form:input path="price" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>

		</table>
	</form:form> --%>


	<div style="color: teal; font-size: 30px">View Product Details</div>

	<c:if test="${!empty productMallList}">

		<div class="container">
			<div class=".table-responsive">
				<table class="table" border="1" bgcolor="black" width="600px">
					<thead>

						<tr
							style="background-color: #CC99FF; color: #CC0000; text-align: center;"
							height="40px">

							<td>Id</td>
							<td>Name</td>
							<td>Description</td>
							<td>Price</td>
							<td>Edit</td>
							<td>Delete</td>
						</tr>
					</thead>
					
					<tbody>
							<c:forEach items="${productMallList}" var="productMall">

								<tr
									style="background-color: #FF9966; color: #000099; text-align: center;"
									height="30px">

									<td><c:out value="${productMall.id}" /></td>
									<td><c:out value="${productMall.name}" /></td>
									<td><c:out value="${productMall.description}" /></td>
									<td><c:out value="${productMall.price}" /></td>
									<td><a href="Edit?id=${productMall.id}">Edit</a></td>
									<td><a href="Delete?id=${productMall.id}">Delete</a></td>
								</tr>
							</c:forEach>

					</tbody>
					</table>
			</div>
		</div>
	
	</c:if>


	<%-- <c:url var="addAction" value="/person/add" ></c:url>

<form:form action="${addAction}" commandName="person">
<table>
	<c:if test="${!empty person.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="country">
				<spring:message text="Country"/>
			</form:label>
		</td>
		<td>
			<form:input path="country" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty person.name}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
   
 --%>





</body>
</html>