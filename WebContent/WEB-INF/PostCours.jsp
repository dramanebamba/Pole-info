<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Ajouter un cours</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
  </head>
  <body>
    <div class="container">
      <h1>Création des cours</h1>
      <a href="./GetCoursServlet">Voir la liste des cours</a>
      <p class="lead">Un responsable peut créer des cours facultatifs ou obligatoires</p>

      <form class="form-horizontal" action="./PostCoursServlet" method="post">
        <div class="form-group">
          <label for="exampleInputName2" class="col-sm-2 control-label">Identifiant du master</label>
          <div class="col-sm-10">
            <input type="text" name="id_master" class="form-control" placeholder="Identifiant master">
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputName2" class="col-sm-2 control-label">Identifiant du contenu</label>
            <div class="col-sm-10">
              <input type="text" name="id_contenu" class="form-control" placeholder="Identifiant du contenu">
              </div>
            </div>
            <div class="form-group">
              <label for="exampleInputName2" class="col-sm-2 control-label">Identifiant de l'enseignant</label>
              <div class="col-sm-10">
                <input type="text" name="id_enseignant" class="form-control" placeholder="Identifiant de l'enseignant">
                </div>
              </div>
              <div class="form-group">
                <label for="exampleInputName2" class="col-sm-2 control-label">Période</label>
                <div class="col-sm-10">
                  <input type="text" name="periode" class="form-control" placeholder="Période">
                  </div>
                </div>
                <div class="form-group">
                  <label for="exampleInputName2" class="col-sm-2 control-label">Obligatoire ?</label>
                  <div class="col-sm-10">
                    <select class="form-control" name="obligatoire">
                      <option>Oui</option>
                      <option>Non</option>
                    </select>
                  </div>
                </div>
                <div class="form-group">
                  <label for="exampleInputName2" class="col-sm-2 control-label">Notes</label>
                  <div class="col-sm-10">
                    <input type="text" name="notes" class="form-control" placeholder="Notes">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button type="submit" class="btn btn-default">Créer</button>
                    </div>
                  </div>
                </form>
              </div>

            </body>
          </html>
