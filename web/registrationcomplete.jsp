<%-- 
    Document   : RegistrationComplete
    Created on : 21-Jul-2017, 11:15:45 AM
    Author     : Christian Romar Paul Serad
--%>

<%@page import="Controllers.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Complete</title>
    </head>
    <body>
        <%User user = (User)session.getAttribute("user");%>
        <h1>Registration Complete</h1>
        <p>Welcome <%=user.getName() + " " + user.getLastName()%> !</p>
        <p><a href="itemlist.jsp">Click to Home</a></p>
    </body>
</html>
