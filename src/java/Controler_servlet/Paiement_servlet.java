/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler_servlet;

import Dao.PaiementDao;
import Model.PaiementModel;
import Model.User;
import com.mysql.cj.Session;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Paiement_servlet", urlPatterns = {"/admin/paiement"})
public class Paiement_servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (AdminServlet.checkAdmin(request, response)) {
            PaiementDao dao = new PaiementDao();
//        HttpSession session = request.getSession();
            try {
                ArrayList<PaiementModel> data = dao.lister();
                request.setAttribute("data", data);
            } catch (ClassNotFoundException e) {
                request.setAttribute("error", e.getStackTrace());
            } catch (SQLException e) {
                request.setAttribute("error", e.getStackTrace());
            }
            request.getRequestDispatcher("/Paiement/Paiement.jsp").forward(request, response);
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
        if (AdminServlet.checkAdmin(request, response)) {
            User user=(User) request.getSession().getAttribute("user");
            Double Montant= Double.parseDouble(request.getParameter("montant"));
            PaiementModel modelPaie= new PaiementModel();
            modelPaie.setId_Compte(user.getCode());
            modelPaie.setMontant(Montant);
            modelPaie.setNom(user.getNom());
            modelPaie.setPrenom(user.getPrenom());
            
            PaiementDao DaoPaie= new PaiementDao();
            try {
                DaoPaie.enregistrer(modelPaie);
            } catch (SQLException ex) {
                Logger.getLogger(Paiement_servlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Paiement_servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    // La fonction lister
//     protected void lister(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//         PaiementDao dao=new PaiementDao();
//        HttpSession session = request.getSession();
//        try {
//            ArrayList<PaiementModel> data = dao.lister();
//            request.setAttribute("data", data);
//        } catch (ClassNotFoundException e) {
//            request.setAttribute("error", e.getStackTrace());
//        } catch (SQLException e) {
//            request.setAttribute("error", e.getStackTrace());
//        }
//
//    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
