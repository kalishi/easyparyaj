/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler_servlet;

import Dao.MatcheDao;
import Model.Matche;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johna
 */
@WebServlet(name = "Matches", urlPatterns = {"/Matches"})
public class Matches extends HttpServlet {

    static final String liste = "Match/match.jsp";
    static final String ajouter = "Match/ajouter.jsp";

    MatcheDao dao = new MatcheDao();
    Matche model = new Matche();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Matches</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Matches at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lister(request,response);
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
            enregistrer(request,response);
    }
    protected void lister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<Matche> data=dao.lister();
            HttpSession session=request.getSession();
            session.setAttribute("data", data);
            response.sendRedirect(liste);
        } catch (SQLException ex) {
            Logger.getLogger(Matches.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Matches.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void enregistrer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        model.setType(request.getParameter("type"));
        model.setPays(request.getParameter("pays"));
        model.setDate(request.getParameter("date"));
        model.setHeure(LocalTime.MIN);
        model.setEquipe_rec(request.getParameter("equipe_rec"));
        model.setEquipe_vis(request.getParameter("equipe_vis"));
        Float cote = null;
        if (request.getParameter("cote") != null) {
            cote = Float.parseFloat(request.getParameter("cote"));
        }
        model.setCote(cote);
        model.setScoreFinal(0);
        model.setEtat(request.getParameter("N"));
        try {
            if(dao.enregistrer(model)>0){
                lister(request, response);
            } else {
                response.sendRedirect(ajouter);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Matches.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Matches.class.getName()).log(Level.SEVERE, null, ex);
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
