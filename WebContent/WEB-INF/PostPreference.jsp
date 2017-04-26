<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Ajouter une préférence</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
  </head>
  <body>
    <div class="container">
      <h1>Création d'une préférence</h1>
      <a href="./GetPreferenceServlet">Voir la liste des préférences</a>

      <p class="lead">Un étudiant peut choisir ses préférences</p>

      <form class="form-horizontal" action="./PostPreferenceServlet" method="post">
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
              <label for="exampleInputName2" class="col-sm-2 control-label">Identifiant de la personne</label>
              <div class="col-sm-10">
                <input type="text" name="id_personne" class="form-control" placeholder="Identifiant de la personne">
                </div>
              </div>
              <div class="form-group">
                <label for="exampleInputName2" class="col-sm-2 control-label">Niveau</label>
                <div class="col-sm-10">
                  <select name="niveau" class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default">Créer</button>
                </div>
              </div>
            </form>
            <div class="row">
                 <a href="./accueil" class="btn btn-danger">Annuler</a>
              </div>
          </div>
		
        </body>
      </html>
