<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Voir la liste des cours</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
  </head>
  <body>
    <div class="container">
      <h1>Liste des cours</h1>
      <a href="./PostCoursServlet">Ajouter des cours</a>
      <p class="lead">Affichage de la liste des cours</p>

      <table class="table">
        <tr>
          <td>Master</td>
          <td>Contenu</td>
          <td>Enseignant</td>
          <td>Période</td>
          <td>Obligatoire</td>
          <td>Notes</td>
        </tr>
        <c:forEach items="${ cours }" var="cours" varStatus="boucle">
          <tr>
            <td>${ cours.id_master }</td>
            <td>${ cours.id_contenu }</td>
            <td>${ cours.id_enseignant }</td>
            <td>${ cours.periode }</td>
            <td>${ cours.obligatoire }</td>
            <td>${ cours.notes }</td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
