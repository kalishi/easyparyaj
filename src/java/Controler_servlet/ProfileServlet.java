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
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DTelcy
 */
@WebServlet(name = "profile", urlPatterns = {"/accounts/profile"})
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PariageDao pDao = new PariageDao();
        User user = (User) request.getSession().getAttribute("user");
        if(LoginServlet.checkLogin(request, response)){
            try {
                ArrayList<PariageModel> data = pDao.listeParieUser(user.getCode());
                request.setAttribute("pariages", data);
            } catch (ClassNotFoundException e) {
                request.setAttribute("error", e.getStackTrace());
            } catch (SQLException e) {
                request.setAttribute("error", e.getStackTrace());
            }
        request.getRequestDispatcher("/compte/profile.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                if(LoginServlet.checkLogin(request, response)){}
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
