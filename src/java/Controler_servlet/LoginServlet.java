package Controler_servlet;

import Dao.UserDao;
import Model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao dao = new UserDao();
        User user = dao.getUser(username, password);
        if (user != null) {
            //set session attribute to indicate successful authentication
            request.getSession(true).setAttribute("authenticated", true);
            request.getSession(true).setAttribute("user", user);
            request.getSession(true).setAttribute("user_id",user.getCode());

            // Redirect to a secure page
            response.sendRedirect(request.getContextPath() +"/accounts/profile");
        } else {
            // Set an attribute to indicate authentication failure
            request.setAttribute("loginError", "Invalid username or password");
            // Redirect back to the login page
            
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Boolean isAuthenticated = (Boolean) request.getSession().getAttribute("authenticated");
        if (isAuthenticated != null && isAuthenticated) {
            
            response.sendRedirect(request.getContextPath() + "/accounts/profile");
            return;
        }

        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }
}
