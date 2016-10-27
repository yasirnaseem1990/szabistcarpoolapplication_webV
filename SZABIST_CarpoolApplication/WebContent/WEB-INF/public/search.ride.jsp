<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta name="keywords" content="Transfers - Private Transport and Car Hire HTML Template" />
	<meta name="description" content="Transfers - Private Transport and Car Hire HTML Template">
	<meta name="author" content="themeenergy.com">
	
	<title>SzabistCarpool - Search results</title>
	
	<link rel="stylesheet" href="transfers/css/styler.css" />
	<link rel="stylesheet" href="transfers/css/theme-pink.css" id="template-color" />
	<!-- <link rel="stylesheet" href="transfers/css/theme-beige.css"/>
	<link rel="stylesheet" href="transfers/css/theme-dblue.css"/>
	<link rel="stylesheet" href="transfers/css/theme-dgreen.css"/>
	<link rel="stylesheet" href="transfers/css/theme-grey.css"/>
	<link rel="stylesheet" href="transfers/css/theme-lblue.css"/>
	<link rel="stylesheet" href="transfers/css/theme-lgreen.css"/>
	<link rel="stylesheet" href="transfers/css/theme-lime.css"/>
	<link rel="stylesheet" href="transfers/css/theme-orange.css"/>
	<link rel="stylesheet" href="transfers/css/theme-peach.css"/>
	<link rel="stylesheet" href="transfers/css/theme-purple.css"/>
	<link rel="stylesheet" href="transfers/css/theme-red.css"/>
	<link rel="stylesheet" href="transfers/css/theme-teal.css"/>
	<link rel="stylesheet" href="transfers/css/theme-turquoise.css"/>
	<link rel="stylesheet" href="transfers/css/theme-yellow.css"/> -->
	<link rel="stylesheet" href="transfers/css/style.css" />
	<link rel="stylesheet" href="transfers/css/animate.css" />
	<link href='http://fonts.googleapis.com/css?family=Raleway:400,500,600,700|Montserrat:400,700' rel='stylesheet' type='text/css'>
	<link rel="shortcut icon" href="transfers/images/favicon.ico" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>

<!-- Header -->
	<header class="header" role="banner">
		<div class="wrap">
			<!-- Logo -->
			<div class="logo">
				<a href="index-2.html" title="Transfers"><img src="transfers/images/transfers.jpg" alt="Transfers" /></a>
			</div>
			<!-- //Logo -->
			
			<!-- Main Nav -->
			<nav role="navigation" class="main-nav">
				<ul>
					<li><a href="index-2.html" title="">Home</a></li>
					<li><a href="destinations.html" title="Destinations">Destinations</a>
						<ul>
							<li><a href="destination-single.html" title="Single destination">Single destination</a></li>
							<li><a href="destination-micro.html" title="Micro destination">Micro destination</a></li>
						</ul>
					</li>
					<li><a href="tailor-made.html" title="Tailor made">Tailor made</a></li>
					<li><a href="blog.html" title="Blog">Blog</a>
						<ul>
							<li><a href="blog.html" title="Post">Blog list</a></li>
							<li><a href="blog2.html" title="Post">Blog grid</a></li>
							<li><a href="blog-single.html" title="Post">Post</a></li>
						</ul>
					</li>
					<li><a href="contact.html" title="Contact">Contact</a></li>
					
				</ul>
			</nav>
			<!-- //Main Nav -->
		</div>
	</header>
	<!-- //Header -->
	
	<!-- Main -->
	<main class="main" role="main">
		<!-- Search -->
		<div class="advanced-search color" id="booking">
			<div class="wrap">
				<form role="form" action="SearchRideController" method="post">
					<!-- Row -->
					<div class="f-row">
						<div class="form-group datepicker one-third">
							<label for="dep-date">Departure date and time</label>
							<input type="text" name="date" id="dep-date" />
						</div>
						<div class="form-group select one-third">
							<label>Pick up location</label>
							 <input id="origin-input" class="form-control" name="origininput" type="text"
					placeholder="Enter an origin location">
						</div>
						<div class="form-group select one-third">
							<label>Drop off location</label>
							<input id="destination-input" class="form-control" name="destinationinput" type="text"
					placeholder="Enter a destination location">
					<input type="hidden" name="type"
					id="changemode-driving" checked="checked"> <label
					for="changemode-driving"></label>
						</div>
					</div>
					<!-- //Row -->
					
					<!-- Row -->
					<div class="f-row">
					</div>
					<!-- //Row -->
					
					<!-- Row -->
					<div class="f-row">
						<div class="form-group right">
							<button type="submit" class="btn large black">Find a transfer</button>
						</div>
					</div>
					<!--// Row -->
				</form>
			</div>
		</div>
		<!-- //Search -->
		
		<div class="wrap">
			<div class="row">
				<!--- Content -->
				<div class="full-width content">
					<h2>Select transfer type for your DEPARTURE</h2>
					<div class="table-responsive">
