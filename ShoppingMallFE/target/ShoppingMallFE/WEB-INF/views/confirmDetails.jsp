<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Tour Details Confirm</title>
		<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
			<div class="content">
			
			<fieldset>
			<legend>Confirm Details</legend>
			<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
			<a href="${flowExecutionUrl}&_eventId_home">Home</a><br /> <br />
			<c:form modelAttribute="userDetailsMall">
				<table>
					<tr><td><c:label path="name"> User Name:</c:label>${userDetailsMall.name}</td></tr>
					<tr><td><c:label path="id">User Id :</c:label>${userDetailsMall.id}</td></tr>
					<tr><td><c:label path="email_id">Email :</c:label>${userDetailsMall.email_id}</td></tr>
					<tr><td><c:label path="password">Password:</c:label>${userDetailsMall.password}</td></tr>
					<tr><td><c:label path="contact">Mobile #:</c:label>${userDetailsMall.contact}</td></tr>
					<tr><td><c:label path="user_address">Address :</c:label>${userDetailsMall.user_address}</td></tr>
					<tr><td><button name="_eventId_edit" type="submit" value="Edit">Edit</button> <button name="_eventId_submit" type="submit" value="Confirm Details">Confirm Details</button></td></tr>
				</table>
			</c:form>
		</fieldset>
			
			
			<%-- <fieldset>
				<legend>Confirm Details</legend>
				<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
				<a href="${flowExecutionUrl}&_eventId_home">Home</a><br /><br />
				<sf:form modelAttribute="user">
					<sf:label path="user_id">UserName:</sf:label>${userBean.userId}
					<br /><br />
					<sf:label path="email">Email Id:</sf:label>${userBean.email}
					<br /><br />
					<sf:label path="age">Age :</sf:label>${userBean.age}
					<br /><br />
					<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
					<input name="_eventId_edit" type="submit" value="Edit" /> 
					<input name="_eventId_submit" type="submit" value="Confirm Details" /><br />
				</sf:form>
			</fieldset> --%>
		</div>
	
</body>
</html>