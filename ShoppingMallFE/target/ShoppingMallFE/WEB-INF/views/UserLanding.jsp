<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>


<title>Welcome to FlyAroundTheGlobe!!!</title>
<meta charset="utf-8">

<link rel="stylesheet" type="text/css" href="resources/css/style6.css" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}
</style>

<script>
	//Load this when the DOM is ready
	$(function() {
		// You used .myCarousel here. 
		// That's the class selector not the id selector,
		// which is #myCarousel
		$('#myCarousel').carousel();
	});
</script>
</head>

<body>
	<nav class="navbar navbar-default">

		<div class="navbar-header">
			<a class="navbar-brand" href="#">FlyAroundTheGlobe</a>
		</div>

		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
		</ul>
			
		<ul class="nav navbar-nav navbar-right">
        <c:url value="j_spring_security_logout" var="logoutUrl" />
    	<li><a href="logout?${logoutUrl}"><span class="glyphicon glyphicon-user"></span> Logout </a></li>	
		</ul>	
			<!-- <li><a href="#">Group Tours</a></li>
			<li><a href="#">Wildlife Tours</a></li>
			<li><a href="#">Speciality Tours</a></li> -->
		</ul>
	</nav>

	<ul class="tab">
		<li><a href="#" class="tablinks"
			onclick="openCity(event, 'London')">Group Tours</a></li>
		<li><a href="#" class="tablinks"
			onclick="openCity(event, 'Paris')">WildLife Tours</a></li>
		<li><a href="#" class="tablinks"
			onclick="openCity(event, 'Tokyo')">Speciality Tours</a></li>
	</ul>

	<div id="London" class="tabcontent">
		<div class="container-fluid">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="container-fluid">
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<a href="londonBridge"><img src="resources/image/GroupTours/london-bridge-England.jpg"></a>
						<div class="carousel-caption">
							<h3>London Bridge</h3>
							<p>England</p>
						</div>
					</div>

					<div class="item">
						<a href="manasluExpedition"><img src="resources/image/GroupTours/Manaslu-Expedition-Nepal.jpg"
							alt="Chania"></a>
						<div class="carousel-caption">
							<h3>Manaslu Expedition</h3>
							<p>Nepal</p>
						</div>
					</div>

					<div class="item">
						<a href="theMariendom">
						<img src="resources/image/GroupTours/The-Mariendom-Linz-Austria-America.jpg"></a>
						<div class="carousel-caption">
							<h3>The Mariendom</h3>
							<p>Linz Austria</p>
						</div>
					</div>

					<div class="item">
						<a href="veniceItaly"><img src="resources/image/GroupTours/Venice-Italy.jpg"></a>
						<div class="carousel-caption">
							<h3>Venice-Italy</h3>
							<p>A Perfect Place to Enjoy the Vacation</p>
						</div>
					</div>
				</div>
			</div>


			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>	
		</div>
		<br>
		
		<div class="container-fluid">
			<div class="row">

				<div class="col-sm-4">
					<a href="grpTour1"><img src="resources/image/GroupTours/imgback1.jpg"
						class="img-responsive" alt="Wonderful Scenary"></a>
					<p>A wonderful scenery</p>
					<p>A magnificiant Monument</p>
				</div>

				<div class="col-sm-4">
					<a href="grpTour2"><img src="resources/image/GroupTours/imgback2.jpg"
						class="img-responsive" alt="Beautiful View"></a>
					<p>Beautiful View</p>
					<p>A DelightFul Day</p>
				</div>

				<div class="col-sm-4">
					<a href="grpTour3"><img src="resources/image/GroupTours/imgback3.jpg"
						class="img-responsive" alt="Joyful Hours"></a>
					<p>Joyful Hours</p>
					<p>A WeekEnd Spot</p>
				</div>
			</div>
		</div>

	</div>

	<div id="Paris" class="tabcontent">

		<div id="myCarousel1" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="container-fluid">
				<div class="carousel-inner" role="listbox">
					
					<div class="item active">
						<img src="resources/image/WildLife/imgcouwildlife1.jpg"
							alt="Corbett National Park">
						<div class="carousel-caption">
							<h3>Corbett National Park</h3>
							<p>Uttarakhand</p>
						</div>
					</div>

					<div class="item">
						<img src="resources/image/WildLife/imgcouwildlife2.jpg"
							alt="Namibia WildLife Sanctuary">
						<div class="carousel-caption">
							<h3>Namibia WildLife Sanctuary</h3>
							<p>Africa</p>
						</div>
					</div>

					<div class="item">
						<img src="resources/image/WildLife/imgcouwildlife6.jpg"
							alt="Kruger National Park">
						<div class="carousel-caption">
							<h3>The Kruger National Park</h3>
							<p>South Africa</p>
						</div>
					</div>

					<div class="item">
						<img src="resources/image/WildLife/imgcouwildlife7.jpg"
							alt="Kevin Richardson WildLife">
						<div class="carousel-caption">
							<h3>Kevin Richardson WildLife Sanctuary</h3>
							<p>South Africa</p>
						</div>
					</div>
				</div>
				</div>	


			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"> 
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
			</a> 
			
			<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"> 
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
			</a>
		</div>
	

		<br>

		<div class="container-fluid">
			<div class="row">

				<div class="col-sm-4">
					<img src="resources/image/WildLife/imgcouwildlife8.jpg"
						class="img-responsive" alt="WildLife Zebras">
					<p>Mlilwane WildLife</p>
					<p>Swaziland</p>
				</div>

				<div class="col-sm-4">
					<img src="resources/image/WildLife/imgcouwildlife9.jpg"
						class="img-responsive" alt="WildLife Giraffe">
					<p>Calauit Safari Park</p>
					<p>A speciality conservation for giraffe</p>
				</div>

				<div class="col-sm-4">
					<img src="resources/image/WildLife/imgcouwildlife10.jpg"
						class="img-responsive" alt="WildLife Flamingo">
					<p>Flamingo WildLife Sanctuary</p>
					<p>Orrisa</p>
				</div>
			</div>
		</div>
	</div>
	
	<div id="Tokyo" class="tabcontent">
		<h3>Tokyo</h3>
		<p>Tokyo is the capital of Japan.</p>
	</div>






	<script>
		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}
	</script>

</body>
</html>