<%-- 
    Document   : signup
    Created on : May 18, 2023, 4:55:54 PM
    Author     : DTelcy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Signup Page</title>
    </head>
    <body>
        <h2>Signup</h2>
        <form action="signup" method="POST">
            <%
                if (request.getAttribute("loginError") != null) {
            %>
            <p class="error" style="color: red"><%= request.getAttribute("signupError")%></p>

            <%
                }
            %>
            <label for="nom">Nom:</label>
            <input type="text" id="nom" name="nom" required><br><br>

            <label for="prenom">Prénom:</label>
            <input type="text" id="prenom" name="prenom" required><br><br>

            <label for="sexe">Sexe:</label>
            <select id="sexe" name="sexe">
                <option value="M" selected >Masculin</option>
                <option value="F">Feminin</option>
            </select>


            <label for="adresse">Adresse:</label>
            <input type="text" id="adresse" name="adresse" required><br><br>

            <label for="lieuDeNaissance">Lieu de naissance:</label>
            <input type="text" id="lieuDeNaissance" name="lieuDeNaissance" required><br><br>

            <label for="dateDeNaissance">Date de naissance:</label>
            <input type="date"  id="dateDeNaissance" name="dateDeNaissance" required><br><br>

            <label for="telephone">Téléphone:</label>
            <input type="text" id="telephone" name="telephone" required><br><br>

            <label for="nifCin">NIF/CIN:</label>
            <input type="text" id="nifCin" name="nifCin" required><br><br>

            <label for="username">Nom d'utilisateur:</label>
            <input type="text" id="username" name="username" required><br><br>

            <label for="password">Mot de passe:</label>
            <input type="password" id="password" name="password" minlength="6" required><br><br>

            <input type="submit" value="Signup">
        </form>
    </body>
</html>
