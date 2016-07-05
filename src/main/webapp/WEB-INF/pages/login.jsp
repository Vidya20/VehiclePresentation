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
<title>Login Page</title>
<script type="text/javascript">
	function validate() {
		var user = document.form.username.value;
		var pass = document.form.password.value;
		var valid = true;
		var msg = "";
		var msg1 = "";
		if (user == "") {
			msg = "Please Enter Username (Incansensitive)";
			valid = false;
		}
		if (pass == "") {
			msg = "Please Enter Password";
			valid = false;
		}
		if (user == "" && pass == "") {
			msg = "Please Enter Username and Password";
			valid = false;
		}

		if (!valid) {
			document.getElementById("errormessage").style.visibility = "visible";
			document.getElementById("errormessage").innerHTML = msg;
			setTimeout("hideValidationMessage()", 3000);
		}
		return valid;
	}
	function hideValidationMessage() {
		document.getElementById("errormessage").style.visibility = "hidden";
	}

	function gotonew(form) {
		form.action = "newuser.ren";
		form.submit();
	}
	function guestUser(form) {
		form.action = "guestuser.ren";
		form.submit();
	}
</script>

</head>
<body class="leftside_panel">

	<div class="statusMessageStyle" style="font-size: 14px; ">
		${message}</div>
	<div id="errormessage"></div>
	<form name="form" method="post" action="nowvalidate.ren"
		onsubmit="return validate()">

		<div id="login_head">
			<h2>Login</h2>
		</div>
		<br />

		<h4>
			<label class="label" id="user_name">Username:</label> <input
				type="text" id="user_name_value" name="username" class="inputbox"
				title="username" /> <br /> <label class="label" id="static_msg"
				style="color: pink">(Case InSensitive)</label>
		</h4>
		<h4>
			<label id="password" class="label">Password:</label> <input
				type="password" name="password" class="inputbox" id="password_value"
				title="password" /> <br /> <label class="label" id="static_msg"
				style="color: pink">(Case Sensitive)</label>
		</h4>

		<h4>
			<input type="submit" id="login_btn" value="Login" 
				class="submitButton" />
		</h4>

		<h2>
			<label
				style="position: absolute; margin-left: 45px; margin-top: 114px;">Guest
				user? Click here</label>
		</h2>

		<div id="signUp_head">
			<h2>Don't have an account?</h2>
		</div>
		<h4>
			<input class="submitButton" id="skipLogin_btn" type="button"
				value="Skip Login" onclick="guestUser(this.form)" />
		</h4>
		<h4>
			<input class="submitButton" id="signUp_btn" type="button"
				value="Create New Account" onclick="gotonew(this.form)" />
		</h4>


	</form>
</body>
</html>