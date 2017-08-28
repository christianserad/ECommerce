<%-- 
    Document   : cartOverview
    Created on : 9-Jul-2017, 10:21:36 AM
    Author     : Christian Romar Paul Serad
--%>

<%@page import="Controllers.User"%>
<%@page import="Controllers.Cart"%>
<%@page import="Controllers.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link href="css/headerstyle.css" rel="stylesheet" type="text/css">
        <link href="css/cartoverviewstyle.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <header>
            <div class="logo">
                <img src="images/storelogo.gif">
            </div>
            
            <div>
                <%if (session.getAttribute("user") != null) {%>
                <%User user = (User) session.getAttribute("user");%>
                <p>Hello <%out.println(user.getName() + " " + user.getLastName());%></p>
                <a href="LoginController?signout=1">SIGNOUT</a>
                <%} else {%>
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
            <%try{%>
                <%Cart cart = (Cart)session.getAttribute("cart");%>
                <%for(int i = (cart.getItems().length - 1); i >= 0; i--){%>
                    <div>
                        <img src="<%=cart.getItems()[i].getImageURL()%>">
                        <p>
                            <a href="CartController?remove=1&itemId=<%=cart.getItems()[i].getId()%>">Remove</a>
                            <%out.println(cart.getItems()[i].getName());%>
                        </p>
                    </div>
                    
                <%}%>
            <%}catch(NullPointerException e){%>
                <p>No Items</p>
            <%}%>
            <p>
                <a href="CartController?continueshopping=1">Continue Shopping</a>
            </p>    
        </section>
    </body>
</html>
