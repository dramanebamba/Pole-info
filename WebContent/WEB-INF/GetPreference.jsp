<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
      <a href="./PostPreferenceServlet">Ajouter des préférences</a>
      <p class="lead">En tant que responsable, je peux voir la liste des préférences</p>

      <table class="table">
        <tr>
          <td>Master</td>
          <td>Contenu</td>
          <td>Personne</td>
          <td>Niveau</td>
        </tr>
        <c:forEach items="${ preference }" var="preference" varStatus="boucle">
          <tr>
            <td>${ preference.id_master }</td>
            <td>${ preference.id_contenu }</td>
            <td>${ preference.id_personne }</td>
            <td>${ preference.niveau }</td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
