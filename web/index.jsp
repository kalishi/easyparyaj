<%-- 
    Document   : index
    Created on : May 13, 2023, 10:24:34 PM
    Author     : DTelcy
--%>

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EasyParyaj | Home</title>
        <link rel="stylesheet" href="static/index.css"/>
        <link href="https://api.fontshare.com/v2/css?f[]=satoshi@900,700,500,301,701,300,501,401,901,400&display=swap" rel="stylesheet">
    </head>
    <body>
        <%@include file="header.jsp" %>

        <%
                if (request.getAttribute("error") != null) {
        %>
        <p class="error" style="color: red"><%= request.getAttribute("error")%></p>

        <%
            }
        %> 

        
    <div class="carousel">
        <div class="slides">
            <div class="slide">
                <img src="static/img1.jpg" alt="Image 1">
            </div>
            <div class="slide">
                <img src="static/img2.jpg" alt="Image 2">
            </div>
            <div class="slide">
                <img src="static/img3.jpg" alt="Image 3">
            </div>
        </div>
    </div>
        
        
        <table border="3" cellspacing="3" cellpadding="3">
            <thead>
                <tr>
                    <th>code Rencontre</th>
                    <th>Type</th>
                    <th>Date</th>   
                    <th>Pays</th>
                    <th>Heures</th>
                    <th>Equipre Receuveuse</th>
                    <th>Equipre Visiteuse</th>
                    <th>Cote</th>         
                    <th>Score Final</th>

                    
                </tr>
            </thead>
            <tbody>
                
                    <%
                       ArrayList<Matche> matches = ( ArrayList<Matche>)request.getAttribute("");
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
        </table>
    <script src="static/carousel.js"></script>
</body>
</html>
