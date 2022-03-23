<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookShow.com</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>Movie List</h2>
			<hr />
			<br /> <br />
			<div class="panel panel-info">
				<div class="panel-heading"></div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>BookingId</th>
							<th>MovieId</th>
							<th>ShowDate</th>
							<th>ShowTime</th>
							<th>SeatNumber</th>
						</tr>

						<!-- loop over and print our customers -->
						<c:forEach var="Bookings" items="${bookings}">
							<tr>							
								<td>${Bookings.bookingId}</td>
								<td>${Bookings.movieId}</td>
								<td>${Bookings.showDate}</td>
								<td>${Bookings.showTime}</td>
								<td>${Bookings.seatNumber}</td>
																
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>

	</div>
</body>
</html>



<!-- <!DOCTYPE html>
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
 -->
