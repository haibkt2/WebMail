<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send Mail</title>
<style >
#wc{
color: red;
}
table {
    font-family: arial, sans-serif;
    width: 100%;
}

td, th {
    text-align: right;
    padding-right: 20pm;
}


</style>
</head>

<body BACKGROUND="${pageContext.request.contextPath}/Images/bg.jpg"/>
<img src="<%=request.getContextPath()%>/Images/TripleLine.GIF" width="168" height="36">
<img src="<%=request.getContextPath()%>/Images/chao.jpg" width=100% height="36"> 
<p id = "wc" align="right"><i>Welcome to Mail</i></p>
	<form action="SendMailAttachServlet" method="post" enctype="multipart/form-data">
		<table border="0" width="60%" align="center">
			<caption><h2>Send New E-mail</h2></caption>
			<tr>
				<td width="50%">To </td>
				<td><input type="text" name="recipient" size="200"/></td>
			</tr>
			<tr>
				<td>Subject </td>
				<td><input type="text" name="subject" size=200/></td>
			</tr>
			<tr>
				<td>Content </td>
				<td><textarea rows="10" cols="152" name="content"></textarea> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="file" name="file" size="130" /></td>
			</tr>
			<tr><td></td>
				<td colspan="2" align="center"><input type="submit" value="Send >>"/></td>
			</tr>
		</table>	
	</form>
	<form action="home.jsp">
		<input type="submit" value =" << Back Home"/>
	</form>
</bod>
</html>