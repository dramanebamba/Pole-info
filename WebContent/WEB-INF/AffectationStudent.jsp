<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link rel="apple-touch-icon" sizes="76x76" href="images/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="images/favicon.png">

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<title>Affectation des &eacute;tudiants</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link href="css/coming-sssoon.css" rel="stylesheet" />

<!--     Fonts     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Grand+Hotel'
	rel='stylesheet' type='text/css'>
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
     if(connected == "true"){%>
    <body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="./accueil">Pole Info</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="./accueil">Menu</a></li>
			<li><a href="./GetManageStudent">&Eacute;tudiant</a></li>
			<li><a href="./GetManageTeacher">Enseignant</a></li>
			<li><a href="./GetManageDataBase">Base de donn&eacute;es</a></li>
			<li><a href="./GetManageJSON">Exports JSON</a></li>
			<li class="active"><a href="./GetManageMasterContenu">Masters &amp;
					Contenus</a></li>
			<li><a href="./GetManageAffectation">Affectations</a></li>
			<li><a href="./GetManageCours">Cours</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
			<li><a href="./GetDeconnexion"> <span
					class="glyphicon glyphicon-log-out"></span> Se d&eacute;connecter
			</a></li>
		</ul>
	</div>
	</nav>

	<div class="container" style="padding-top:70px;">

        <h1 class="page-header">Affectation des étudiants - 
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
