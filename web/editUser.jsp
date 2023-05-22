<%-- 
    Document   : editUser
    Created on : May 21, 2023, 9:44:39 PM
    Author     : DTelcy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit user</title>
    </head>
    <body>
        <h1>Edit user</h1>
        <form action="signup" method="POST">
            <%
                if (request.getAttribute("signupError") != null) {
            %>
            <p class="error" style="color: red"><%= request.getAttribute("signupError")%></p>

            <%
                }
            %>
           
            <label for="solde">NIF/CIN:</label>
            <input type="number" id="solde" name="solde" required value="<%= request.getAttribute("solde")%>"><br><br>

            <label for="username">Etat</label>
            <select id="etat">
                <option value="A">Actif</option>
                <option value="S">Supprime</option>
                <option value="F">Ferme</option>
            </select>

            <input type="submit" value="Signup">
        </form>
    </body>
</html>
