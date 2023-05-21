<%-- 
    Document   : Afficher_Pariage
    Created on : 18 mai 2023, 14:08:38
    Author     : abdue
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.PariageModel"%>
<%@page import="Dao.PaiementDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Les Pariages</h1>
        
         <table border="3" cellspacing="3" cellpadding="3">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Date pariage</th>
                    <th>Score prevu</th>
                    <th>Montant mise</th>    
                    <th>Solde fiche</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                       ArrayList<PariageModel> prm = (ArrayList<PariageModel>) request.getAttribute("data");
                       if(prm != null && !prm.isEmpty()){
                          for(PariageModel p: prm){
                    %>
                    <td><%= p.getNom()%></td>
                    <td><%= p.getPrenom()%></td>
                    <td><%= p.getDate_Pariage()%></td>
                    <td><%= p.getScrore_pevu()%></td>
                    <td><%= p.getMontant_mise()%></td>  
                    <td><%= p.getSolde_fiche()%></td>  
                    
                    <%--<td><%= p.getId_Compte()%></td> --%>

                    
                    <% }
                        } 
                        else{
                             %>
                        <h5>No Pariage recorded</h5>
                        <% 
                        }
                    %>
                    
                </tr>
            </tbody>
        </table>

    </body>
</html>
