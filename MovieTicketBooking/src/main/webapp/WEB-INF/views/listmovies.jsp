<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>javaguides.net</title>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>Movies</h2>
   <hr />

   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title"></div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered" border="1">
      <tr>
       <th>Image</th>
       <th>Movie Name</th>
       <th>Language</th>
       <th>Duration</th>
       <th>Actors</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempmovies" items="${movies}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/movie/updateMovie">
        <c:param name="movieId" value="${tempmovies.id}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/movie/delete">
        <c:param name="movieId" value="${tempmovies.id}" />
       </c:url>

       <tr>
        <td>${tempmovies.image}</td> 
        <td>${tempmovies.name}</td>  
        <td>${tempmovies.Language}</td> 
		<td>${tempmovies.duration}</td> 
		<td>${tempmovies.cast_names}</td>   
        <td>
         <!-- display the update link --> 
         <a href="${updateLink}">Update</a>
         |<a href="${deleteLink}"onclick="if (!(confirm('Are you sure you want to delete this Movie?'))) return false">Delete</a>
        </td>

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
<body>
<div class="content"> <header> <h2 style="text-align:center"> Movies On Screen </h2></header>
<div class="row">
  <div class="column">
	<img src="C:\Users\svenkateswarlu\git\repository\MovieTicketBooking\src\main\webapp\resources\img\movies\robot-2-2018.jpg"width="300" height="350">
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
    <img src="C:\Users\svenkateswarlu\git\repository\MovieTicketBooking\src\main\webapp\resources\img\movies\baa-baaa-black-sheep-2018.jpg" width="300" height="350">
	<div class="movie-info full-width">
	<div class="left">
	<div class="name">RRR</div>
	<div class="info">Telugu â€¢ Mar 25 2022 â€¢ 9:30 AM</div>
	</div></div></div>
	

  </div>
  
<div class="copyright"><i class="footer"><span>Movie Ticket Booking</i></div> </div>

</body>
</html>
 -->