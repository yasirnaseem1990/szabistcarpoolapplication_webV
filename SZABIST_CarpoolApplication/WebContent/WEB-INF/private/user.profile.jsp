<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="keywords"
	content="Transfers - Private Transport and Car Hire HTML Template" />
<meta name="description"
	content="Transfers - Private Transport and Car Hire HTML Template">
<meta name="author" content="themeenergy.com">

<title>SzabistCarpool - User Profile</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>

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
<link
	href='http://fonts.googleapis.com/css?family=Raleway:400,500,600,700|Montserrat:400,700'
	rel='stylesheet' type='text/css'>
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
			<a href="index-2.html" title="Transfers"><img
				src="transfers/images/transfers.jpg" alt="Transfers" /></a>
		</div>
		<!-- //Logo -->

		<!-- Main Nav -->
		<nav role="navigation" class="main-nav">
		<ul>
			<li><a href="home" title="">Home</a></li>
			<li><a href="offerride" title="Tailor made">Offer a Ride</a></li>
			<li><a
				href="http://localhost:8080/SZABIST_CarpoolApplication/ViewAllRideController">View
					Available Rides</a></li>
			<li><a href="contact.html" title="Contact">Contact</a></li>
		</ul>
		</nav>
		<!-- //Main Nav -->
	</div>
	</header>
	<!-- //Header -->

	<!-- Main -->
	<main class="main" role="main"> <!-- Page info --> <header
		class="site-title color">
	<div class="wrap">
		<div class="container">
			<h1><%=session.getAttribute("UserName")%></h1>
			<nav role="navigation" class="breadcrumbs">
			<ul>
				<li><a href="#" title="Home">Home</a></li>
				<li><a
					href="http://localhost:8080/SZABIST_CarpoolApplication/LogoutController">Logout</a></li>
			</ul>
			</nav>
		</div>
	</div>
	</header> <!-- //Page info -->


	<div class="wrap">
		<div class="row">

			<!--- Sidebar -->
			
			<aside class="one-fourth sidebar left"> <!-- Widget -->
			<div class="widget">
				<ul class="categories">
					<li class="active"><a href="#">Personal Details</a></li>
					<li><a href="#">my Rides</a></li>
					<li><a href="carpoolrequests">Carpool Requests</a></li>
					<li><a href="#">Messages</a></li>
					<li><a href="#">Setting</a></li>
				</ul>
			</div>
			<!-- //Widget --> <!-- Widget -->
			<div class="widget">
				<h4>Why book with us?</h4>
				<div class="textwidget">
					<h5>Reliable and Safe</h5>
					<p>Lorem ipsum dolor sit amet, do eiusmod tempor incididunt
						labore et dolore magna aliqua.</p>
					<h5>No hidden fees</h5>
					<p>Lorem ipsum dolor sit amet, do eiusmod tempor incididunt
						labore et dolore magna aliqua.</p>
					<h5>We’re Always Here</h5>
					<p>Lorem ipsum dolor sit amet, do eiusmod tempor incididunt
						labore et dolore magna aliqua.</p>
				</div>
			</div>
			<!-- //Widget --> <!-- Widget -->
			<div class="widget">
				<h4>Advertisment</h4>
				<a href="#"><img src="transfers/images/uploads/advertisment.jpg"
					alt="" /></a>
			</div>
			<!-- //Widget --> <!-- Widget -->
			<div class="widget">
				<h4>Need help booking?</h4>
				<div class="textwidget">
					<p>Call our customer services team on the number below to speak
						to one of our advisors who will help you with all of your needs.</p>
					<p class="contact-data">
						<span class="ico phone black"></span> +1 555 555 555
					</p>
				</div>
			</div>
			<!-- //Widget --> </aside>
			
			<!--- //Sidebar -->

			<!--- Content -->
			<div class="three-fourth content">
				<!-- Post -->
				<!-- <article class="single hentry">
						<div class="entry-featured">
							<img src="transfers/images/uploads/img2.jpg" alt="" />
						</div>
						<div class="entry-content"> -->
				<div class="table-responsive">

					<table class="table table-bordered">
						<thead>
							<tr>
							 <!-- <th>Requests Id</th> -->
								<th>Name</th>
								<th>Email</th>
								 <th>CNIC#</th> 
								<th>Mobile No</th>
								<th>University Reg#</th>
								<th>Semester</th>
								 <th>Department</th>
								<th>Picture</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${UserProfile}" var="userprofile">
								<tr>
									<%-- <td><c:out value="${requests.requestsId}" /></td>  --%>
									<td><c:out value="${userprofile.name}" /></td>
									<td><c:out value="${userprofile.email}" /></td>
									<td><c:out value="${userprofile.cnicno}" /></td>
									<td><c:out value="${userprofile.mobileno}" /></td>
									<td><c:out value="${userprofile.universityregno}" /></td>
									<td><c:out value="${userprofile.semester}" /></td>
									 <td><c:out value="${userprofile.department}"/></td>
									 <td><img src="ImageFixingController?action=userimage&userId=<c:out value="${userprofile.userid}" />" class="img-thumbnail"></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<!-- 	</div>
					</article>
					//Post -->
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
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed
				diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam
				erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci
				tation nibh euismod tincidunt ut laoreet dolore magna aliquam erat
				volutpat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
				sed diam nonummy.</p>
			</article>
			<!-- //Column -->

			<!-- Column -->
			<article class="one-fourth">
			<h6>Need help?</h6>
			<p>Contact us via phone or email:</p>
			<p class="contact-data">
				<span class="ico phone"></span> +1 555 555 555
			</p>
			<p class="contact-data">
				<span class="ico email"></span> <a href="mailto:help@transfers.com">help@transfers.com</a>
			</p>
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
			<p>Copyright 2014, Themeenergy. All rights reserved.</p>

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
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="transfers/js/jquery.uniform.min.js"></script>
	<script src="transfers/js/jquery.datetimepicker.js"></script>
	<script src="transfers/js/jquery.slicknav.min.js"></script>
	<script src="transfers/js/wow.min.js"></script>
	<script src="transfers/js/search.js"></script>
	<script src="transfers/js/scripts.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>

	<!-- TEMPLATE STYLES -->
	<div id="template-styles">
		<h2>
			Template Styles <a href="#"><img class="s-s-icon"
				src="transfers/images/settings.png" alt="Style switcher" /></a>
		</h2>
		<div>
			<h3>Colors</h3>
			<ul class="colors">
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