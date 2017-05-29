<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="main.java.io.github.dramanebamba.pole_info.model.Preference,java.util.List" %>
<% List<Preference> listPreference = (List<Preference>) session.getAttribute("listPreference"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Afficher les préférences</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
  </head>
  <body>
    <div class="container">
      <h1>Affichage des préférences</h1>
      <a href="./PostCreatePreferenceServlet">Ajouter des préférences</a>
      <!-- <p class="lead">En tant que responsable, je peux voir la liste des préférences</p> -->

      <table class="table">
      <thead>
        <tr>
          <td>Master</td>
          <td>Contenu</td>
          <td>Niveau</td>
        </tr>
       </thead>
       <tbody>
        <% for(Preference p : listPreference){ %>
          <tr>
            <td><%= p.getId_master() %></td>
            <td><%= p.getId_contenu() %></td>
            <td><%= p.getNiveau() %></td>
          </tr>
        <% } %>
        </tbody>
      </table>
    </div>
  </body>
</html>
