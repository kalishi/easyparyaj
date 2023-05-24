<%-- 
    Document   : adminPariages
    Created on : May 22, 2023, 10:58:16 PM
    Author     : DTelcy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.PariageModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


        <h1>Pariage management</h1>
         <% 
                 if ( request.getAttribute("error") !=null){
                %>
                <p class="error" style="color: red"><%= request.getAttribute("error")%></p>
                    
                <%   
                }
            %>
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
                    <th>Action</th>

                    
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
                    <td>
                        <form action="<%= request.getContextPath()%>/admin/paiement">
                            <input type="hidden" name="montant" value="<%=p.getSolde_fiche()%>">
                            <input type="submit" name="button" value="Payer">
                        </form>
                    </td> 
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