<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple login form</title>
</head>
<body>
	<h2>Login Here</h2>
	<div
			style="text-align: center; padding: 30px; border: 1px solid green; width: 250px;">
			<form method="post" action= "<c:url value='j_spring_security_check' />">

				<table>
					<tr>
						<td colspan="2" style="color: red">${message}</td>

					</tr>
					<tr>
						<td>User Name:</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Login" /></td>

					</tr>
				</table>
			</form>
		</div>
</body>
</html>