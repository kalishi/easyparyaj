/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler_servlet;

import Dao.MatcheDao;
import Dao.PariageDao;
import Model.Matche;
import Model.PariageModel;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import java.time.LocalDate;
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
        System.out.println(user);
        if (isAuthenticated == null || !isAuthenticated) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        MatcheDao dao = new MatcheDao();
        try {
            ArrayList<Matche> matches = dao.lister();
            request.setAttribute("matches", matches);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }

        try {
            ArrayList<PariageModel> data = pDao.listeParieUser(user.getCode());
            request.setAttribute("userPariages", data);
        } catch (ClassNotFoundException e) {
            request.setAttribute("error", e.getStackTrace());
        } catch (SQLException e) {
            request.setAttribute("error", e.getStackTrace());
        }
        request.getRequestDispatcher("/Pariage/Enregistrement_Pariage.jsp").forward(request, response);

//        try {
//            lister(request, response);
//            listerGain(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(Pariage_Servlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Pariage_Servlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Boolean isAuthenticated = (Boolean) request.getSession().getAttribute("authenticated");
        User user = (User) request.getSession().getAttribute("user");

        if (isAuthenticated == null || !isAuthenticated) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        System.out.println("post pariage");
        String scorePrevu,idRencontre;
        Double montantMise;
        try {
             scorePrevu = request.getParameter("score");
             montantMise = Double.parseDouble(request.getParameter("montant")) ;
             idRencontre = request.getParameter("id_rencontre");

        } catch (Exception e) {

            e.printStackTrace();
            request.setAttribute("pariageError", "error check some fields");
            request.getRequestDispatcher("/Pariage/Enregistrement_Pariage.jsp").forward(request, response);
            return;
        }
        
        PariageModel p = new PariageModel(Date.valueOf(LocalDate.now()), scorePrevu, montantMise, idRencontre, user.getCode());
        
        
        try {
            pDao.enregistrer(p);
            String message = "Enregistrement effectue avec succes ! ";
            request.setAttribute("msg", message);
            request.getRequestDispatcher(request.getContentType() + "/accounts/profile");
        } catch (ClassNotFoundException ex) {
            request.setAttribute("pariageError", "Echeque de l'enregistrement de pariage");
            request.getRequestDispatcher("/Pariage/Enregistrement_Pariage.jsp").forward(request, response);

        } catch (Exception ex) {
//            request.setAttribute("pariageError", "Echeque de l'enregistrement de pariage");
            request.getRequestDispatcher("/Pariage/Enregistrement_Pariage.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    //La fonction lister()
//    protected void lister(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
//        try {
//            ArrayList<PariageModel> data = pDao.lister();
//            request.setAttribute("data", data);
//        } catch (ClassNotFoundException e) {
//            request.setAttribute("error", e.getStackTrace());
//        } catch (SQLException e) {
//            request.setAttribute("error", e.getStackTrace());
//        }
//        request.getRequestDispatcher("/Pariage/Afficher_Pariage.jsp").forward(request, response);
//    }
//
//    protected void listerGain(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
//        try {
//            ArrayList<PariageModel> data = pDao.listerGain();
//            request.setAttribute("data", data);
//        } catch (ClassNotFoundException e) {
//            request.setAttribute("error", e.getStackTrace());
//        } catch (SQLException e) {
//            request.setAttribute("error", e.getStackTrace());
//        }
//        request.getRequestDispatcher("/Pariage/ListeGain.jsp").forward(request, response);
//    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
