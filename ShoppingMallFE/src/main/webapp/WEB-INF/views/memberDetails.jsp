<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Tour Details</title>
		<link href="style.css" rel="stylesheet" type="text/css" />
	</head>
<body>
	
	<div class="content">
		<fieldset>
			<legend>Register Here</legend>
			<a href="${flowExecutionUrl}&_eventId_home">Home</a>
			
			<form:form action="saveuser1" modelAttribute="userDetailsMall" enctype="multipart/form-data">
				<table>
				<tr> <td><form:label path="name">User Name:</form:label></td>
					 <td><form:input path="name" required="true"/></td>
				
				<!-- to display validation messages -->
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('name')}" var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>				
				</tr>
				
				<tr><td><form:label path="id">User ID:</form:label></td>
				    <td><form:input path="id" required="true"/></td>
				
				<!-- to display validation messages -->
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('id')}" var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>
				</tr>

				
				<tr><td><form:label path="email_id">Email ID:</form:label></td>
				    <td><form:input path="email_id" required="true"/></td>
				<!-- to display validation messages -->
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('email_id')}" var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>
				</tr>
				
				<tr><td><form:label path="password">Password:</form:label></td>
				    <td><form:input type="password" path="password" required="true"/></td>
				<!-- to display validation messages -->
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>
				</tr>
				

				<tr><td><form:label path="contact">Mobile #:</form:label></td>
				    <td><form:input path="contact" required="true"/></td>
				<!-- to display validation messages -->
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('contact')}" var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>
				</tr>

				<tr><td><form:label path="user_address">Address: </form:label></td>
				    <td><form:input path="user_address" required="true"/></td>
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('user_address')}" var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>
				</tr>
				
				<tr><td>Pick file #1:</td>
					<td><input type="file" name="fileUpload" size="50" /></td>
				</tr>
				
				<tr>	
					<td><input name="_eventId_submit" type="submit" value="Submit" /></td>
				</tr>	
			</table>	
			</form:form>
		</fieldset>
	</div>
	
</body>
</html>