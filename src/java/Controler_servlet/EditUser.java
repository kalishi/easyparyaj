/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler_servlet;

import Dao.UserDao;
import Model.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DTelcy
 */
//@WebServlet(name = "EditUser", urlPatterns = {"/admin/users/edit"})
public class EditUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     AdminServlet.checkAdmin(request, response);

        
        try {

            User userObject = new UserDao().rechercher(request.getParameter("id"));   
            request.setAttribute("userObject", userObject);

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/editUser.jsp").forward(request, response);

        }
        request.getRequestDispatcher("/editUser.jsp").forward(request, response);

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
              AdminServlet.checkAdmin(request, response);

//         User userObject = new UserDao().rechercher(request.getParameter("id"));   
//            request.setAttribute("userObject", userObject);
        double solde = Double.parseDouble(request.getParameter("solde"));
        String etat = request.getParameter("etat");
        String id = request.getParameter("id");
        System.out.println("id:" + id + "etat:" + etat + "solde:" + solde);
        
        try {
            System.out.println("Upading with dao");
            int nb = new UserDao().update(id, solde, etat);
            response.sendRedirect(request.getContextPath()+"/admin/users");

        } catch (SQLException ex) {
            request.setAttribute("error", ex.getMessage());
            doGet(request, response);
//            request.getRequestDispatcher("/editUser.jsp").forward(request, response);

        } catch (ClassNotFoundException ex) {
            request.setAttribute("error", ex.getMessage());
            doGet(request, response);
//            request.getRequestDispatcher("/editUser.jsp").forward(request, response);

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
