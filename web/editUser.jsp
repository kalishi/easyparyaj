<%-- 
    Document   : editUser
    Created on : May 21, 2023, 9:44:39 PM
    Author     : DTelcy
--%>

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit user</title>
    </head>
    <body>
        <%User userObject = (User)request.getAttribute("userObject");%>
        
        <h1>Edit user "<%=userObject.getUsername()%>"</h1>
        <form action="" method="POST">
            <%
                if (request.getAttribute("error") != null) {
            %>
            <p class="error" style="color: red"><%= request.getAttribute("error")%></p>

            <%
                }
            %>

            <label for="solde">Solde</label>
            <input type="number" id="solde" name="solde" min="0" required value="<%=userObject.getSolde()%>"><br><br>
            <label for="etat">Etat</label>
            <select id="etat" name="etat">
                <option value="A" <% if (userObject.getEtat().equalsIgnoreCase("A")) { %> selected <% } %>>Actif</option>
                <option value="F" <% if (userObject.getEtat().equalsIgnoreCase("F")) { %> selected <% } %>>Ferme</option>
                <option value="S" <% if (userObject.getEtat().equalsIgnoreCase("S")) { %> selected <% } %>>Supprime</option>
            </select>

            <br>
            <input type="submit" value="Edit">
        </form>
    </body>
</html>
