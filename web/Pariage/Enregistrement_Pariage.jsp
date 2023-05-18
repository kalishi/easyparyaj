<%-- 
    Document   : Pariage.jsp
    Created on : 18 mai 2023, 13:33:48
    Author     : abdue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enregistrer</title>
    </head>
    <body>
        <h1>Enregistrement</h1>
        <form action="Pariage_Servlet" method="post">
            <label>Score Prevu</label>
            <input type="text" name="score" placeholder="score"><br>
             <label>Montant Mise</label>
             <input type="number" name="montant" placeholder="montant"><br>
             <label>Solde Fiche</label>
             <input type="number" name="solde" placeholder="solde" disabled="true"><br>
             
             <input type="submit" class="btn btn-primary"  name="action" value="Enregistrer">
        </form>
    </body>
</html>
