<%-- 
    Document   : Pariage.jsp
    Created on : 18 mai 2023, 13:33:48
    Author     : abdue
--%>

<%@page import="Model.User"%>
<%@page import="Dao.MatcheDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Matche"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enregistrer</title>
    </head>
    <body>
        <h1>Enregistrement</h1>
        <form action="pariage" method="post">
             <% 
                if ( request.getAttribute("pariageError") !=null){
                %>
                <p class="error" style="color: red"><%= request.getAttribute("pariageError")%></p>
                    
                <%   
                }
                 if ( request.getAttribute("msg") !=null){
                %>
                <p class="success" style="color: green"><%= request.getAttribute("msg")%></p>
                    
                <%   
                }
            %>
            <label>Score Prevu</label>
            <input type="text" name="score" placeholder="score" required><br>
             <label>Montant Mise</label>
             <input type="number" name="montant" placeholder="montant" min="10" required><br>
             <label>Solde Fiche</label>
             <input type="number" name="solde" placeholder="solde" disabled="true"><br>
            <label>Choisir la rencontre</label>
            <select id="id_rencontre" name="id_rencontre" required>
             <%
             MatcheDao mdao = new MatcheDao();
                 ArrayList<Matche> arr = mdao.lister();
                 for (Matche m:arr){
                 %>
                    <option value="<%=m.getId() %>"><%=m.getEquipeV()%> vs <%=m.getEquipeR()%></option>
                <%
                 }
            %>
             </select>
             <input type="submit" class="btn btn-primary" value="Enregistrer">
        </form>
             
            <%@include file="Afficher_Pariage.jsp" %>
            
            <%--
            <script src="../jquery.js"></script>
            <script>
    function calculerSolde() {
        var codeMatch = document.getElementById("id_rencontre").value;
        var mise = document.getElementById("mise").value;

        // Effectuer la requête AJAX
        $.ajax({
            url: '/getSoldeFiche',
            method: 'GET',
            data: { codeMatch: codeMatch },
            success: function(response) {
                var match = response; // Obtenir les données du match depuis la réponse AJAX
                var cote = match.cote; // Récupérer la valeur de la cote

                // Effectuer le calcul du solde en multipliant la cote par la mise
                var solde = cote * mise;

                // Afficher le solde calculé
                document.getElementById("solde").textContent = solde;
            },
            error: function(error) {
                // Gérer les erreurs de la requête AJAX
                console.log(error);
            }
        });
    }
</script>
--%>
    </body>
</html>
