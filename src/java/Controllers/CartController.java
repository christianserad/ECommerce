/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian
 */
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(request.getParameter("continueshopping") != null){
            response.sendRedirect("itemlist.jsp");
        }
        else if(request.getParameter("viewcart") != null){
            response.sendRedirect("cartoverview.jsp");
        }
        else if(request.getParameter("remove") != null){
            int id = Integer.parseInt(request.getParameter("itemId"));
            Cart cart = (Cart)session.getAttribute("cart");
            cart.removeItem(id);
            session.setAttribute("cart", cart);
            response.sendRedirect("cartoverview.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        if (request.getParameter("itemId") != null) {
            int number = Integer.parseInt(request.getParameter("itemId"));
            ItemContainer itemContainer = (ItemContainer)context.getAttribute("itemcontainer");
            
            if(session.getAttribute("cart") == null){
                Cart cart = new Cart();
                cart.addItem(itemContainer.getItem(number));
                session.setAttribute("cart", cart);
            }
            else{
                Cart cart = (Cart)session.getAttribute("cart");
                cart.addItem(itemContainer.getItem(number));
                session.setAttribute("cart", cart);
            }
            response.sendRedirect("cartoverview.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
