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
	
	<title>SzabistCarpool - Register</title>
	
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
<script type="text/javascript">
function check_fields(){
	var name = document.getElementById('name').value;
	var email = document.getElementById('email').value;
	var password = document.getElementById('password').value;
	var cnicno = document.getElementById('cnicno').value;
	var mobileno = document.getElementById('mobileno').value;
	var uniregno = document.getElementById('uniregno').value;
	var semester = document.getElementById('currentsemester').value;
	var dept = document.getElementById('department').value;
	var userPicture = document.getElementById('userPicture').value;
	if(name=="" || email=="" || password=="" || cnicno== "" || mobileno== "" || uniregno== "" || semester=="" 
			|| dept=="" || userPicture==""){
		alert('Fill The Missing Fields');
		return false;
	}
	else{
		return true;
	}
}
</script>
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
					<h1>Register</h1>
					<nav role="navigation" class="breadcrumbs">
						<ul>
							<li><a href="#" title="Home">Home</a></li>
							<li>Register</li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
		<!-- //Page info -->
		
		<div class="wrap">
			<div class="row">
				<!--- Content -->
				<div class="content one-half modal">
					<!--Login-->
					<div class="box">
						<form action="RegisterController" enctype="multipart/form-data" method="post" onsubmit="return check_fields();">
							<div class="f-row">
								<div class="full-width">
									<label for="name">Your Name</label>
									<input type="text" name="name" id="name" />
								</div>
							</div>
							<div class="f-row">
								<div class="full-width">
									<label for="email">Your email address</label>
									<input type="email" name="email" id="email" />
								</div>
							</div>
							<div class="f-row">
								<div class="full-width">
									<label for="password">Your password</label>
									<input type="password" name="password" id="password" />
								</div>
							</div>
							<div class="f-row">
								<div class="full-width">
									<label for="cnic">Your CNIC#</label>
									<input type="text" name="cnic" id="cnicno" />
								</div>
							</div>
							<div class="f-row">
								<div class="full-width">
									<label for="mobileno">Your Mobile No</label>
									<input type="text" name="mobileno" id="mobileno" />
								</div>
							</div>
							<div class="f-row">
								<div class="full-width">
									<label for="universityregno">Your University Registration No</label>
									<input type="text" name="universityregno" id="uniregno" />
								</div>
							</div>
							<div class="f-row">
								<div class="full-width">
									<label for="semester">Your Current Semester</label>
									<input type="text" name="semester" id="currentsemester" />
								</div>
							</div>
							<div class="f-row">
								<div class="full-width">
									<label for="department">Your Department</label>
									<input type="text" name="department" id="department" />
								</div>
							</div>
							<div class="f-row">
								<div class="full-width">
									<label for="userpicture">Upload Your Picture</label>
									<input type="file" name="userPicture" id="userPicture" />
								</div>
							</div>
							<div class="f-row">
								<div class="full-width check">
									<input type="checkbox" id="checkbox" />
									<label for="checkbox">I agree with terms and conditions.</label>
								</div>
							</div>
							<div class="f-row">
								<div class="full-width">
									<input type="submit" value="Create an account" class="btn color medium full" />
								</div>
							</div>
							
							<p>Already have an account? <a href="login">Login</a>.</p>
						</form>
					</div>
					<!--//Login-->
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
					<p class="contact-data"><span class="ico phone"></span> +92 302 524 1994</p>
					<p class="contact-data"><span class="ico email"></span> yasirnaseem1990@icloud.com</p>
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
					</ul>
				</article>
				<!-- //Column -->
			</div>
			
			<div class="copy">
				<p>Copyright 2014, Yasir Naseem. All rights reserved.</p>
				
				<nav role="navigation" class="foot-nav">
					<ul>
						<li><a href="#" title="About us">About us</a></li>
						<li><a href="#" title="Contact us">Contact us</a></li>
					
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