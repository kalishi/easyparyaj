<%-- 
    Document   : adminRencontres
    Created on : May 22, 2023, 9:59:08 PM
    Author     : DTelcy
--%>

<%@page import="Model.Matche"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Matche Management</h1>
        
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
    </body>
</html>
