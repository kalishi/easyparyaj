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
        <link rel="stylesheet" href="static/signup.css" />
    </head>
    <body>

        <form action="signup" method="POST">
            <h2>Signup</h2>
            <%
                if (request.getAttribute("signupError") != null) {
            %>
            <p class="error" style="color: red"><%= request.getAttribute("signupError")%></p>

            <%
                }
            %>
            <div class="group">
                <div class="sub_group">
                    <label for="nom">Nom</label>
                    <input type="text" id="nom" name="nom" required><br><br>
                </div>
                <div class="sub_group">
                    <label for="prenom">Prénom</label>
                    <input type="text" id="prenom" name="prenom" required><br><br>
                </div>
            </div>

            <div class="group">
                <div class="sub_group">
                    <label for="sexe">Sexe</label>
                    <select id="sexe" name="sexe">
                        <option value="M" selected >Masculin</option>
                        <option value="F">Feminin</option>
                    </select>
                </div>

                <div class="sub_group">
                    <label for="adresse">Adresse</label>
                    <input type="text" id="adresse" name="adresse" required><br><br>
                </div>
            </div>

            <div class="group">
                <div class="sub_group">
                    <label for="lieuDeNaissance">Lieu de naissance</label>
                    <input type="text" id="lieuDeNaissance" name="lieuDeNaissance" required><br><br>
                </div>
                <div class="sub_group">
                    <label for="dateDeNaissance">Date de naissance</label>
                    <input type="date"  id="dateDeNaissance" name="dateDeNaissance" required><br><br>
                </div>
            </div>

            <div class="group">
                <div class="sub_group">
                    <label for="telephone">Téléphone</label>
                    <input type="text" id="telephone" name="telephone" required><br><br>
                </div>
                <div class="sub_group">
                    <label for="nifCin">NIF/CIN</label>
                    <input type="text" id="nifCin" name="nifCin" required><br><br>
                </div>
            </div>

            <div class="group">
                <div class="sub_group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" required><br><br>
                </div>
                <div class="sub_group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" minlength="6" required><br><br>
                </div>
            </div>

            <label for="password2">Confirm Password</label>
            <input type="password" id="password2" name="password2" minlength="6" required><br><br>

            <input type="submit" value="Signup">
        </form>
    </body>
</html>
