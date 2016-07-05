<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%
	String cssLocation = (String) session.getAttribute("cssLocation");
String datepickercsslocation=(String) session.getAttribute("datepickercsslocation");
%>
<head>
<link style="text/css" rel="stylesheet" href=<%=cssLocation %> />
 <link rel="stylesheet" type="text/css" media="all"
	href=<%=datepickercsslocation %> /> 
 <script type="text/javascript" src="js/jsDatePick.min.1.3.js"></script>




<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" type="text/javascript">
<!--
	var xhr = new XMLHttpRequest();

	function sendRequest(city) {

		document.getElementById("weather").innerHTML = "<img src='img/loading_image.gif' style=margin-left:2cm;margin-top:1cm;></img>";
		var option = city.options[city.selectedIndex].value;

		var url = "getWeather.ren?city=" + option;

		xhr.open("GET", url, true);

		xhr.onreadystatechange = handleResponse;
		xhr.send(null);

	}

	function handleResponse() {

		if (xhr.readyState == 4 && xhr.status == 200) {

			document.getElementById("weather").innerHTML = xhr.responseText;
		}
	}

	function populateVehicles(frm) {
		frm.action = "populateVehicles.ren";
		frm.submit();
	}

	function computeRent(frm) {
		frm.action = "getTotalRent.ren";
		frm.method = "GET";
		frm.submit();
	}

	window.onload = function() {

		new JsDatePick({
			useMode : 2,
			target : "book_todate_value",
			dateFormat : "%d-%m-%Y"
		});
		new JsDatePick({
			useMode : 2,
			target : "book_frmdate_value",
			dateFormat : "%d-%m-%Y"
		});
	};
</script>


</head>
<body>



	<div id="weather"
		style="margin-left: 17cm; position: absolute; left: 0; right: 10; margin-bottom: 10cm;">
	</div>

	<div id="vehicle_head">
		<h2>Book Vehicle</h2>
	</div>
	<form:form action="persistbooking.ren" commandName="booking">
		<h4>
			<label class="label" id="user_name">Place</label>

			<form:select path="place" onchange="sendRequest(this)"
				cssClass="inputbox" id="book_place_value">
				<form:option value="select" label="Select" />
				<form:option value="Bangalore" label="Bangalore" />
				<form:option value="Belgaum" label="Belgaum" />
				<form:option value="Gulbarga" label="Gulbarga" />
				<form:option value="Bijapur" label="Bijapur" />
				<form:option value="Mumbai" label="Mumbai" />
				<form:option value="Delhi" label="Delhi" />
				<form:option value="Hyderabad" label="Hyderabad" />
			</form:select>
		
		<form:errors path="place" cssClass="book_place_error" id="book_place_error" ></form:errors>
         </h4>

		<h4>
			<label class="label" id="user_name">Customer Name:</label>
			<form:input path="custName" size="20" cssClass="inputbox"
				id="book_cname_value" />
		
		<form:errors path="custName" cssClass="book_name_error"></form:errors>
         </h4>
         
		<h4>
			<label class="label" id="user_name">Email:</label>
			<form:input path="emailId" size="20" cssClass="inputbox"
				id="book_email_value" />
			<label class="label">(Eg.abc@xyz.com)</label>
	
		<form:errors path="emailId" cssClass="book_email_error"></form:errors>
         	</h4>

		<h4>
			<label class="label" id="user_name">Category:</label>
			<form:select path="category" onchange="populateVehicles(this.form)"
				items="${category}" cssClass="inputbox" id="book_cat_value" />
		
		<form:errors path="category" cssClass="book_category_error"></form:errors>
		<div id="catErr" class="book_errormessage"></div>
 		</h4>
		<h4>
			<label class="label" id="user_name">Registration No.:</label>

			<form:select path="vehicle.regNo" cssClass="inputbox"
				id="book_reg_value">
				<form:option value="select" id="book_reg_value">--select--</form:option>
				<form:options items="${vehicleList}" />
			</form:select>
		</h4>

		<h4>
			<label class="label" id="user_name">From Date:</label>
			<form:input path="bookedFrom" size="20" cssClass="inputbox" 
				id="book_frmdate_value" readonly="true"  />
			<label class="label"></label>
		
		<form:errors path="bookedFrom" cssClass="book_date_error"></form:errors>
		<div id="fdErr" class="book_errormessage"></div>
		
		</h4>


		<h4>
			<label class="label" id="user_name">To Date:</label>
			<form:input path="bookedTo" cssClass="inputbox" size="20"
				id="book_todate_value" readonly="true" />
			<label class="label"></label>

		
		<form:errors path="bookedTo" cssClass="book_date_error"></form:errors>
		<div id="tdErr" class="book_errormessage"></div>
		</h4>

		<h4>
			<label class="label" id="user_name">Total Rent:</label>
			<form:input path="totalRent" size="20" cssClass="inputbox"
				id="book_rent_value" onclick="computeRent(this.form)" />
		
		<form:errors path="totalRent" cssClass="book_errormessage"></form:errors>
   		</h4>
		<h4>
			<label class="label" id="user_name">Payment Recieved:</label>
			<form:radiobutton path="isPaid" value="yes" />
			Yes
			<form:radiobutton path="isPaid" value="no" />
			No
		</h4>


		<dl>
			<dt id="save">
				<input type="submit" class="button" value="Book" id="book_book_btn" />
			</dt>
			<dt id="cancel">
				<input type="button" value="Back"
					onclick="window.location.href='frame2.jsp'" id="book_back_btn" />
			</dt>
		</dl>



	</form:form>

</body>
</html>
