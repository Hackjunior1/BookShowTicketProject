<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	transition: background-color .5s;
}

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

input[type=text], select {
	
  width: 20%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 20%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
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
		<a href="#">Add Movies</a> 
		<a href="#">Remove Movie</a> 
	
	</div>






<div align="center">
  <form action="">
    <label for="mname">Movie Name</label><br/>
    <input type="text" id="mname" name="moviename" placeholder="Movie Name...">	<br/>
    <label for="language">Language</label><br/>
    <input type="text" id="language" name="language" placeholder="language..."><br/>
    <label for="duration">Duration</label><br/>
    <input type="text" id="duration" name="duration" placeholder="Duration..."><br/>
    <label for="castname">Actor's Names</label><br/>
    <input type="text" id="castname" name="castname" placeholder="Actor's Names..."><br/> 
    
    <div class="upload-btn-wrapper">
  <button class="btn">Upload a file</button>
  <input type="file" name="myfile" />
</div>
    
  <br/>
    <input type="submit" value="Submit">
  </form>
</div>




</body>
</html>
