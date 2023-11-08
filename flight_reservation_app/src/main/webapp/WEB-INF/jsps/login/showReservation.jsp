<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESERVATION DETAILS</title>
</head>
<body>
<table border = "1">
<tr>
	
	<th>FROM</th>
	<th>TO</th>
	<th>AIRLINE</th>
	<th>FLIGHT_NUMBER</th>
	<th>DATE_OF_DEPARTURE</th>
	<th>ESTIMATED_TIME</th>
</tr>


 <tr>
 
 	<td>${flight.departureCity}</td>
 	<td>${flight.arrivalCity}</td>
 	<td>${flight.operatingAirlines}</td>
 	<td>${flight.flightNumber}</td>
 	<td>${flight.dateOfDeparture}</td>
 	<td>${flight.estimatedDepartureTime}</td>
 	
 </tr>
 
	
</table>

<h2>Enter The Passenger Details</h2>
<form action = "confirmReservation" method = "post">
<pre>
First Name : <input type = "text" name = "firstName"/>
Last Name : <input type = "text" name = "lastName"/>
Middle Name : <input type = "text" name = "middleName"/>
Email : <input type = "text" name = "email"/>
Phone : <input type = "number" name = "phone"/>
<input type = "hidden" value = "${flight.id}" name = "flightId"/>

<h2>ENTER THE PAYMENT DETAILS</h2>
Name on the Card: <input type = "text" name = "NameOnTheCard"/>
Card Number : <input type = "text" name = "cardNumber"/>
CVV : <input type = "text" name = "cvv"/>
Expiry Date : <input type = "text" name = "expiryDate"/>
<input type = "submit" value = "RESERVE"/>
</pre>
</form>


</body>
</html>