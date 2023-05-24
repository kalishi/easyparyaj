/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler_servlet;

import Dao.MatcheDao;
import Model.Matche;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
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
            Matche model = new Matche();
            MatcheDao dao = new MatcheDao();
//            recuper les champ et apple la methode Enregistrer de rencontre dao
            try {
                String dateMatchString = request.getParameter("dateMatch");
                String heureMatchString = request.getParameter("heureMatch");

// Parse the date and time strings into LocalDate and LocalTime objects
                LocalDate dateMatch = LocalDate.parse(dateMatchString);
                LocalTime heureMatch = LocalTime.parse(heureMatchString);

                String type = request.getParameter("type");
                String pays = request.getParameter("pays");
                Float cote = Float.valueOf(request.getParameter("cote"));
                model.setType(type);
                model.setPays(pays);
                model.setEquipeR(request.getParameter("equipeR"));
                model.setEquipeV(request.getParameter("equipeV"));
                model.setCote(cote);
                model.setScoreFinal(request.getParameter("score"));
                model.setEtat("N");
//                model.setDate(Date.valueOf(request.getParameter("dateMatch")));
//                model.setHeure(Time.valueOf(request.getParameter("heureMatch")));
// Set the date and time values in the Paiement object
                model.setDate(Date.valueOf(dateMatch));
                model.setHeure(Time.valueOf(heureMatch));

            } catch (Exception e) {
                request.setAttribute("matcheError", e);
                request.getRequestDispatcher("/adminRencontres.jsp").forward(request, response);
                return;
            }

            if (!Matche.isValidScoreFormat(request.getParameter("score"))) {
                request.setAttribute("matcheError", "Score invalide");
                request.getRequestDispatcher("/adminRencontres.jsp").forward(request, response);
                return;
            }

            try {
                dao.enregistrer(model);
            } catch (SQLException ex) {
                request.setAttribute("matcheError", ex.getMessage());
//                response.sendRedirect(request.getContextPath() + "/admin");
                request.getRequestDispatcher("/adminRencontres.jsp").forward(request, response);

            } catch (ClassNotFoundException ex) {
                request.setAttribute("matcheError", ex.getMessage());
//                response.sendRedirect(request.getContextPath() + "/admin");
                request.getRequestDispatcher("/adminRencontres.jsp").forward(request, response);


            }

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
