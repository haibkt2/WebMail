<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inbox</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("button").click(function(){
        $("p").toggle();
    });
});

</script>
<style>
.td{
width: 100%;
height: 100pm;
color: red;
}
.nd{
 background-color: #e5eecc;
    border: solid 5px #c3c3c3;
float:right;
width: 70%;
}

</style>
<body BACKGROUND="${pageContext.request.contextPath}/Images/inbox.jpg">
<% request.setCharacterEncoding("UTF-8");
%>
<div class = "td">
<h2 align="center" ><i>My message list</i></h2>
</div>
<div  class = "nd">
	<c:forEach items="${mail}" var="InboxMail">
	 <hr  width="30%"  align="left" /> 
	<%-- 	Message:${InboxMail.id}<br> --%>
		<c:forEach items="${InboxMail.mail}" var="mail">
			
			<button>${mail.address}---${mail.subject}</button><br>
			<p> Content: ${mail.content}</p><br>
			<p>(Date:${mail.date})</p><br>
		</c:forEach>

	</c:forEach>
	
	</form>
	</div>
	<div class = "kt"><form action="home.jsp" >
		<input type="submit" align="center" value="Back Home"></div>
</body>
</html>