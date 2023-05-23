<%-- 
    Document   : index
    Created on : May 13, 2023, 10:24:34 PM
    Author     : DTelcy
--%>

<%@page import="Model.User"%>
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

              
          
        
        <%
            if(session.getAttribute("user") !=null && (Boolean)session.getAttribute("authenticated") ){
            User user = (User)session.getAttribute("user");
            if(user.isAdmin()){
                %><a href="admin">admin</a>
                <a href="logout">logout</a><%
            }else{
                %>
                <a href="accounts/profile">Profile</a>
                 <a href="accounts/pariage">New pariage</a>  
                 <a href="logout">logout</a>
                <%
            }
            }else{
                %> <a href="login">Login</a> 
                 <a href="signup">Signup</a> 
                <%   
            }
        %>        
           

 
    </body>
</html>
