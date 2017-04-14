<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Mail</title>
<style>
.d1 {
	width: 100%;
	height: 150px;
	float: left;
}

.d2 {
	width: 30%;
	height: 300px;
	padding-left: 50px;
	float: left;
	padding-top: 50px;
}

input {
	width: 100%;
	background: #ffcccc;
	height: 50px;
}

.d3 {
	float: right;
	width: 50%;
	height: 300px;
	padding-right: 50px;
}

.d31 {
	float: right;
	width: 100%;
	height: 100px;
	padding-top: 150px;
}

.d32 {
	float: right;
	width: 100%;
	height: 100px;
}
#ch{
padding-left: 500px;
padding-top: 50px;
}
#note {
	float: right; 
	padding-right : 30pm;
	padding-top: 50pm;
	font-size: 80pm;
	padding-right: 30pm;
}
</style>
</head>
<body bgcolor="#808080">
<div class="d1">
<p id ="ch"><font size=20 color=red ><i>Welcome HaiBK to WebMail</i></p>
</div>
<div class="d2">
	<img id="img" src="<%=request.getContextPath()%>/Images/hme.jpg"
		width="400pm" height="400pm"/>
</div>
<div class="d3">
	<div class="d31">
		<form action="EmailForm.jsp" method="post">
			<input type="submit" value="Wrtire Mail" width="300pm">
		</form>
	</div>
	<div class="d32">
		<form action="ShowMail" method="post">
			<input type="submit" value="Index Box" width="300pm">
		</form>
	</div>
	<p id="note"><font size="4" color="red">
		<i>Web mail Base !!!</i>
	</p>
</div>
</body>
</html>