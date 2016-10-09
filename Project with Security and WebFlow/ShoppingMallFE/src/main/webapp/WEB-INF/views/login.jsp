<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>

<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Login Form</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
form {
	border: 3px #f1f1f1;
}

/* Full-width
	inputs */
input[type=text], input[type=password] {
	width: 70%;
	padding: 8px 16px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all
	buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 75%;
}

/* Extra style for the cancel button (red) */
.cancelbtn {
	width: 70%;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the avatar image inside this container */
.imgcontainer {
	text-align: center;
	margin: 10px 0 4px 0;
}

/* Avatar image */
img.avatar {
	width: 15%;
	border-radius: 15%;
}

/* Add padding to containers */
.container {
	padding: 15px;
}

/* The "Forgot password" text */
/* span.psw {
	float: right;
	padding-top: 16px;
} */

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: auto;
	}
}
</style>
</head>
<body>

		<div class="container-fluid">
		
		<form method="post" action="<c:url value='j_spring_security_check' />">
			
			<div class="imgcontainer">
				
				<img src="resources/image/img_avatar3.jpg" alt="Avatar"
					class="avatar">
			</div>

				
      		<div style="color: red">${message}</div>
			
				<label><b>Username</b></label> <input type="text" placeholder="Enter Username" name="username" required> <br>
				<label><b>Password</b></label> <input type="password" placeholder="Enter Password" name="password" required> <br>
				<button type="submit" value="Login">Login</button>  
				<!-- <button type="button" class="cancelbtn">Cancel</button> -->
				<!-- <input type="checkbox" checked="checked"> Remember me -->
				
			

			<!-- <div class="container" style="background-color: #f1f1f1"> -->
				
			 <!-- <span class="passsword">Forgot <a href="home">password?</a></span> 
			</div> -->
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		</div>		
</body>
</html>