<%-- 
    Document   : index
    Created on : May 13, 2023, 10:24:34 PM
    Author     : DTelcy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! home page</h1>
        <%
                if (request.getAttribute("error") != null) {
            %>
            <p class="error" style="color: red"><%= request.getAttribute("error")%></p>

            <%
                }
            %>
            <br>   

        <a href="login">Login</a>        <a href="signup">Signup</a>     
        <a href="accounts/pariage">New pariage</a>     
        <a href="logout">logout</a>            
        <a href="admin">admin</a>      

 
    </body>
</html>
