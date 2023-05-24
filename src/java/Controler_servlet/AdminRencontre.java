/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler_servlet;

import Dao.MatcheDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author DTelcy
 */
@WebServlet(name = "AdminRencontre", urlPatterns = {"/admin/matches"})
public class AdminRencontre extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (AdminServlet.checkAdmin(request, response)) {
            try {
                request.setAttribute("rencontres", new MatcheDao().lister());
            } catch (SQLException ex) {
                Logger.getLogger(AdminRencontre.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminRencontre.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("/adminRencontres.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (AdminServlet.checkAdmin(request, response)) {
            System.out.println("Methode post cree rencontre");
//            recuper les champ et apple la methode Enregistrer de rencontre dao

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
