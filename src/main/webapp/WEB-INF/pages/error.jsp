<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
<html>
<%
	String cssLocation = (String) session.getAttribute("cssLocation");
%>
<head>
<link style="text/css" rel="stylesheet" href=<%=cssLocation %> />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Error Page</title>
</head>
<body>
	<br>
	<h3>Improper Operation.</h3>

	<h3>Try Booking Again</h3>
</body>
</html>