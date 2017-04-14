<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
.d1 {
	width: 100%;
	height: 100px;
	float: left;
}

.d2 {
	width: 30%;
	height: 300px;
	padding-left: 30px;
	float: left;
	padding-top: 50px;
}


table {
    font-family: arial, sans-serif;
    width: 100%;
}

td, th {
	font-size:4;
    text-align: left;
    padding-right: 10pm;
}
.d3 {
	float: right;
	width: 60%;
	height: 300px;
	padding-right: 50px;
}

.d31 {
	float: right;
	width: 100%;
	height: 100px;
}

.d32 {
	float: right;
	width: 100%;
	height: 100px;
}

#ch {
	padding-right: 50px;
	padding-top: 10px;
}

.d12 {
	height: 100%;
	
}

#note {
	float: right;
	padding-right: 30pm;
	padding-top: 50pm;
	font-size: 80pm;
	padding-right: 30pm;
}

.d11 {
height:100%;
width :20%;
	float: left;
	padding-left: 145px;
}
#inf{
font-size: 5;
}
.d4{
height:100pm;
background:#808080;
width: 100%;
}
</style>
</head>
<body BACKGROUND="${pageContext.request.contextPath}/Images/bg_log.jpg">
	<div class="d1">
		<div class="d11">
			<img id="logo"
				src="D:/EmailAttachWebApp/WebContent/Images/SignIn.png" width="100"
				height="100">
		</div>
		<div class="d12">
			<p id="ch">
				<font size=20 color=red><i>!!!!Sign In Mail!!!!</i></font>
			</p>
		</div>
	</div>
	<div class="d2">
		<img id="img" src="D:/EmailAttachWebApp/WebContent/Images/homeLog.jpg"
			width="400pm" height="400pm">
	</div>
	<div class="d3">
		<div class="d31"></div>
		<div class="d32">
			<form action="home.jsp" method="post">
				<table border="0" width="60%" align="center">

					<tr>
						<td ><p ><font></font>User Name</p></td>
						<td><input type="text" name="user" size ="80" /></td>
					</tr>
					<tr>
						<td >PassWord</td>
						<td><input type="password" name="password" size ="80"/></td>
					</tr>


					<tr>
						<td></td>
						<td  align="center"><input type="submit"
							value="Sign In" /></td>
					</tr>
				</table>
			</form>
		</div>
		
	</div>
	<div align="center" class="d4">
	<h3>@thanhhai13t2-class:13t2-mssv:102130065</h3>
	</div>
</body>
</html>