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


<title>Home Page</title>

</head>
	<frameset rows="190,*" frameborder="no">
	
	<frameset cols="375,*" frameborder="no">
		<frame src="title.jsp" name="title" scrolling="no">
		<frame src="title1.jsp" name="title1" scrolling="no">
	</frameset>

	<frameset cols="375,*" frameborder="no">
		<frame src="login.jsp" name="login">
		<frame src="frame2.jsp" name="frame2">
	</frameset>

</frameset>
</html>