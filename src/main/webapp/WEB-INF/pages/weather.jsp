<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#weather {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	width: 100%;
	border-collapse: collapse;
	margin-left: 1.5cm;
}

#weather td,#weather th {
	font-size: 1em;
	border: 1px solid #98bf21;
	padding: 3px 7px 2px 7px;
}

#weather th {
	font-size: 1.1em;
	text-align: left;
	padding-top: 5px;
	padding-bottom: 4px;
	background-color: #A7C942;
	color: #ffffff;
}

#weather tr.alt td {
	color: #000000;
	background-color: #EAF2D3;
}

#position {
	border-width: medium;
	font-weight: bold;
	font-family: fantasy;
	width: 4cm;
	background-color: #00BFFF;
	height: 4cm;
	margin-left: 1cm;
}
</style>
</head>

<body>
	<div id="position">
		<center>
			<br />
			<div style="color: white; font-size: 20px;">${output4}</div>
			<br />
			<div style="font-size: 45px; position: relative; max-height: 40cm;">${output}'C</div>
		</center>
	</div>
</body>
</html>

