<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta name="keywords" content="Transfers - Private Transport and Car Hire HTML Template" />
	<meta name="description" content="Transfers - Private Transport and Car Hire HTML Template">
	<meta name="author" content="themeenergy.com">
	
	<title>SzabistCarpool - Offer Ride</title>
	
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
	height: 690px;
	width: 330px;
	position: absolute;
	right: 0px;
	padding: 3em 2em;
	margin: 0px -4em 0em;
}
</style>
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
					<li><a href="contact.html" title="Contact">Contact</a></li>
				</ul>
			</nav>
			<!-- //Main Nav -->
		</div>
	</header>
	<!-- //Header -->
	
	<!-- Main -->
	<main class="main" role="main">
		<!-- Page info -->
		<header class="site-title color">
			<div class="wrap">
				<div class="container">
				<h1><%=session.getAttribute("UserName")%></h1>
					<nav role="navigation" class="breadcrumbs">
						<ul>
							<li><a href="index-2.html" title="Home">Home</a></li>
							<li>Offer Ride</li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
		<!-- //Page info -->
		
		<div class="wrap">
			<div class="row">
				<div class="three-fourth">
					<form action="OfferRideController" method="post">
						<header class="f-title color">Ride Information</header>
							<div class="f-row">
							<div class="one-third">
								<label for="ridetitle">Ride Title</label>
                        <input type="text" name="rideTitle" placeholder="Ride Title">
							</div>
							<div class="one-sixth">
								<label for="fair">Fair/km</label>
                        <input type="text" name="fair" placeholder="Enter Your Fair">
							</div>
							<div class="one-half">
								<label for="dep-date">Pick up date and time</label>
								<!-- <input type="text" name="date" placeholder="Pick The Date" id="datetimepicker"> -->
							 <input type="text" name="date" id="dep-date" />
							</div>
						</div>
						<div class="f-row">
							<div class="one-half">
								<label for="pickuploc">Pick up location</label>
								<input id="origin-input" name="origininput" type="text" placeholder="Enter an origin location">
							</div>
							<div class="one-half">
								<label for="dropoffloc">Drop off location</label>
								<input id="destination-input" name="destinationinput" type="text" placeholder="Enter a destination location">
								 <input type="hidden" name="type" id="changemode-driving" checked="checked"> <label for="changemode-driving"></label>
							</div>
						</div>
						<div class="f-row">
						<div class="one-sixth">
								 <label for="totalseast">Total Seats</label>
                       <input type="text" name="totalseats" placeholder="Total Seats">
							</div>
							<div class="one-sixth">
								<label for="availableseats">Available Seats</label>
                        <input type="text" name="availableseats" placeholder="Available Seats">
							</div>
							<div class="one-sixth">
								<label for="carname">Car Name</label>
                      <input type="text" name="carname" placeholder="Car Name">
							</div>
							<div class="one-half">
								<label for="carmodel">Car Model</label>
                       <input type="text" name="carmodel" placeholder="Car Model">
							</div>
						</div>
						<div class="f-row">
							<div class="full-width">
								<label for="extras">Additional information</label>
								<textarea name="description" placeholder="Description" id="extras"></textarea>
							</div>
						</div>
						
						<div class="actions">
						<button type="submit" class="btn medium color right">POST A RIDE</button>
						</div>
					</form>
				</div>
				
				<!--- Sidebar -->
				<aside class="one-fourth sidebar right">
					<!-- Widget -->
				<div class="widget">
						<div id="map"></div>
					</div>
				</aside>
				<!--- //Sidebar -->
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
<!-- <script type="text/javascript">
		jQuery('#datetimepicker').datetimepicker();
	</script> -->
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
				<li><a href="#" class="red" title="red">red</a></li>
				<li><a href="#" class="teal" title="teal">teal</a></li>
				<li><a href="#" class="turquoise" title="turquoise">turquoise</a></li>
				<li><a href="#" class="yellow" title="yellow">yellow</a></li>
			</ul>
		</div>
	</div>
	<script src="transfers/js/styler.js"></script>
</body>
</html>