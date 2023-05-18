package Controler_servlet;

import dbutils.DBUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        // Check username and password in the database
        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            // Set an attribute to indicate successful authentication
            request.getSession().setAttribute("authenticated", true);
            // Redirect to a secure page
            response.sendRedirect("/compte/profile.jsp");
        } else {
            // Set an attribute to indicate authentication failure
            request.setAttribute("loginError", "Invalid username or password");
            // Redirect back to the login page
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private boolean authenticate(String username, String password) {
        // Implement your logic to query the MySQL database and check the credentials
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Connect to the database
            conn = DBUtils.connect();
            // Prepare the SQL statement
            String sql = "SELECT COUNT(*) FROM compte WHERE username=? AND password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute the query
            rs = pstmt.executeQuery();

            // Check if the query returned a result
            if (rs.next()) {
                int count = rs.getInt(1);
                return count == 1; // Return true if the username and password match a user in the database
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                DBUtils.close(rs, pstmt, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; // Return false if an error occurred or no matching user was found
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getSession().getAttribute("authenticated") == true){
                
                
            }

    request.getRequestDispatcher("/login.jsp").forward(request, response);

    }
}