/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        UserContainer userContainer = new UserContainer();
        userContainer.generate();
        context.setAttribute("usercontainer", userContainer);
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
        
        if (request.getParameter("signout") != null) {
            session.setAttribute("user", null);
            response.sendRedirect("itemlist.jsp");
        } else if (request.getParameter("signin") != null) {
            response.sendRedirect("login.jsp");
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
        ServletContext context = request.getServletContext();
        if (request.getParameter("registerpage") != null) {
            response.sendRedirect("register.jsp");
        } 
        else if(request.getParameter("register") != null){
            UserContainer userContainer = (UserContainer)context.getAttribute("usercontainer");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastname");
            
            LoginResult result = userContainer.addUser(username, password, name, lastName);
            if(result.isSuccess()){
                User user = userContainer.getUser(username,password);
                session.setAttribute("user",user);
                response.sendRedirect("registrationcomplete.jsp");
            }
            else{
                request.setAttribute("loginresult", result);
                RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
                dispatcher.forward(request, response);
            }
        }
        else if (!request.getParameter("username").equals("") && !request.getParameter("password").equals("")) {
            UserContainer userContainer = (UserContainer)context.getAttribute("usercontainer");
            User user = userContainer.getUser(request.getParameter("username"), request.getParameter("password"));

            if (user == null) {
                response.sendRedirect("login.jsp");
            } else {
                session.setAttribute("user", user);
                response.sendRedirect("itemlist.jsp");
            }

        } else {
            response.sendRedirect("login.jsp");
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
