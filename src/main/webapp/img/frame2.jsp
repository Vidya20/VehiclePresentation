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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Frame2 Page</title>
</head>
<body>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />



	<span
		style="margin-top: 15cm; color: visitedhyperlinktext; font: normal; font-size: large; font-family: serif">
		This application allows you to book a vehicle.<br /> <br /> The
		categories of vehicle available are:<br /> --car<br /> --bus<br />
		--truck<br /> <br /> It also allows you to check the temperature of
		the selected city. <br /> <br /> <br />
	</span>

	<marquee
		style="margin-top: 300px; color: maroon; font-size: x-large; font-family: monospace; font-style: oblique; font-weight: bolder">Contact
		us at abc@mindtree.com; Phone No.: 1234567891</marquee>


</body>
</html>