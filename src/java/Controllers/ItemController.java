package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christian Romar Paul Serad
 */
@WebServlet(urlPatterns = {"/ItemController"})
public class ItemController extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        ItemContainer itemContainer = new ItemContainer();
        itemContainer.generate();
        context.setAttribute("itemcontainer", itemContainer);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        if (request.getParameter("itemList") != null) {
            response.sendRedirect("itemlist.jsp");
        } else if (request.getParameter("itemOverview") != null) {
            ItemContainer itemContainer = (ItemContainer)context.getAttribute("itemcontainer");
            int number = Integer.parseInt(request.getParameter("itemId"));
            request.setAttribute("item", itemContainer.getItem(number));
            RequestDispatcher dispatcher = request.getRequestDispatcher("itemoverview.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("itemlist.jsp");
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
