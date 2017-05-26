<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <!DOCTYPE html>
  <html>
    <head>
      <meta charset="utf-8" />
      <title>Ajouter un contenu</title>
      <link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
    </head>
    <body>
      <div class="container">
        <h1>Création de contenu</h1>
        <a href="./GetContenuServlet">Voir la liste des contenus</a>
        <p class="lead">Un responsable peut créer un contenu de cours</p>

        <form class="form-horizontal" action="./PostContenuServlet" method="post">
          <%-- <div class="form-group">
            <label for="exampleInputName2" class="col-sm-2 control-label">Identifiant du contenu</label>
            <div class="col-sm-10">
              <input type="text" name="id" class="form-control" placeholder="Entrer un id">
              </div>
          </div> --%>
          <div class="form-group">
            <label for="exampleInputName2" class="col-sm-2 control-label">Intitulé du contenu</label>
            <div class="col-sm-10">
              <input type="text" name="nom" class="form-control" placeholder="Entrer le nom du contenu ex : Maths, Décision...">
              </div>
            </div>
            <div class="form-group">
              <label for="exampleInputName2" class="col-sm-2 control-label">Description du contenu</label>
              <div class="col-sm-10">
                <input type="text" name="description" class="form-control" placeholder="Bref description du contenu du cours">
                </div>
              </div>
              <div class="form-group">
                <label for="exampleInputName2" class="col-sm-2 control-label">Apprentissage ?</label>
                <div class="col-sm-10">
                  <select class="form-control" name="apprentissage">
                    <option>O</option>
                    <option>N</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label for="exampleInputName2" class="col-sm-2 control-label">Volume horaire ?</label>
                <div class="col-sm-10">
                  <select class="form-control" name="volumeHoraire">
                    <option>30</option>
                    <option>40</option>
                    <option>50</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label for="exampleInputName2" class="col-sm-2 control-label">ECTS</label>
                <div class="col-sm-10">
                  <select class="form-control" name="ects">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                    <option>9</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label for="exampleInputName2" class="col-sm-2 control-label">Volume projet (heures)</label>
                <div class="col-sm-10">
                  <select class="form-control" name="volumeProjet">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                    <option>9</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label for="exampleInputName2" class="col-sm-2 control-label">Objectifs</label>
                <div class="col-sm-10">
                  <input type="text" name="objectives" class="form-control" placeholder="Objectifs">
                  </div>
                </div>
                <div class="form-group">
                  <label for="exampleInputName2" class="col-sm-2 control-label">Contents</label>
                  <div class="col-sm-10">
                    <input type="text" name="contents" class="form-control" placeholder="contents">
                    </div>
                  </div>
                <div class="form-group">
                  <label for="exampleInputName2" class="col-sm-2 control-label">Bibliographie</label>
                  <div class="col-sm-10">
                    <input type="text" name="biblio" class="form-control" placeholder="Références bibliographiques">
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
