<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%
	String cssLocation = (String) session.getAttribute("cssLocation");
%>
<head>
<link style="text/css" rel="stylesheet" href=<%=cssLocation %> />


<script type="text/javascript">
	function DrawCaptcha() {
		var chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";
		var string_length = 5;
		var randomstring = '';
		for ( var i = 0; i < string_length; i++) {
			var rnum = Math.floor(Math.random() * chars.length);
			randomstring += chars.substring(rnum, rnum + 1);
			randomstring += " ";

		}
		document.getElementById("txtCaptcha").value = randomstring;
	}
	function randomString() {

		var chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";
		var string_length = 8;
		var randomstring = '';
		for ( var i = 0; i < string_length; i++) {
			var rnum = Math.floor(Math.random() * chars.length);
			randomstring += chars.substring(rnum, rnum + 1);
		}
		
	}

	function removeSpaces(string) {
		return string.split(' ').join('');
	}

	function Validate(frm) {
		var valid = true;
		var mobNo = frm.mobile.value;
		var email = frm.email.value;
		var username = frm.username.value;
		var pwd = frm.password.value;
		var cpwd = frm.confirmationPassword.value;
		var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
		var str2 = removeSpaces(frm.txtInput.value);

		if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))) {

			document.getElementById("emailErr").innerHTML = "You have entered an invalid email address!";
			valid = false;
		} else {
			document.getElementById("emailErr").innerHTML = "";
		}
		if (isNaN(mobNo)) {

			document.getElementById("mobErr").innerHTML = "Enter numeric value";
			valid = false;
		}

		else if (mobNo.length != 10) {

			document.getElementById("mobErr").innerHTML = "Enter 10 digits";
			valid = false;
		} else {
			document.getElementById("mobErr").innerHTML = "";
		}
		if (username == "") {
			document.getElementById("userErr").innerHTML = "Enter User Name";
			valid = false;
		}

		else {
			document.getElementById("userErr").innerHTML = "";
		}
		if (pwd == "") {
			document.getElementById("pwdErr").innerHTML = "Enter Password";
			valid = false;
		} else {
			document.getElementById("pwdErr").innerHTML = "";
		}
		if (cpwd == "") {
			document.getElementById("cpwdErr").innerHTML = "Enter Confirmation Password";
			valid = false;
		}

		else if (pwd != cpwd) {

			document.getElementById("cpwdErr").innerHTML = "Confirmation Password is incorrect!";
			valid = false;
		} else {
			document.getElementById("cpwdErr").innerHTML = "";
		}

		if (!(str1 == str2)) {
			valid = false;
			document.getElementById("captchaErr").innerHTML = "invalid captcha";
		} else {
			document.getElementById("captchaErr").innerHTML = "";

		}

		return valid;

	}
</script>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple CAPTCHA Example</title>
</head>
<body onload="DrawCaptcha();" class="leftside_panel">

	<div class="statusMessageStyle">${requestScope.message }</div>

	<form action="decide.ren" method="post"
		onsubmit="return Validate(this)">

		<div id="login_head">
			<h2>Sign Up</h2>
		</div>
		<br />


		<h4>
			<label class="label" id="user_name">User Name:</label> <input
				type="text" id="signUp_user_value" name="username" class="inputbox" />
		</h4>

		<div id="userErr" class="signUp_errs"></div>

		<h4>
			<label class="label" id="password">Password:</label> <input
				type="password" id="signUp_pwd_value" name="password"
				class="inputbox" />
		</h4>

		<div id="pwdErr" class="signUp_errs"></div>

		<h4>
			<label class="label" id="user_name">Confirm password:</label> <input
				type="password" id="signUp_cpwd_value" name="confirmationPassword"
				class="inputbox" />
		</h4>

		<div id="cpwdErr" class="signUp_errs"></div>

		<h4>
			<label class="label" id="user_name">Email:</label> <input type="text"
				id="signUp_email_value" name="emailId" class="inputbox" />
		</h4>

		<div id="emailErr" class="signUp_errs"></div>

		<h4>
			<label class="label" id="user_name">Mobile No.:</label> <input
				type="text" id="signUp_mob_value" name="mobile" class="inputbox" />
		</h4>

		<div id="mobErr" class="signUp_errs"></div>




		<input type="text" id="txtCaptcha" class="signUp_cptcha_img"
			style="background-image: url(img/captcha4.jpg); text-align: center; border: none; font-weight: bold; font-family: Modern"
			width="150" height="100" /> <input type="button"
			id="signUp_captcha_refresh" value="Refresh" onclick="DrawCaptcha();" />

		<h4>
			<label class="label" id="user_name">Enter the code shown</label> <input
				type="text" name="txtInput" class="inputbox"
				id="signUp_cptcha_value" /><br>
		</h4>
		<div id="captchaErr" class="signUp_errs"></div>

		<input type="submit" value="Submit" class="submitButton"
			id="signUp_submit_btn"> <input type="button" value="Back"
			class="submitButton" id="signUp_submit_btn"
			onclick="javascript:window.location='login.jsp'" />

	</form>


</body>
</html>
