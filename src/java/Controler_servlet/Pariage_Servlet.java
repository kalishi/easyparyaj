/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler_servlet;

import Dao.PariageDao;
import Model.PariageModel;
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
@WebServlet(name = "Pariage_Servlet", urlPatterns = {"/Pariage_Servlet"})
public class Pariage_Servlet extends HttpServlet {
      PariageModel pModel= new PariageModel();
      PariageDao pDao= new PariageDao();
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
            out.println("<title>Servlet Pariage_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Pariage_Servlet at " + request.getContextPath() + "</h1>");
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
          String str= request.getParameter("action");
          if(str!=null){
               Enregistre(request, response);
          }
    }
    
    public void Enregistre(HttpServletRequest request, HttpServletResponse response) throws IOException{
         double prix=0;
        double solde=0;
        if (request.getParameter("montant") != null && request.getParameter("solde") != null) {
            prix = Double.parseDouble(request.getParameter("montant"));
            solde= Double.parseDouble(request.getParameter("solde"));
        }
       
       pModel.setScrore_pevu(request.getParameter("score"));
       pModel.setMontant_mise(prix);
       pModel.setSolde_fiche(solde);
       
       HttpSession session = request.getSession();
       try {
            if (pModel != null) {
                if (pDao.enregistrer(pModel) > 0) {
                    String message="Enregistrement effectue avec succes ! ";
                    session.setAttribute("msg", message);
                    //lister(request, response);
                } else {
                    response.sendRedirect("index.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (ClassNotFoundException ex) {
            session.setAttribute("exceptions", ex.getMessage());

        } catch (SQLException ex) {
            session.setAttribute("exceptions", ex.getMessage());
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
