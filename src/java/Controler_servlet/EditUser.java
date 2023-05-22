/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler_servlet;

import Dao.UserDao;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        try {

            User user = new UserDao().rechercher(request.getParameter("id"));
            request.setAttribute("solde", user.getSolde());
            request.setAttribute("etat", user.getEtat());
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

        double solde = Double.parseDouble(request.getParameter("solde"));
        String etat = request.getParameter("etat").toString();
        String id = request.getParameter("id");

        try {
            int nb = new UserDao().update(id, solde, etat);
        } catch (SQLException ex) {
            request.getRequestDispatcher("/editUser.jsp").forward(request, response);

        } catch (ClassNotFoundException ex) {
            request.getRequestDispatcher("/editUser.jsp").forward(request, response);

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
