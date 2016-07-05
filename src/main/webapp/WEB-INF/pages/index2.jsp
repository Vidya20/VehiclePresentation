<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String cssLocation = (String) session.getAttribute("cssLocation");
%>
<head>
<link style="text/css" rel="stylesheet" href=<%=cssLocation %> />

<script type="text/javascript">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<div id="msg">${msg }</div>
	<br>

	<h3 id="user">${requestScope.message}</h3>
	<form>
		<center>
			<input id="logout" type="submit" value="logout" />
		</center>
	</form>


	<div
		style="background: #DA7373; width: 4.6cm; height: 1.5cm; font-size: 0.6cm; text-align: center; margin-left: 0.8cm; margin-top: 3cm;">
		<a href="addvehicle.ren" style="text-decoration: none; color: white;"
			target="frame2">Add Vehicle</a>
	</div>

	<div
		style="background: #DA7373; width: 4.6cm; height: 1.5cm; font-size: 0.6cm; text-align: center; margin-left: 0.8cm; margin-top: 1cm;">
		<a href="bookvehicle.ren" style="text-decoration: none; color: white;"
			target="frame2">Book Vehicle</a>
	</div>

	<div
		style="background: #DA7373; width: 4.6cm; height: 1.5cm; font-size: 0.6cm; text-align: center; margin-left: 0.8cm; margin-top: 1cm;">
		<a href="bookingreport.ren"
			style="text-decoration: none; color: white;" target="frame2">Vehicle
			Report</a>
	</div>
	<br />
	<br />

</body>
</html>