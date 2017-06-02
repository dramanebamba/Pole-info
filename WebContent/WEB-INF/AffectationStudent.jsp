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
    <%@ page import="main.java.io.github.dramanebamba.pole_info.model.*,main.java.io.github.dramanebamba.pole_info.model.Personne,java.util.List" %>
    <% String connected = (String) session.getAttribute("connected");
     String pseudo = (String) session.getAttribute("login");
     
     @SuppressWarnings("unchecked")
     List<Object[]> listCours = (List<Object[]>) session.getAttribute("listCours");
     
     @SuppressWarnings("unchecked")
     List<Personne> listStudent = (List<Personne>) session.getAttribute("listStudent");
     
     @SuppressWarnings("unchecked")
     List<Affectation> numAffectation = (List<Affectation>) session.getAttribute("numAffectation");
     Contenu nom_contenu = (Contenu) session.getAttribute("nom_contenu");
     String id_master = (String) request.getAttribute("id_master");
     String nom_master = (String) request.getAttribute("nom_master");
     String id_contenu = (String) request.getAttribute("id_contenu");
     if(connected == "true" && pseudo.equals("admin")){%>
    <body>
      <div class="container">
        <h1>Affectation des étudiants - 
          <% out.println(nom_master+ " - " + nom_contenu.getNomMat()); %>
        </h1>
        <a href="./GetAffectationMaster">Voir la liste des affectations</a>
        <p class="lead">Nombre d'étudiant affecté à ce cours : <% out.println(numAffectation); %></p>

        <form class="form-horizontal" action="./AffectationStudent" method="post">
          <div class="form-group">
            <label for="exampleInputName2" class="col-sm-2 control-label">Sélectionner un étudiant</label>
            <div class="col-sm-10">
              <select class="form-control" name="id_personne">
                <% for(Personne p : listStudent) {%>
                <option value="<%= p.getId() %>"><%= p.getPrenom() + " " + p.getNom()  %></option>
                <% } %>
              </select>
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputName2" class="col-sm-2 control-label">Année</label>
            <div class="col-sm-10">
              <select class="form-control" name="annee">
                <option value="2017" readonly>2017</option>
              </select>
            </div>
          </div>
          <input type="hidden" name="id_master" value=<% out.println(id_master);%>>
          <input type="hidden" name="id_contenu" value=<% out.println(id_contenu);%>>
          <input type="hidden" name="nom_master" value=<% out.println(nom_master);%>>
          <%-- <% for(Master m : nomMaster) {%>
          <input type="hidden" name="nom_master" value="<%= m.getNom() %>">
          <% } %> --%>
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn btn-default">Affecter à ce cours</button>
            </div>
          </div>
        </form>
      </div>
      <% } else{%>
      NOTHING TO SHOW
      <%} %>
    </body>
  </html>
