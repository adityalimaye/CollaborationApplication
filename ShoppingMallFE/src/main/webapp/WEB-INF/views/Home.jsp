<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Home Page</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>

<script>
// Load this when the DOM is ready
$(function(){
  // You used .myCarousel here. 
  // That's the class selector not the id selector,
  // which is #myCarousel
  $('#myCarousel').carousel();
});
</script>

</head>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Fly Around The Globe</a>
    </div>
    <ul class="nav navbar-nav">
      <!-- <li class="active"><a href="Home">Home</a></li>
      <li><a href="AddProduct">Add Product</a></li>
      <li><a href="AddCategory">Add Category</a></li>
      <li><a href="AddSupplier">Add Travel Agent's Details</a></li> -->
    </ul> 
    <ul class="nav navbar-nav navbar-right">
      <li><a href="AddUser"><span class="glyphicon glyphicon-user"></span> Sign Up </a></li>
      <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login </a></li> 
    </ul>
  </div>
</nav>
Hello!!!Welcome to Men's Avenue Shopping Mall
${mesasage} 
Welcome to Pheonix Mall!!! 
</body>
</html>