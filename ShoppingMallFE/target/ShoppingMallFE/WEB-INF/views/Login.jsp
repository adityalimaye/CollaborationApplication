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

	<h1>Welcome Back!</h1>

	<form:form action="saveuser" modelAttribute="userDetailsMall1" enctype="multipart/form-data">

		<div class="field-wrap">
			<table>
				<tr>
					<td><form:label path="mailID">Email_id</form:label></td>
					<td><form:input path="mailID"
							value="${userDetailsMallEdit.mailID}" /></td>
				</tr>

				<tr>
					<td><form:label path="password" type="password">Password</form:label></td>
					<td><form:input path="password" type="password"
							value="${userMallEdit.password}" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="button" value="Reset" /></td>
				</tr>
			</table>
		</div>
	</form:form>
	<a href="AddUser">Not Registered Yet?</a>







	<!--  <div id="container_demo" >
	hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4 
	<a class="hiddenanchor" id="toregister"></a>
	<a class="hiddenanchor" id="tologin"></a>
	<div id="wrapper">
		<div id="login" class="animate form">
			<form  action="mysuperscript.php" autocomplete="on"> 
				<h1>Log in</h1> 
				<p> 
					<label for="username" class="uname" data-icon="u" > Your email or username </label>
					<input id="username" name="username" required="required" type="text" placeholder="UserName"/>
				</p>
				<p> 
					<label for="password" class="youpasswd" data-icon="p"> Your password </label>
					<input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
				</p>
				<p class="keeplogin"> 
					<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
					<label for="loginkeeping">Keep me logged in</label>
				</p>
				<p class="login button"> 
					<input type="submit" value="Login" /> 
				</p>
				<p class="change_link">
					Not a member yet ?
					<a href="Register" class="to_register">Join us</a>
				</p>
			</form>
		</div>

	</div>
</div> -->

	<!-- <div class="container">
  <div class="login">
  	<h1 class="login-heading">
      <strong>Welcome.</strong> Please login.</h1>
      <form method="post">
        <input type="text" name="user" placeholder="Username" required="required" class="input-txt" />
          <input type="password" name="password" placeholder="Password" required="required" class="input-txt" />
          
          <div class="login-footer">
             <a href="#" class="lnk">
              <span class="icon icon--min">ಠ╭╮ಠ</span> 
              I've forgotten something
            </a>
            <button type="submit" class="btn btn--right">Sign in  </button>
    
          </div>
      </form>
  </div>
</div>
    
        <script src="js/index.js"></script>

    
    
    
  </body>
</html> -->








	<%-- <!DOCTYPE html>
<html>

<head>

<title>Login</title>

<style type="text/css">
    <%@include file="text.css" %>
    </style>

	<style type="text.css">
</style>
</head>
<body>
<form action="LoginController" method ="post">
${message}Enter your Login Credentials here!!!

<div class= "aa"> 
<h2>Login</h2>
<form>

	<input type="text" placeholder="Please Enter The Username..." ><br><br>
	<input type="password" placeholder="Please Enter The Password..."><br><br>
	<input type="submit" value="Login">

</form>

</div>
</form>
</body>
</html> --%>


</body>
</html>