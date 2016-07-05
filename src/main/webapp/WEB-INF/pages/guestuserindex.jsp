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
	function changeframes() {
		javascript: parent.frame2.location = 'frame2.jsp';
		javascript: parent.login.location = 'login.jsp';
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="leftside_panel">
	<h3 id="user" style="color: purple">${requestScope.message}</h3>
	<input type="button" value="Home" id="home_btn"
		onclick="changeframes()" />


	<a href="bookvehicle.ren" target="frame2" id="book_link">Book
		Vehicle</a>
</body>
</html>