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
/* <!-- Top nav bar styles --> */
.navbar {
	width: 100%;
	background-color: orange;
	overflow: auto;
}

.navbar a {
	float: right;
	padding: 12px;
	color: white;
	text-decoration: none;
	font-size: 17px;
}

.navbar a:hover {
	background-color: silver;
}

/* <!-- side nav bar styles --> */
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
.upload-btn-wrapper {
	position: relative;
	overflow: hidden;
	display: inline-block;

}

.btn {
	border: 2px solid gray;
	color: white;
	background-color: #45a049;
	padding: 8px 20px;
	border-radius: 8px;
	font-size: 20px;
	font-weight: bold;
	
}

.upload-btn-wrapper input[type=file] {
	font-size: 100px;
	position: absolute;
	left: 0;
	top: 0;
	opacity: 0;
	cursor: pointer;
	
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
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
		<form:form modelAttribute="movie" method="POST" action="saveMovie">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />

			<div class="form-group">
				<label class="col-md-3 control-label">Movie Name</label>
				<div class="">
					<form:input path="name" placeholder="Movie Name..." />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-3 control-label">Language</label>
				<div class="">
					<form:input path="Language" placeholder="Movie Language..." />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-3 control-label">Duration</label>
				<div class="">
					<form:input path="duration" placeholder="Movie Duration..." />
				</div>
			</div>

			<div class="form-group">
				<label for="" class="col-md-3 control-label">Actor's Names</label>
				<div class="">
					<form:input path="cast_names" placeholder="Actor's Names..." />
				</div>
			</div>

			<div class="form-group">
				<label for="" class="col-md-3 control-label">Movie Start Date</label>
				<div class="">
					<form:input path="MovieStartDate" placeholder="Enter show starting date"/>
				</div>
			</div>
			<div class="form-group">
				<label for="" class="col-md-3 control-label">Movie End Date</label>
				<div class="">
					<form:input path="MovieEndDate" placeholder="Enter show End date"/>
				</div>
			</div>

		

			<div class="upload-btn-wrapper">
				<form:button class="btn">upload Image</form:button>

				<form:input type="file" path="image"  />
			</div>

			<div class="form-group">
				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btn-primary">Submit</form:button>
				</div>
			</div>

			<%-- <label for="name">Movie Name</label>
			<br />
			<!-- <input type="text" name="moviename" placeholder="Movie Name..." path="name"> -->
			<form:input path="name"  placeholder="Movie Name..."/>
			<br />
			<label for="Language">Language</label>
			<br />
			<!-- <input type="text" id="language" name="language" placeholder="language..." path="language"> -->
			<form:input path="Language"  placeholder="Movie Language..."/>
			<br />
			<label for="duration">Duration</label>
			<br />
			<!-- <input type="text" id="duration" name="duration" placeholder="Duration..." path="duration"> -->
			<form:input path="duration"  placeholder="Movie Duration..."/>
			<br />
			<label for="cast_names">Actor's Names</label>		<br />
			<!-- <input type="text" id="castname" name="castname" placeholder="Actor's Names..." path="castname"> -->
			<form:input path="cast_names"  placeholder="Actor's Names..."/>
			<br />

			<div class="upload-btn-wrapper">
				<form:button class="btn">upload Image</form:button>
			<%-- 	<form:input type="file" name="Image" /> --%
				<form:input type="file" path="image"  placeholder="image"/>
			</div>

			<br />
			<input type="submit" value="Submit">--%>

		</form:form>


	</div>




</body>
</html>
