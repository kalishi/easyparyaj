<%-- 
    Document   : Pariage.jsp
    Created on : 18 mai 2023, 13:33:48
    Author     : abdue
--%>

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
            %>
            <label>Score Prevu</label>
            <input type="text" name="score" placeholder="score"><br>
             <label>Montant Mise</label>
             <input type="number" name="montant" placeholder="montant"><br>
             <label>Solde Fiche</label>
             <input type="number" name="solde" placeholder="solde" disabled="true"><br>
            <label>Choisir la rencontre</label>
             <select id="id_renconre" name="id_renconre">
            <option value="1">real Madrid vs Manchester City></option>
             <%--
             RencontreDao dao = new RencontreDao();
                 ArrayList<Rencontre> arr = new ArrayList(doa.liste()));
                 for (Rencontre r:arr){
                 %>
                    <option value="<%=r.code %>"><%=r.equipeVisiteuse%> vs <%=r.equipeReceveuse%></option>
                <%
                 }
            --%>
             </select>
             <input type="submit" class="btn btn-primary" value="Enregistrer">
        </form>
    </body>
</html>
