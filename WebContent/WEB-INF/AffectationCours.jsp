<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <!DOCTYPE html>
  <html>
    <head>
      <meta charset="utf-8" />
      <title>Affectation des étudiants</title>
      <link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
    </head>
    <%@ page import="main.java.io.github.dramanebamba.pole_info.model.Master,java.util.List" %>
    <% String connected = (String) session.getAttribute("connected");%>
    <% String pseudo = (String) session.getAttribute("login");%>
    <% List<Object[]> listCours = (List<Object[]>) session.getAttribute("listCours");%>
    <% List<Master> nomMaster = (List<Master>) session.getAttribute("nomMaster");%>
    <% String id_master = (String) request.getAttribute("id_master");%>
    <% String nom_master = (String) request.getAttribute("nom_master");%>
    <% if(connected == "true" && pseudo.equals("admin")){%>
    <body>
      <div class="container">
        <h1>
          <% for(Master m : nomMaster) {%>
            <%= m.getNom() %>
          <% } %>
        </h1>
        <a href="./GetAffectationServlet">Voir la liste des affectations</a>
        <p class="lead">Un responsable peut affecter un étudiant aux cours facultatifs</p>

        <form class="form-horizontal" action="./AffectationStudent" method="post">
          <div class="form-group">
            <label for="exampleInputName2" class="col-sm-2 control-label">Sélectionner un cours facultatif</label>
            <div class="col-sm-10">
              <select class="form-control" name="id_contenu">
                <%
                int i = 0;
                for (i=0;i<listCours.size(); i++){%>
                <option value=<%out.println(listCours.get(i)[0]);%>"><%out.println(listCours.get(i)[1]);%></option>
                <% } %>
              </select>
            </div>
          </div>
          <input type="hidden" name="id_master" value=<% out.println(id_master);%>">
          <% for(Master m : nomMaster) {%>
          <input type="hidden" name="nom_master" value="<%= m.getNom() %>">
          <% } %>
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn btn-default">Valider</button>
            </div>
          </div>
        </form>
      </div>
      <% } else{%>
      NOTHING TO SHOW
      <%} %>
    </body>
  </html>
