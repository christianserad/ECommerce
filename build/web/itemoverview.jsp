<%-- 
    Document   : itemOverview
    Created on : 5-Jul-2017, 9:30:16 AM
    Author     : Christian Romar Paul Serad
--%>

<%@page import="Controllers.Cart"%>
<%@page import="Controllers.User"%>
<%@page import="Controllers.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item Overview</title>
        <link href="css/headerstyle.css" rel="stylesheet" type="text/css">
        <link href="css/itemoverviewstyle.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <header>
            <div class="logo">
                <img src="images/storelogo.gif">
            </div>
            
            <div>
                <%if(session.getAttribute("user") != null){%>
                    <%User user = (User)session.getAttribute("user");%>
                    <p>Hello <%out.println(user.getName() + " " + user.getLastName());%></p>
                    <a href="LoginController?signout=1">SIGNOUT</a>
                <%}else{%>
                    <a href="LoginController?signin=1">SIGNIN</a>
                <%}%>
            </div>
        
            <div>
                <%try {%>
                    <%
                        Cart cart = (Cart) session.getAttribute("cart");
                        int number = cart.getItems().length;
                    %>
                    <a href="CartController?viewcart=1">CART: <%=number%></a>
                <%} catch (NullPointerException e) {%>
                    <a href="CartController?viewcart=1">CART: 0</a>
                <%}%>
            </div>

            <div>
                <form method="post" action="SearchController">
                    <input name="searchword">
                    <input type="submit" value="search">
                </form>
            </div>
        </header>

        <section>
            <%Item item = (Item)request.getAttribute("item");%>
            <img src="<%=item.getImageURL()%>">
            <p>Name: <%=item.getName()%></p>
            <p>Brand: <%=item.getBrand()%></p>
            <p>Price: <%=item.getPrice()%></p>
            <p>Rating: <%=item.getRating()%></p>

            <form method="post" action="CartController?itemId=<%=item.getId()%>">
                <input type="submit" value="Add To Cart">
            </form>    
        </section>
        
    </body>
</html>
