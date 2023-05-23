<%-- 
    Document   : users
    Created on : May 21, 2023, 9:06:30 PM
    Author     : DTelcy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - users</title>
    </head>
    <body>
            <%@include file="/header.jsp" %>

        <h1>User list</h1>
        
          <table border="3" cellspacing="3" cellpadding="3">
            <thead>
                <tr>
                    <th>username</th>
                    <th>Nom</th>
                    <th>Prenom</th>   
                    <th>sexe</th>
                    <th>Etat</th>
                    <th>Solde</th>  
                    <th>Admin</th>         
                    <th>Action</th>

                    
                </tr>
            </thead>
            <tbody>
                
                    <%
                       ArrayList<User> users = ( ArrayList<User>)request.getAttribute("users");
                       if(users != null && !users.isEmpty()){
                          for(User u: users){
                    %>
                    <tr>
                    <td><%= u.getUsername()%></td>
                    <td><%= u.getNom()%></td>
                    <td><%= u.getPrenom()%></td>   
                    <td><%= u.getSexe()%></td>
                    <td><%= u.getEtat()%></td>
                    <td><%= u.getSolde()%></td>  
                    <td><%= u.isAdmin()%></td>       
                    <td><a href="users/edit?id=<%= u.getCode()%>">Edit</a></td>


                    
                    </tr>                
                    <% }
                        } 
                        else{
                             %>
                        <h5>No user recorded</h5>
                        <% 
                        }
                    %>
                    
                
            </tbody>
        </table>
    </body>
</html>
