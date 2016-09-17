  <!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Simple login form</title>
    		<link rel="stylesheet" href="resources/css/reset.css">
    		<link rel="stylesheet" href="resources/css/style1.css">
    		
 </head>

  <body>
  
  <div id="container_demo" >
	<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
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
</div>

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