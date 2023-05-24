<%-- 
    Document   : Afficher_Pariage
    Created on : 18 mai 2023, 14:08:38
    Author     : abdue
--%>

<%@page import="Dao.PariageDao"%>
<%@page import="Model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.PariageModel"%>
<%@page import="Dao.PaiementDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h1>Mes Pariaes</h1>
        
         <table border="3" cellspacing="3" cellpadding="3">
            <thead>
                <tr>
                    <th>id</th>
                    <th>id Rencontre</th>
                    <th>Date pariage</th>
                    <th>Score prevu</th>
                    <th>Montant mise</th>  
                    <th>cote fiche</th> 
                    <th>Solde fiche</th>
                    <th>Etat</th>
                </tr>
            </thead>
            <tbody>
                
                    <%
                       ArrayList<PariageModel> prm =(ArrayList<PariageModel>)request.getAttribute("pariages");
                       if(prm != null && !prm.isEmpty()){
                          for(PariageModel p: prm){
                    %>
                    <tr>
                    <td><%= p.getCode_Pariage()%></td>
                    <td><%= p.getId_R()%></td>
                    <td><%= p.getDate_Pariage()%></td>
                    <td><%= p.getScrore_pevu()%></td>
                    <td><%= p.getMontant_mise()%></td>      
                    <td><%= p.getCoteMatch()%></td>  
                    <td><%= p.getSolde_fiche()%></td>  
                    <td><%= p.getEtat()%></td>    
  
                    </tr>                
                    <% }
                        } 
                        else{
                             %>
                        <h5>No Pariage recorded</h5>
                        <% 
                        }
                    %>
                    
                
            </tbody>
        </table>