<%-- 
    Document   : Register
    Created on : 17-Jul-2017, 11:43:04 AM
    Author     : Christian Romar Paul Serad
--%>

<%@page import="Controllers.LoginResult"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <%
            LoginResult result = (LoginResult)request.getAttribute("loginresult");
            String username = "";
            String password = "";
            String name = "";
            String lastname = "";
                
            if(request.getParameter("username") != null){
                username = request.getParameter("username");
            }
            if(request.getParameter("password") != null){
                password = request.getParameter("password");
            }
            if(request.getParameter("name") != null){
                name = request.getParameter("name");
            }
            if(request.getParameter("lastname") != null){
                lastname = request.getParameter("lastname");
            }
        %>
        <form method="post" action="LoginController?register=1">
            <label>Username</label>
            <input name="username" value="<%=username%>"> 
            <%
                if(result != null){
                    if(result.isUsernameError()){
                        out.println(result.getUsernameErrorMessage());
                    }
                }
                
            %>
            <br>
            <label>Password</label>
            <input name="password" value="<%=password%>"> 
            <%
                if(result != null){
                    if(result.isPasswordError()){
                        out.println(result.getPasswordErrorMessage());
                    }
                }
                
            %>
            <br>
            <label>Name</label>
            <input name="name" value="<%=name%>"> 
            <%
                if(result != null){
                    if(result.isNameError()){
                        out.println(result.getNameErrorMessage());
                    }
                }
                
            %>
            <br>
            <label>Last Name</label>
            <input name="lastname" value="<%=lastname%>"> 
            <%
                if(result != null){
                    if(result.isLastNameError()){
                        out.println(result.getLastNameErrorMessage());
                    }
                }
                
            %>
            <br>
            <input type="submit" value="register">
        </form>
    </body>
</html>
