<%-- 
    Document   : PaiementJsp
    Created on : 12 mai 2023, 09:55:40
    Author     : abdue
--%>

<%@page import="Model.PaiementModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.PaiementDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listes des paiement</h1>
        
        <table border="3" cellspacing="3" cellpadding="3">
            <thead>
                <tr>
                     <th>Code Paiement</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Date Paiement</th>
                    <th>Montant</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <% 
                       PaiementDao pdao= new PaiementDao();
                       ArrayList<PaiementModel> pmt= pdao.lister();
                       if(!pmt.isEmpty()){
                          for(PaiementModel p: pmt){
                    %>
                    <td><%= p.getIdPaiement() %></td>
                    <td><%= p.getNom()%></td>
                    <td><%= p.getPrenom()%></td>
                    <td><%= p.getDate_Paiement() %></td>
                    <td><%= p.getMontant() %></td>
                    
                    <% }
                        } 
                        else{
                             %>
                        <h5>No Paiement recorded</h5>
                        <% 
                        }
                    %>
                    
                </tr>
            </tbody>
        </table>

    </body>
</html>
