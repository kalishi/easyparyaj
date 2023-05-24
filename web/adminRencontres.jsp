
<%! 
    String type[]={"Championat","Coupe du Monde","Eliminatoire","Amical"}; 
%>
<%@page import="Model.Matche"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/profile.css" />
    </head>
    <body>
                <%--<%@include file="header.jsp" %>--%>

        <h1>Matche Management</h1>
         <form method="post" action="${pageContext.request.contextPath}/admin/matches">
        <div>
            <label for="type" >Type Match</label>
            <div class="col-sm-10">
                <select name="type" class="form-control">
                    <%for (String s:type){%>
                    <option value="<%=s%>"><%=s%></option>
                    <%}%>
                </select>
            </div>
        </div>
        <div >
            <label for="pays" class="col">Pays</label>
            <div class="col-sm-10">
                <input type="text" id="pays" name="pays">
            </div>
        </div>
        <div>
            <label for="dateMatch" >Date Mach</label>
            <div class="col-sm-10">
                <input type="date" id="dateMatch" name="dateMatch">
            </div>
        </div>
        <div>
            <label for="heureMatch" >Heure Mach</label>
            <div class="col-sm-10">
                <input type="time" id="heureMatch" name="heureMatch">
            </div>
        </div>
        <div>
            <label for="equipeR">Equipe Receveuse</label>
            <div>
                <input type="text" id="equipeR" name="equipeR">
            </div>
        </div>
        <div>
            <label for="equipeV">Equipe Visiteuse</label>
            <div>
                <input type="text" id="equipeV" name="equipeV">
            </div>
        </div>
        <div>
            <label for="cote">Cote</label>
            <div>
                <input type="number" id="cote" name="cote">
            </div>
        </div>
        <div>
            <label for="score">Score Final</label>
            <div>
                <input type="text" disabled  id="score" name="score">
            </div>
        </div>
        <input type="submit"   value="enregistrer">
    </form>
        <br><br>
        <h2>Liste de Rencontre</h2>
         <table>
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
                    <th>Action</th>

                    
                </tr>
            </thead>
            <tbody>
                
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
                    <td><a href="<%=request.getContextPath()%>/admin/matches/edit?id=<%= m.getId()%>">Edit</a></td>
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
