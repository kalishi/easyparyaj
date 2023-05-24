<%-- 
    Document   : editRencontres
    Created on : May 23, 2023, 7:22:30 PM
    Author     : DTelcy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Rencontres</title>
    </head>
    <body>
                        <%@include file="header.jsp" %>

                        <h1>edit rencontre <%=request.getParameter("id")%></h1>
                        
                        <form action="" method="post">
                            lise des champ
                            <input type="submit" value="Submit">
                            <input type="hidden" id="action" name="action" value="update">
                        </form>
        
    </body>
</html>
