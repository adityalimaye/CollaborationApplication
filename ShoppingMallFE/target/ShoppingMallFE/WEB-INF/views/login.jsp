<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/jquery-3.1.1.min.js"></script>
<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<link href="<c:url value="/resources/css/sty.css" />" rel="stylesheet">

</head>
<body>
	
	<div align="center" style="color: #404040; font-size: 30px">
		<b>LOGIN</b>
	</div>
	
	<div align="center" class="container fluid">
	
	<form  method="post" action="<c:url value='j_spring_security_check' />">
		
		<div class="imgcontainer">
			<img src="resources/image/img_avatar3.jpg" alt="Avatar" class="avatar">
		</div>
		
		<div align="center" style="color: #99FFFF">${message}</div>
		
		<label><b>Username</b></label> <input type="text" placeholder="Enter Username" name="username" required> <br>
		<label><b>Password</b></label> <input type="password" placeholder="Enter Password" name="password" required> <br>
		<button type="submit" value="Login">Login</button>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	</div>
</body>
</html>