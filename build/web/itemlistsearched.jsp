<%-- 
    Document   : itemListSearched
    Created on : 23-Jul-2017, 10:02:44 AM
    Author     : Christian
--%>

<%@page import="Controllers.ItemSearchContainer"%>
<%@page import="Controllers.ItemContainer"%>
<%@page import="Controllers.Cart"%>
<%@page import="Controllers.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Results</title>
        <link href="css/headerstyle.css" rel="stylesheet" type="text/css">
        <link href="css/itemliststyle.css" rel="stylesheet" type="text/css">
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
            <article>
                <%
                    ItemContainer itemContainer = (ItemContainer)application.getAttribute("itemcontainer");
                    ItemSearchContainer itemSearchContainer = (ItemSearchContainer)request.getAttribute("itemsearchcontainer");
                %>
                <%if(itemSearchContainer.getItemScore().length > 0){%>
                    <%for (int i = 0; i < itemSearchContainer.getItemScore().length; i++) {%>
                        <div>
                            <a href="ItemController?itemOverview=1&itemId=<%=itemSearchContainer.getItemScore()[i].getItemId()%>"><img src="<%=itemContainer.getItem(itemSearchContainer.getItemScore()[i].getItemId()).getImageURL()%>"><%=itemContainer.getItem(itemSearchContainer.getItemScore()[i].getItemId()).getName()%></a>
                        </div>
                    <%}%>
                <%}else{%>
                    <h4>No Results</h4>
                <%}%>
            </article>
        </section>      
    </body>
</html>
