/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler_servlet;

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author DTelcy
 */
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (checkAdmin(request, response)) {
            request.getRequestDispatcher("/compte/admin.jsp").forward(request, response);
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if (checkAdmin(request, response)) {

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

//    public static void checkAdmin(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        Boolean isAuthenticated = (Boolean) request.getSession().getAttribute("authenticated");
//        User user = (User) request.getSession().getAttribute("user");
//        if (isAuthenticated == null || !isAuthenticated || user == null) {
//            response.sendRedirect(request.getContextPath() + "/login");
//        } else {
//
//            if (!user.isAdmin()) {
//                request.setAttribute("error", "please login as admin to acces admin");
//                request.getRequestDispatcher(request.getContextPath() + "/").forward(request, response);
//            }
//        }
//    }
    
    public static boolean checkAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Boolean isAuthenticated = (Boolean) request.getSession().getAttribute("authenticated");
        User user = (User) request.getSession().getAttribute("user");
        if (isAuthenticated == null || !isAuthenticated || user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        } else {
            if (!user.isAdmin()) {
                request.setAttribute("error", "please login as admin to access admin");
                request.getRequestDispatcher(request.getContextPath() + "/").forward(request, response);
                return false;
            }
        }
        return true;
    }
}
