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
//            recuper les champ et apple la methode Enregistrer de rencontre dao

            String type = request.getParameter("type");
            String pays = request.getParameter("pays");
            Date date = Date.valueOf(request.getParameter("date"));
            Float cote = Float.parseFloat(request.getParameter("cote"));
            Matche model = new Matche();
            model.setType(type);
            model.setPays(pays);
            model.setDate(Date.valueOf(LocalDate.now()));
            model.setHeure(Time.valueOf(LocalTime.now()));
            model.setEquipeR(request.getParameter("equipe_rec"));
            model.setEquipeV(request.getParameter("equipe_vis"));
            model.setCote(cote);
            model.setScoreFinal(request.getParameter("score"));
            model.setEtat("N");
            MatcheDao dao = new MatcheDao();

            try {
                dao.enregistrer(model);
            } catch (SQLException ex) {
                request.setAttribute("matcheError", ex.getMessage());
            } catch (ClassNotFoundException ex) {
                request.setAttribute("matcheError", ex.getMessage());

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
