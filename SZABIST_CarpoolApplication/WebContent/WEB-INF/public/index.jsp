<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
   <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta name="keywords" content="Transfers - Private Transport and Car Hire HTML Template" />
	<meta name="description" content="Transfers - Private Transport and Car Hire HTML Template">
	<meta name="author" content="themeenergy.com">
	
	<title>SzabistCarpool - Home</title>
	
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
    <style>
#map {
	height: 147px;
	width: 1348px;
	position: relative;
	right: 0px;
	padding: 15em 2em;
	margin: -68px 0em -2em;
}
</style>
  </head>
  
  <body class="home">
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
						<li class="active"><a href="#" title="">Home</a></li>
						<li><a href="#">SignUp/SignIn</a>
							<ul>
								<li><a href="register">SingUp</a></li>
								<li><a href="login">SignIn</a></li>
							</ul>
						</li>
						<li><a href="tailor-made.html" title="Tailor made">Tailor made</a></li>
						<li><a href="http://localhost:8080/SZABIST_CarpoolApplication/ViewAllRideController">View Available Rides</a></li>
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
		<!-- Intro -->
		<div class="intro">
			<div class="wrap">
				<div class="textwidget">
					<h1 class="wow fadeInDown">Need a ride?</h1>
					<h2 class="wow fadeInUp">You've come to the right place.</h2>
					<div class="actions">
						<a href="#services" title="Our services" class="btn large white wow fadeInLeft anchor">Our services</a>
						<a href="#booking" title="Make a booking" class="btn large color wow fadeInRight anchor">Make a booking</a>
					</div>
				</div>
			</div>
		</div>
		<!-- //Intro -->
		
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
		
		<!-- Services iconic -->
		<div class="services iconic white">
		<div id="map"></div>
		</div>
		<!-- //Services iconic -->
		
		<!-- Call to action -->
		<div class="black cta">
			<div class="wrap">
				<p class="wow fadeInLeft">Like what you see? Are you ready to stand out? You know what to do.</p>
			</div>
		</div>
		<!-- //Call to action -->
		
		<!-- Services -->
		<div class="services boxed white" id="services">
			<!-- Item -->
			<article class="one-fourth wow fadeIn">
				<figure class="featured-image">
					<img src="transfers/images/uploads/img.jpg" alt="" />
					<div class="overlay">
						<a href="services.html" class="expand">+</a>
					</div>
				</figure>
				<div class="details">
					<h4><a href="services.html">Private transfers</a></h4>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
					<a class="more" title="Read more" href="services.html">Read more</a>
				</div>
			</article>
			<!-- //Item -->
			
			<!-- Item -->
			<article class="one-fourth wow fadeIn" data-wow-delay=".2s">
				<figure class="featured-image">
					<img src="transfers/images/uploads/img4.jpg" alt="" />
					<div class="overlay">
						<a href="services.html" class="expand">+</a>
					</div>
				</figure>
				<div class="details">
					<h4><a href="services.html">Bus transfers</a></h4>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
					<a class="more" title="Read more" href="services.html">Read more</a>
				</div>
			</article>
			<!-- //Item -->
			
			<!-- Item -->
			<article class="one-fourth wow fadeIn" data-wow-delay=".4s">
				<figure class="featured-image">
					<img src="transfers/images/uploads/img2.jpg" alt="" />
					<div class="overlay">
						<a href="services.html" class="expand">+</a>
					</div>
				</figure>
				<div class="details">
					<h4><a href="services.html">Shuttle transfers</a></h4>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
					<a class="more" title="Read more" href="services.html">Read more</a>
				</div>
			</article>
			<!-- //Item -->
			
			<!-- Item -->
			<article class="one-fourth wow fadeIn" data-wow-delay=".6s">
				<figure class="featured-image">
					<img src="transfers/images/uploads/img3.jpg" alt="" />
					<div class="overlay">
						<a href="services.html" class="expand">+</a>
					</div>
				</figure>
				<div class="details">
					<h4><a href="services.html">Helicopter transfers</a></h4>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
					<a class="more" title="Read more" href="services.html">Read more</a>
				</div>
			</article>
			<!-- //Item -->			
		</div>
		<!-- //Services -->
		
		<!-- Testimonials -->
		<div class="testimonials center black">
			<div class="wrap">
				<h6 class="wow fadeInDown">Wow, this theme is outstanding!</h6>
				<p class="wow fadeInUp">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
				<p class="meta wow fadeInUp">-John Doe, themeforest</p>
			</div>
		</div>
		<!-- //Testimonials -->
		
		<div class="partners white center">
			<div class="wrap">
				<h2 class="wow fadeIn">Our partners</h2>
				<div class="one-fifth wow fadeIn"><a href="#"><img src="images/uploads/logo1.jpg" alt="" /></a></div>
				<div class="one-fifth wow fadeIn" data-wow-delay=".2s"><a href="#"><img src="images/uploads/logo2.jpg" alt="" /></a></div>
				<div class="one-fifth wow fadeIn" data-wow-delay=".4s"><a href="#"><img src="images/uploads/logo3.jpg" alt="" /></a></div>
				<div class="one-fifth wow fadeIn" data-wow-delay=".6s"><a href="#"><img src="images/uploads/logo4.jpg" alt="" /></a></div>
				<div class="one-fifth" data-wow-delay=".8s"><a href="#"><img src="images/uploads/logo5.jpg" alt="" /></a></div>
			</div>
		</div>
		
		
		<!-- Call to action -->
		<div class="color cta">
			<div class="wrap">
				<p class="wow fadeInLeft">Like what you see? Are you ready to stand out? You know what to do.</p>
				<a href="#" class="btn huge black right wow fadeInRight">Purchase theme</a>
			</div>
		</div>
		<!-- //Call to action -->
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
	
	 <!-- jQuery -->
	 <script>
		function initMap() {

			var origin_place_id = null;
			var destination_place_id = null;
			var travel_mode = google.maps.TravelMode.WALKING;
			var map = new google.maps.Map(document.getElementById('map'), {
				mapTypeControl : false,
				center : {
					lat : 33.7167,
					lng : 73.0667
				},
				zoom : 12
			});
			var directionsService = new google.maps.DirectionsService;
			var directionsDisplay = new google.maps.DirectionsRenderer;
			directionsDisplay.setMap(map);

			var origin_input = document.getElementById('origin-input');
			var destination_input = document
					.getElementById('destination-input');
			var modes = document.getElementById('mode-selector');

			/* map.controls[google.maps.ControlPosition.TOP_LEFT].push(origin_input);
			map.controls[google.maps.ControlPosition.TOP_LEFT].push(destination_input);
			map.controls[google.maps.ControlPosition.TOP_LEFT].push(modes); */

			var origin_autocomplete = new google.maps.places.Autocomplete(
					origin_input);
			origin_autocomplete.bindTo('bounds', map);
			var destination_autocomplete = new google.maps.places.Autocomplete(
					destination_input);
			destination_autocomplete.bindTo('bounds', map);

			// Sets a listener on a radio button to change the filter type on Places
			// Autocomplete.
			function setupClickListener(id, mode) {
				var radioButton = document.getElementById(id);
				radioButton.addEventListener('click', function() {
					travel_mode = mode;
				});
			}
			/* setupClickListener('changemode-walking',
					google.maps.TravelMode.WALKING);
			setupClickListener('changemode-transit',
					google.maps.TravelMode.TRANSIT); */
			setupClickListener('changemode-driving',
					google.maps.TravelMode.DRIVING);

			function expandViewportToFitPlace(map, place) {
				if (place.geometry.viewport) {
					map.fitBounds(place.geometry.viewport);
				} else {
					map.setCenter(place.geometry.location);
					map.setZoom(17);
				}
			}

			origin_autocomplete
					.addListener(
							'place_changed',
							function() {
								var place = origin_autocomplete.getPlace();
								if (!place.geometry) {
									window
											.alert("Autocomplete's returned place contains no geometry");
									return;
								}
								expandViewportToFitPlace(map, place);

								// If the place has a geometry, store its place ID and route if we have
								// the other place ID
								origin_place_id = place.place_id;
								route(origin_place_id, destination_place_id,
										travel_mode, directionsService,
										directionsDisplay);
							});

			destination_autocomplete
					.addListener(
							'place_changed',
							function() {
								var place = destination_autocomplete.getPlace();
								if (!place.geometry) {
									window
											.alert("Autocomplete's returned place contains no geometry");
									return;
								}
								expandViewportToFitPlace(map, place);

								// If the place has a geometry, store its place ID and route if we have
								// the other place ID
								destination_place_id = place.place_id;
								route(origin_place_id, destination_place_id,
										travel_mode, directionsService,
										directionsDisplay);
							});

			function route(origin_place_id, destination_place_id, travel_mode,
					directionsService, directionsDisplay) {
				if (!origin_place_id || !destination_place_id) {
					return;
				}
				directionsService.route({
					origin : {
						'placeId' : origin_place_id
					},
					destination : {
						'placeId' : destination_place_id
					},
					travelMode : travel_mode
				}, function(response, status) {
					if (status === google.maps.DirectionsStatus.OK) {
						directionsDisplay.setDirections(response);
					} else {
						window.alert('Directions request failed due to '
								+ status);
					}
				});
			}
		}
	</script>
	<script>
		
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDxSgxV4Ckf9fSj1LPX4-xyKwBuzYgEVmc&signed_in=true&libraries=places&callback=initMap"
		async defer></script>
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