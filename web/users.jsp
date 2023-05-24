<%-- 
    Document   : users
    Created on : May 21, 2023, 9:06:30 PM
    Author     : DTelcy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
            <div class="content">
        <h1>User list</h1>
        
          <table>
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
                    <td><a href="<%=request.getContextPath()%>/admin/users/edit?id=<%= u.getCode()%>">Edit</a></td>


                    
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