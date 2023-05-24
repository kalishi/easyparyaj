<%--<%@include file="../layout/header.jsp"%>--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="../Model/Match.java" %>
<div class="mb-3"></div>
<div class="container">
    <link href="${pageContext.request.contextPath}/ressources/css/bootstrap.min.css" rel="stylesheet" type="text/css" /><!-- comment -->
   
   <a href="${pageContext.request.contextPath}/Match/ajouter.jsp">Ajouter un match</a>
    <hr>
    <table class="table table-responsive table-stiped">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Type</th>
      <th scope="col">Pays</th>
      <th scope="col">Date Match</th>
      <th scope="col">Heure Match</th>
      <th scope="col">Equipe receveuse</th>
      <th scope="col">Equipe visiteuse</th>
      <th scope="col">Cote</th>
      <th scope="col">Score Final</th>
      <th scope="col">Etat</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody class="table-group-divider">

      <%
          ArrayList<Match> list=(ArrayList<Match>)session.getAttribute("data");
          if(list!=null){
            if(!list.isEmpty()){
            for(MatchModel m: list){
      %>
    <tr>
      <td><%=m.getId_match()%></td>
      <td><%=m.getType()%></td>
      <td><%=m.getPays()%></td>
      <td><%=m.getDate()%></td>
      <td><%=m.getHeure()%></td>
      <td><%=m.getEquipe_rec()%></td>
      <td><%=m.getEquipe_vis()%></td>
      <td><%=m.getCote()%></td>
      <td><%=m.getScore_final()%></td>
      <td><%=m.getEtat()%></td>
      <td>
          <a href="">Modifier</a> | 
          <a href="">Supprimer</a>
      </td>
    </tr>
    <%     }
          }
          }%>
  </tbody>
</table>
</div>
