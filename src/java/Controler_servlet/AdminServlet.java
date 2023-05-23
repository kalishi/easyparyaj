/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler_servlet;

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DTelcy
 */
public class AdminServlet extends HttpServlet {


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
        
        checkAdmin(request, response);
//        request.setAttribute("username", user.getUsername());
        request.getRequestDispatcher("/compte/admin.jsp").forward(request, response);
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
        checkAdmin(request, response);
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

    
    public static void checkAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Boolean isAuthenticated = (Boolean) request.getSession().getAttribute("authenticated");   
        User user = (User) request.getSession().getAttribute("user");
        if (isAuthenticated == null || !isAuthenticated || user==null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        
        if(!user.isAdmin()){
            request.setAttribute("error", "please login as admin to acces admin");
            request.getRequestDispatcher(request.getContextPath()+"/").forward(request, response);

            return;
        }
    }
}
