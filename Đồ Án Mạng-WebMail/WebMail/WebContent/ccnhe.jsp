<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
span {
display: none;	
}
</style>
</head>
<body>
   <% 
            //if(request.getParameter("buttonName") != null) {
            if(request.getParameterNames() != null) {
        %>
            You clicked 
            <%= request.getParameter("buttonName") %>
        <%
            }
        %>

        <FORM NAME="form1" METHOD="POST">
            <INPUT TYPE="HIDDEN" NAME="buttonName">
            <button  ONCLICK="button1()">b1</button>
            <div>
            <span>noi dung an
            </span>
            </div>
            <INPUT TYPE="BUTTON" VALUE="Button 2" ONCLICK="button2()">
        </FORM>

        <SCRIPT LANGUAGE="JavaScript">
        
          
            function button1()
            {
                form1.submit()
            }    
            function button2()
            {  
                form1.submit()
            }    
            // --> 
        </SCRIPT>
</body>
</html>