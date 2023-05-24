<%-- 
    Document   : compte
    Created on : May 17, 2023, 9:03:43 PM
    Author     : DTelcy
--%>
<%@page import="Dao.PariageDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.PariageModel"%>
<%@page import="Dao.PaiementDao"%>
<%@page import="Model.Matche"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


                
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link rel="stylesheet" href="../static/profile.css" />
    </head>
    <body>
        <%
        User u = (User)session.getAttribute("user");%>
    <%@include file="/header.jsp" %>

        
        
        <div class="carousel">
        <div class="slides">
            <div class="slide">
                <img src="../static/img1.jpg" alt="Image 1">
            </div>
            <div class="slide">
                <img src="../static/img2.jpg" alt="Image 2">
            </div>
            <div class="slide">
                <img src="../static/img3.jpg" alt="Image 3">
            </div>
        </div>
    </div>
        <h2>welcome back <%=u.getUsername()%></h2>
        
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
        <%--
        <table>
            <thead>
                <tr>
                    <th>code Rencontre</th>
                    <th>Type</th>
                    <th>Date</th>   
                    <th>Pays</th>
                    <th>Heures</th>
                    <th>Eq. Receuveuse</th>
                    <th>Eq. Visiteuse</th>
                    <th>Cote</th>         
                    <th>Score Final</th>

                    
                </tr>
                
            </thead>
            
            <tbody>
                <div class="b-bt"></div>
                    <%
                       ArrayList<Matche> matches = ( ArrayList<Matche>)request.getAttribute("rencontres");
                       if(matches != null && !matches.isEmpty()){
                          for(Matche m: matches){
                    %>
                    <tr>
                    <td><%= m.getId()%></td>
                    <td><%= m.getType()%></td>
                    <td><%= m.getDate()%></td>   
                    <td><%= m.getPays()%></td>
                    <td><%= m.getHeure()%></td>
                    <td><%= m.getEquipeR()%></td>  
                    <td><%= m.getEquipeV()%></td>      
                    <td><%= m.getCote()%></td>       
                    <td><%= m.getScoreFinal()%></td>       
                    <td><a href="users/edit?id=<%= m.getId()%>">Edit</a></td>
                    </tr>                
                    <% }
                        } 
                        else{
                             %>
                        <h5>No Matches</h5>
                        <% 
                        }
                    %>
                    
                
            </tbody>
        </table>--%>
    </div>
    <script src="static/carousel.js"></script>
    </body>
</html>
