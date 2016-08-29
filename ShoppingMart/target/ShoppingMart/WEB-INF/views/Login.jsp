<!DOCTYPE html>
<html>

<head>

<title>Login</title>

	<style type="text.css">

	body{
	background-image: <img src="<c:url value='/images/image15.jpg'/>"/>;
	background-size: cover;
	}
	.aa{
		width: 300px;
		height: 260px;
		background-color: rgba(0,0,0,0.4);
		margin: 0 auto;
		margin-top: 40px;
		padding-top: 10px;
		padding-left: 50px;
		border-radius: 15px;
		-webkit-border-radius: 15px;
		-o-border-radius: 15px;
		-moz-border-radius: 15px;
		color: white;
		font-weight: bolder;
		box-shadow: inset -4px -4px rgba(0,0,0,0.5);
		font-size: 18px;
	}

.aa input[type="text"]{
	width: 200px;
	height: 35px;
	border: 0;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-o-border-radius: 5px;
	-moz-border-radius: 5px;
	padding-left: 5px;
}

.aa input[type="password"]{
	width: 200px;
	height: 35px;
	border: 0;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-o-border-radius: 5px;
	-moz-border-radius: 5px;
	padding-left: 5px;
}

.aa input[type="submit"]{
	width: 100px;
	height: 35px;
	border: 0;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-o-border-radius: 5px;
	-moz-border-radius: 5px;
	background-color: skyblue;
	font-weight: bolder;
}


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
</html>