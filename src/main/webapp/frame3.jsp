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
<title>Insert title here</title>
</head>
<body bgcolor="maroon">
	<h3>Click the following links:</h3>
	<a href="http://www.roseindia.net/java">Core Java</a>
	<br>
	<a href="http://www.roseindia.net/jsp">JSP</a>
	<br>
	<a href="http://www.roseindia.net/servlets/index.shtml">Java
		Servlets</a>
	<br>
	<a href="http://www.roseindia.net/jdbc">JDBC</a>
	<br>
	<a href="http://www.roseindia.net/hibernate">Hibernate</a>
	<br>
</body>
</html>