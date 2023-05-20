/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler_servlet;

import Dao.PariageDao;
import Model.PariageModel;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author abdue
 */
@WebServlet(name = "pariage", urlPatterns = {"/accounts/pariage"})
public class Pariage_Servlet extends HttpServlet {

    PariageModel pModel = new PariageModel();
    PariageDao pDao = new PariageDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Boolean isAuthenticated = (Boolean) request.getSession().getAttribute("authenticated");
        User user = (User) request.getSession().getAttribute("user");

        if (isAuthenticated == null || !isAuthenticated ) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        request.getRequestDispatcher("/Pariage/Enregistrement_Pariage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Boolean isAuthenticated = (Boolean) request.getSession().getAttribute("authenticated");
        User user = (User) request.getSession().getAttribute("user");

        if (isAuthenticated == null || !isAuthenticated ) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        System.out.println("post pariage");
        double prix = 0;
        double solde = 0;
        if (request.getParameter("montant") != null && request.getParameter("solde") != null) {
            prix = Double.parseDouble(request.getParameter("montant"));
            solde = Double.parseDouble(request.getParameter("solde"));
        }
        pModel.setScrore_pevu(request.getParameter("score"));
        pModel.setMontant_mise(prix);
        pModel.setSolde_fiche(solde);
        pModel.setId_C(request.getSession().getAttribute("user_id").toString());
        pModel.setId_R(request.getParameter("id_recontre"));

        try {
            pDao.enregistrer(pModel);
            String message = "Enregistrement effectue avec succes ! ";
            request.setAttribute("msg", message);
            request.getRequestDispatcher(request.getContentType() + "/accounts/profile");
        } catch (ClassNotFoundException ex) {
            request.setAttribute("pariageError", "Echeque de l'enregistrement de pariage");
            request.getRequestDispatcher("/Pariage/Enregistrement_Pariage.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("pariageError", "Echeque de l'enregistrement de pariage");
            request.getRequestDispatcher("/Pariage/Enregistrement_Pariage.jsp").forward(request, response);
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
