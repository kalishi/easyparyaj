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
           <h2 class="sign_title">Signup</h2>

        <form action="signup" method="POST">
         
            <%
                if (request.getAttribute("signupError") != null) {
            %>
            <p class="error" style="color: red"><%= request.getAttribute("signupError")%></p>

            <%
                }
            %>

                
                    <!--<label for="nom">Nom</label>-->
                    <input type="text" id="nom" name="nom" required placeholder="Last Name">

                    <!--<label for="prenom">Prénom</label>-->
                    <input type="text" id="prenom" name="prenom" required placeholder="Fisrt name">

                
                    <!--<label for="sexe">Sexe</label>-->
                    <select id="sexe" name="sexe" > 
                        <option value="M" selected >Masculin</option>
                        <option value="F">Feminin</option>
                    </select>

                    <!--<label for="adresse">Adresse</label>-->
                    <input type="text" id="adresse" name="adresse" required placeholder="Address">
                    
                    <!--<label for="lieuDeNaissance">Lieu de naissance</label>-->
                    <input type="text" id="lieuDeNaissance" name="lieuDeNaissance" required placeholder="Birth Address">


                    <!--<label for="dateDeNaissance">Date de naissance</label>-->
                    <input type="date"  id="dateDeNaissance" name="dateDeNaissance" required placeholder="Birthday">

              
                    <!--<label for="telephone">Téléphone</label>-->
                    <input type="text" id="telephone" name="telephone" required placeholder="Phone">

                    <!--<label for="nifCin">NIF/CIN</label>-->
                    <input type="text" id="nifCin" name="nifCin" required placeholder="CIN">


        
                    <!--<label for="username">Username</label>-->
                    <input type="text" id="username" name="username" required placeholder="User name">
                    <!--<label for="password">Password</label>-->
                    <input type="password" id="password" name="password" minlength="6" required placeholder="Password">


            <!--<label for="password2">Confirm Password</label>-->
            <input type="password" id="password2" name="password2" minlength="6" required>

            <input type="submit" value="Signup">
        </form>
    </body>
</html>
