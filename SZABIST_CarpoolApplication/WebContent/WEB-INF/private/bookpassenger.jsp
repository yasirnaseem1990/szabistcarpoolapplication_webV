<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Passenger</title>

	<!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
       
	<!-- End of CSS -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(window).load(function(){
    $('#myModal').modal('show')});
</script>

 <script type="text/javascript">
function randomPin(){
	var t= prompt("Enter Your Pin No","");
	alert("THis is value"+t);
}
</script>

<style>
#map {
	height: 560px;
	width: 1295px;
	position: absolute;
	right: 0px;
	padding: 3em 2em;
	margin: 30px 3em 12em;
}
</style>
</head>
<body>
  <div id="map"></div>
<!-- Modal -->
<div  id="myModal" class = "modal fade" id = "myModal" tabindex = "-1" role = "dialog" 
   aria-labelledby = "myModalLabel" aria-hidden = "true">
   
   <div class = "modal-dialog">
      <div class = "modal-content">
         
         <div class = "modal-header">
            <h4 class="modal-title" id="exampleModalLabel">Passenger Details</h4>
      </div>
      <div class="modal-body">
       <% String id = request.getParameter("rideId"); %>
			 <form action="BookPassengerController" method="post">
          <div class="form-group">
          <input type="hidden" name="rideId" value="<%=id%>" />
            <label for="recipient-name" class="control-label">Pick Up Location:</label>
             <input type="text" id="origin-input" class="form-control" name="picklocation" placeholder="Enter an Pick Up Location">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">Other Comments</label>
            <input type="text" name="oc" class="form-control" placeholder="Other Comments">
            
          </div>
          <div class="form-group">
          <input type="hidden" id="destination-input" class="form-control" name="destinationinput" type="text"
					placeholder="Enter a destination location">
          </div>
          
          <input type="hidden" id="destination-input" class="form-control" name="destinationinput" type="text"
					placeholder="Enter a destination location">
           <input type="hidden" name="type"
					id="changemode-driving" checked="checked"> <label
					for="changemode-driving"></label>
          <div class="modal-footer">
        
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
      
        
         
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
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
</body>
</html>