<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
  box-sizing: border-box;
}

.column {
  float: left;
  width: 33.33%;
  padding: 5px;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}
.content header{
	color: white;
	width: 100%;
	font-size: 30px;
	font-weight: 500;
	margin: 0 0 20px 0;
	font-family: 'Montserrat',sans-serif;
	background-color: rgb(9, 22, 192, 0.7);
	text-align: center
}

.footer {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  background-color: rgb(9, 22, 192, 0.7);
  color: white;
  text-align: center;
}


</style>
</head>
<body>
<div class="content"> <header> <h2 style="text-align:center"> Movies On Screen </h2></header>
<div class="row">
  <div class="column">
	<img src="C:\Users\thanu\OneDrive\Desktop\kilaadi.jpg"width="300" height="350">
	<div class="movie-info full-width">
	<div class="right">
	<div class="name">kilaadi</div>
	<div class="info">Telugu â€¢ Feb 10 2022 â€¢ 9:30 AM</div></div></div></div>
	
  <div class="column">
    <img src="https://static.toiimg.com/thumb/msid-89482044,width-219,height-317,imgsize-47552/89482044.jpg?w=300" width="300" height="350">
	<div class="movie-info full-width">
	<div class="left">
	<div class="name">DJ Tillu</div>
	<div class="info">Telugu â€¢ Feb 12 2022 â€¢ 9.30 AM</div>
	</div></div></div>
<div class="column">
    <img src="C:\Users\thanu\OneDrive\Desktop\rrr.jpeg" width="300" height="350">
	<div class="movie-info full-width">
	<div class="left">
	<div class="name">RRR</div>
	<div class="info">Telugu â€¢ Mar 25 2022 â€¢ 9:30 AM</div>
	</div></div></div>
	

  </div>
  
<div class="copyright"><i class="footer"><span>Movie Ticket Booking</i></div> </div>

</body>
</html>
