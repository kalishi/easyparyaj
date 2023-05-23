<%-- 
    Document   : compte
    Created on : May 17, 2023, 9:03:43 PM
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
    <%@include file="header.jsp" %>

        <h1>profile page welcome ${request.getAttribute("user")}</h1>
    </body>
</html>
