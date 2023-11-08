<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FLIGHT LIST</title>
</head>
<body>

<h2>SEARCH FLIGHTS</h2>
<form action ="findFlights" method = "post">
From : <input type = "text" name = "from"/> <br>
To : <input type = "text" name = "to"/> <br>
Departure Date : <input type = "text" name = "departureDate"/> <br>
 <input type = "submit" value = "SEARCH"/>
</form>

</body>
</html>