<!DOCTYPE html>
<html>
<head>
<title>Book show.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	transition: background-color .5s;
}
/* <!-- Top nav bar styles -- */
.navbar {
	width: 100%;
	background-color: orange;
	overflow: auto;
}

.navbar a {
	float: right;
	padding: 20px;
	color: white;
	text-decoration: none;
	font-size: 17px;
}

.navbar a:hover {
	background-color: silver;
}

/* <!-- side nav bar styles -- */
.sidenav {
	height: 100%;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: orange;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
}

.sidenav a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: white;
	display: block;
	transition: 0.3s;
}

.sidenav a:hover {
	background-color: silver;
}

.sidenav .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
	margin-left: 50px;
}

#main {
	transition: margin-left .5s;
	padding: 16px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}

/* for input form for adding the details of an image class=addform*/
.form-group input[type=text], select {
	width: 20%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.form-group input[type=submit] {
	width: 20%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.form-group input[type=submit]:hover {
	background-color: #45a049;
}

/*image button css*/
.choose_file {
	position: relative;
	display: inline-block;
	border-radius: 8px;
	border: #ebebeb solid 1px;
	width: 250px;
	height: 25px;
	padding: 8px 6px 4px 8px; /* padding values= top right bottom left.*/
	font : normal 14px Myriad Pro, Verdana, Geneva, sans-serif; color :
	white;
	margin-top: 2px;
	background: green;
	font: normal 14px Myriad Pro, Verdana, Geneva, sans-serif;
	color: white;
	cursor: pointer;
}

.choose_file input[type="file"] {
	-webkit-appearance: none;
	position: absolute;
	top: 0;
	left: 0;
	opacity: 0;
	cursor: pointer;
}
</style>

<script>
	function openNav() {
		document.getElementById("mySidenav").style.width = "250px";
		document.getElementById("main").style.marginLeft = "250px";
	}

	function closeNav() {
		document.getElementById("mySidenav").style.width = "0";
		document.getElementById("main").style.marginLeft = "0";
	}
</script>


</head>

<body>

	<div class="navbar">
		<a href="#"><i class="fa fa-fw fa-user"></i> Signout</a> <a
			class="active" href="#"><i class="fa fa-fw fa-home"></i> My
			Account</a>
		<div id="main">
			<span style="font-size: 30px; cursor: pointer" onclick="openNav()">&#9776;</span>
		</div>
	</div>
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="#">Add Movies</a> <a href="#">Remove Movie</a>

	</div>
	
	<div align="center">
		<form:form modelAttribute="movieDto" method="POST" action="saveMovie">
			<!-- need to associate this data with customer id 
			-->
			<div class="form-group">
				<label class="col-md-3 control-label">Movie Name</label>
				<div class="">
					<form:input path="movie.name" placeholder="Movie Name..." />
				</div>
			 </div>
			<div class="form-group">
				<label class="col-md-3 control-label">Duration</label>
				<div class="">
					<form:input path="movie.duration" placeholder="Movie Duration..." />
				</div>
			</div>
			<div class="form-group">
				<label for="" class="col-md-3 control-label">Actor's Names</label>
				<div class="">
					<form:input path="movie.cast_names" placeholder="Actor's Names..." />
				</div>
			</div>
			<div class="form-group">
				<label for="" class="col-md-3 control-label">Movie Start
					Date</label>
				<div class="">
					<form:input path="movie.MovieStartDate"	placeholder="Enter show starting date" />
				</div>
			</div>
			<div class="form-group">
				<label for="" class="col-md-3 control-label">Movie End Date</label>
				<div class="">
					<form:input path="movie.MovieEndDate" placeholder="Enter show End date" />
				</div>
			</div>

			<div class="form-group">
				<label for="" class="col-md-3 control-label">Ticket Price</label>
				<div class="">
					<form:input path="movie.price" placeholder="Enter Ticket Price" />
				</div>
			</div>
			
				
					<div class="form-group">
						<label class="col-md-3 control-label">Language</label>
						<div class="">
							<form:input path="showmovie.language" placeholder="Movie Language..." />
						</div>
					</div>

					<div class="form-group">
						<label for="" class="col-md-3 control-label">Show Time</label>
						<div class="">
							<form:input path="showmovie.Show_Time" placeholder="Enter Show Timing" />
						</div>
					</div>

					<div class="form-group">
						<label for="" class="col-md-3 control-label">Show Start
							Time</label>
						<div class="">
							<form:input path="showmovie.Start_Time" placeholder="Enter Show Start Time" />
						</div>
					</div>
				 


			<div class="choose_file">
				<span>Select Image </span> 
				<input name="Select File" type="file" path="movie.image" />
			</div>

			<div class="form-group">
				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<%-- <form:button cssClass="btn btn-primary">Submit</form:button> --%>
					<input type="submit" value="submit"/>
				</div>
			</div>
		</form:form>
	</div>

	
	
	</body>
</html>
