<%-- 
    Document   : compte
    Created on : May 17, 2023, 9:03:43 PM
    Author     : DTelcy
--%>
<%@page import="Model.Matche"%>
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
    
    <div class="content">
        <h2>welcome back <%=u.getUsername()%></h2>
        
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
        </table>
    </div>
    <script src="static/carousel.js"></script>
    </body>
</html>
