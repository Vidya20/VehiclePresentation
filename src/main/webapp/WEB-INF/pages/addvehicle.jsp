<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%
	String cssLocation = (String) session.getAttribute("cssLocation");
%>
<head>
<link style="text/css" rel="stylesheet" href=<%=cssLocation %> />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript">
	function isNumberKey(evt) {
		var charCode = (evt.which) ? evt.which : event.keyCode;

		if ((charCode > 47 && charCode < 58) || charCode == 8) {
			return true;
		} else {
			return false;
		}
	}

	function putZero(frm) {
		var mileage = frm.mileage.value;
		var dailyrent = frm.dailyRent.value;
		if (mileage == "") {
			frm.mileage.value = 0;
		}
		if (dailyrent == "") {
			frm.dailyRent.value = 0;
		}
	}
</script>
</head>
<body>
	<div id="vehicle_head">
		<h2>Add Vehicle</h2>
	</div>

	<div id="allign">


		<form:form action="persistvehicle.ren" commandName="vehic">


			<h4>
				<label class="label" id="user_name">Registration No:</label>
				<form:input path="regNo" size="20" id="add_reg_value"
					cssClass="inputbox" />
				<label class="label">(Eg. KA-23-A1234)</label>
			 <form:errors path="regNo" cssClass="add_errormessage" cssStyle="text-align: right"></form:errors>
			 </h4>

			<h4>
				<label class="label" id="user_name">Category:</label>
				<form:select path="cat" items="${category}" cssClass="inputbox"
					id="add_category_value" />
			
            <form:errors path="cat" cssClass="add_errormessage_cat" ></form:errors>
            </h4>
			<h4>
				<label class="label" id="user_name">Select Fuel Type: </label>
				<form:radiobuttons path="fuelType" items="${fuelType}"
					id="add_fuel_value" />
		
			<form:errors path="fuelType" cssClass="add_errormessage" ></form:errors>
    </h4>
			<h4>
				<label class="label" id="user_name">Manufacturer:</label>
				<form:input path="manufacturer" size="20" cssClass="inputbox"
					id="add_manufacturer_value" />
			
			<form:errors path="manufacturer" cssClass="add_errormessage" ></form:errors>
           </h4>
			<h4>
				<label class="label" id="user_name">Mileage:</label>
				<form:input path="mileage" size="20" cssClass="inputbox" 
					id="add_mileage_value" />
			
			<form:errors path="mileage" cssClass="add_errormessage" ></form:errors>
              </h4>
			<h4>
				<label class="label" id="user_name">Daily Rent:</label>
				<form:input path="dailyRent" size="20" cssClass="inputbox"
					id="add_dailyRent_value" />
			
			<form:errors path="dailyRent" cssClass="add_errormessage"></form:errors>
            </h4>
			<h4>
				<label class="label" id="user_name">Description:</label>
				<form:textarea path="description" rows="3" cols="19"
					id="add_description_value" />
			</h4>

			<dl>
				<dt id="save" >
					<input class="submitButton" type="submit" value="Add"
						id="add_add_btn" />
				</dt>
				<dt id="cancel">
					<input type="button" value="Back"
						onclick="window.location.href='frame2.jsp'" id="add_back_btn" />

				</dt>
			</dl>



		</form:form>
	</div>
</body>
</html>
