<%-- 
    Document   : admin
    Created on : May 21, 2023, 8:10:29 PM
    Author     : DTelcy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/main.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <%@include file="/header.jsp" %>
    <div id="admin-links">
                <a href="admin/users">
                <div class = "div-link">
                    <h3>User managment</h3>
                    
                </div>
                </a>   
        
                <a href="admin/matches">
                    <div class = "div-link">
                    <h3>Rencontre managment</h3>

                    
                </div>
                </a>
                <a href="admin/pariages">
                    <div class = "div-link">
                    <h3>Parriage managment</h3>

                    
                    </div>
                </a>
        
        
   </div>

    </body>
</html>
