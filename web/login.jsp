<%-- 
    Document   : Login
    Created on : 6-Jul-2017, 4:03:58 PM
    Author     : christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form method="post" action="LoginController">
            <label>Username</label>
            <input name="username"> <br>
            <label>Password</label>
            <input name="password"> <br>
            <input type="submit">  
        </form>
        <form method="post" action="LoginController?registerpage=1">
            <input type="submit" value="register">  
        </form>
    </body>
</html>