<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>Source Address</th>
				<th>Destination Address</th>
				<th>Date/Time</th>
				 <th>Book A Ride</th>
				<th>Contact Driver</th> 
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${SearchResult}" var="searchrides">
		<tr>
		
		<td><c:out value="${searchrides.sourcelocation}"/></td>
		<td><c:out value="${searchrides.destinationlocation}"/></td>
		<td><c:out value="${searchrides.date}"/></td>
		<!-- <th><input type="Submit" class="btn grey medium" value="Book a Ride"></th> -->
		<th><a href="bookpassenger?rideId=${rides.postrideId}"><input  type="Submit" class="btn grey medium" value="Book a Ride"></a></th>
		<th><a href="ride/discussion"><input type="button" class="btn grey medium" value="Contact Driver"></a></th>
		
		</tr></c:forEach>
		
		</tbody>
		</table>
		</div>
				</div>
				<!--- //Content -->
			</div>
		</div>
	</main>
	<!-- //Main -->
	
	<!-- Footer -->
	<footer class="footer black" role="contentinfo">
		<div class="wrap">
			<div class="row">
				<!-- Column -->
				<article class="one-half">
					<h6>About us</h6>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
				</article>
				<!-- //Column -->
				
				<!-- Column -->
				<article class="one-fourth">
					<h6>Need help?</h6>
					<p>Contact us via phone or email:</p>
					<p class="contact-data"><span class="ico phone"></span> +1 555 555 555</p>
					<p class="contact-data"><span class="ico email"></span> <a href="mailto:help@transfers.com">help@transfers.com</a></p>
				</article>
				<!-- //Column -->
				
				<!-- Column -->
				<article class="one-fourth">
					<h6>Follow us</h6>
					<ul class="social">
						<li class="facebook"><a href="#" title="facebook">facebook</a></li>
						<li class="twitter"><a href="#" title="twitter">twitter</a></li>
						<li class="gplus"><a href="#" title="gplus">google plus</a></li>
						<li class="linkedin"><a href="#" title="linkedin">linkedin</a></li>
						<li class="vimeo"><a href="#" title="vimeo">vimeo</a></li>
						<li class="pinterest"><a href="#" title="pinterest">pinterest</a></li>
					</ul>
				</article>
				<!-- //Column -->
			</div>
			
			<div class="copy">
				<p>Copyright 2014, Themeenergy. All rights reserved. </p>
				
				<nav role="navigation" class="foot-nav">
					<ul>
						<li><a href="#" title="Home">Home</a></li>
						<li><a href="#" title="Blog">Blog</a></li>
						<li><a href="#" title="About us">About us</a></li>
						<li><a href="#" title="Contact us">Contact us</a></li>
						<li><a href="#" title="Terms of use">Terms of use</a></li>
						<li><a href="#" title="Help">Help</a></li>
						<li><a href="#" title="For partners">For partners</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</footer>
	<!-- //Footer -->
	
	<!-- Preloader -->
	<div class="preloader">
		<div id="followingBallsG">
			<div id="followingBallsG_1" class="followingBallsG"></div>
			<div id="followingBallsG_2" class="followingBallsG"></div>
			<div id="followingBallsG_3" class="followingBallsG"></div>
			<div id="followingBallsG_4" class="followingBallsG"></div>
		</div>
	</div>
	<!-- //Preloader -->


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="transfers/js/jquery.uniform.min.js"></script>
	<script src="transfers/js/jquery.datetimepicker.js"></script>
	<script src="transfers/js/jquery.slicknav.min.js"></script>
	<script src="transfers/js/wow.min.js"></script>
	<script src="transfers/js/search.js"></script>
	<script src="transfers/js/scripts.js"></script>
	
	<!-- TEMPLATE STYLES -->
	<div id="template-styles">
		<h2>Template Styles <a href="#"><img class="s-s-icon" src="transfers/images/settings.png" alt="Style switcher" /></a></h2>
		<div>
		<h3>Colors</h3>
			<ul class="colors" >
				<li><a href="#" class="beige" title="beige">beige</a></li>
				<li><a href="#" class="dblue" title="dblue">dblue</a></li>
				<li><a href="#" class="dgreen" title="dgreen">dgreen</a></li>
				<li><a href="#" class="grey" title="grey">grey</a></li>
				<li><a href="#" class="lblue" title="lblue">lblue</a></li>
				<li><a href="#" class="lgreen" title="lgreen">lgreen</a></li>
				<li><a href="#" class="lime" title="lime">lime</a></li>
				<li><a href="#" class="orange" title="orange">orange</a></li>
				<li><a href="#" class="peach" title="peach">peach</a></li>
				<li><a href="#" class="pink" title="pink">pink</a></li>
				<li><a href="#" class="purple" title="purple">purple</a></li>
				<li><a href="" class="red" title="red">red</a></li>
				<li><a href="#" class="teal" title="teal">teal</a></li>
				<li><a href="#" class="turquoise" title="turquoise">turquoise</a></li>
				<li><a href="#" class="yellow" title="yellow">yellow</a></li>
			</ul>
		</div>
	</div>
	<script src="transfers/js/styler.js"></script>
</body>
</html>