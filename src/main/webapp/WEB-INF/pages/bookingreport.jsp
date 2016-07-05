<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<%
	String cssLocation = (String) session.getAttribute("cssLocation");
%>
<head>
<link style="text/css" rel="stylesheet" href=<%=cssLocation %> />
</head>

<body>
	<center>
		<div id="reporthead">
			<h2>Vehicle Report</h2>
		</div>
		<table id="report">
			<tr>
				<th>Type of vehicle</th>
				<th>Number of vehicles present</th>
				<th>Number of times rented</th>
				<th>Total rent earned</th>
			</tr>

			<c:forEach items="${requestScope.report}" var="reportObj">
				<tr>
					<td>${reportObj.cat}</td>
					<td>${reportObj.totalVeh}</td>
					<td>${reportObj.totalRented}</td>
					<td>${reportObj.totalEarned}</td>

				</tr>

			</c:forEach>
		</table>


	</center>

</body>
</html>

