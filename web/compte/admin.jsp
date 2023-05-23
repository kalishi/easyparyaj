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
    <div id="admin-links">
                <%@include file="/header.jsp" %>
                <div class = "div-link">
                    <a href="admin/users">User managment</a>   
                </div>
                <div class = "div-link">
                    <a href="admin/matches">Rencontre managment</a>
                </div>
                <div class = "div-link">
                    <a href="admin/pariages">Parriage managment</a>
                </div>
        
        
   </div>

    </body>
</html>
