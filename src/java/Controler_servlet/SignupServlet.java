/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler_servlet;

import Dao.UserDao;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DTelcy
 */
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
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
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String sexe = request.getParameter("sexe");
        String adresse = request.getParameter("adresse");
        String lieuDeNaissance = request.getParameter("lieuDeNaissance");
        String dateDeNaissance = request.getParameter("dateDeNaissance");
        String telephone = request.getParameter("telephone");
        String nifCin = request.getParameter("nifCin");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        if (!password.equals(password2)) {
            request.setAttribute("signupError", "The two password doesn't matche");
            response.sendRedirect("signup");
            return;
        }

//        // creating a user with those informations 
        User user = new User(nom, prenom,
                sexe, adresse, lieuDeNaissance,
                dateDeNaissance, telephone,
                nifCin, username, password,
                sexe
        );

        try {

            UserDao dao = new UserDao();
            int nb = dao.enregistrer(user);
            if (nb > 0) {
                request.getSession().setAttribute("authenticated", true);
                request.getSession().setAttribute("user", user);
                // Redirect to a secure page
                response.sendRedirect(request.getContextPath() + "/accounts/profile");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            request.setAttribute("signupError", e);
            response.sendRedirect("signup");
        } catch (Exception e) {
            e.printStackTrace();
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
