<%-- 
    Document   : itemList
    Created on : 5-Jul-2017, 9:27:44 AM
    Author     : Christian Romar Paul Serad
--%>

<%@page import="Controllers.User"%>
<%@page import="Controllers.Cart"%>
<%@page import="Controllers.ItemContainer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controllers.Item"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shop</title>
        <link href="css/headerstyle.css" rel="stylesheet" type="text/css">
        <link href="css/itemliststyle.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <header>
            <div class="logo">
                <img src="images/storelogo.gif">
            </div>
            
            <div class="link">
                <%if (session.getAttribute("user") != null) {%>
                <%User user = (User) session.getAttribute("user");%>
                <p>Hello <%out.println(user.getName() + " " + user.getLastName());%></p>
                <a href="LoginController?signout=1">SIGNOUT</a>
                <%} else {%>
                    <a href="LoginController?signin=1">SIGNIN</a>
                <%}%>
            </div>

            <div class="link">
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
    
            <div class="link">
                <form method="post" action="SearchController">
                    <input name="searchword">
                    <input type="submit" value="search">
                </form>
            </div>
        </header>
        
        <section>
            <article>
                <%
                    ItemContainer itemContainer = (ItemContainer)application.getAttribute("itemcontainer");
                %>
                <%for (int i = 0; i < itemContainer.getItems().length; i++) {%>
                    <div>
                        <a href="ItemController?itemOverview=1&itemId=<%=itemContainer.getItems()[i].getId()%>"><img src="<%=itemContainer.getItems()[i].getImageURL()%>"><%=itemContainer.getItems()[i].getName()%></a>
                    </div>
                <%}%>
            </article>
        </section>
    </body>
</html>
