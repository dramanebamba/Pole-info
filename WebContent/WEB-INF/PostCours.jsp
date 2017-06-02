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
<title>Cr&eacute;ation d'un cours</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link href="css/coming-sssoon.css" rel="stylesheet" />

<!--     Fonts     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Grand+Hotel'
	rel='stylesheet' type='text/css'>
</head>
<%@page import="main.java.io.github.dramanebamba.pole_info.model.Contenu,
				main.java.io.github.dramanebamba.pole_info.model.Master,
				main.java.io.github.dramanebamba.pole_info.model.Personne,
				java.util.List" %>
<%
	@SuppressWarnings("unchecked")
	List<Master> listMaster = (List<Master>) session.getAttribute("listMaster");
	
	@SuppressWarnings("unchecked")
	List<Contenu> listContenu = (List<Contenu>) session.getAttribute("listContenu");
	
	@SuppressWarnings("unchecked")
	List<Personne> listTeacher = (List<Personne>) session.getAttribute("listTeacher");
	
	String connected = (String) session.getAttribute("connected");
	
	if (connected == "true") {
%>
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
			<li><a href="./GetManageMasterContenu">Masters &amp;
					Contenus</a></li>
			<li><a href="./GetManageAffectation">Affectations</a></li>
			<li class="active"><a href="./GetManageCours">Cours</a></li>
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
      <h1 class="page-header">Création des cours</h1>
      
      <!-- <p class="lead">Un responsable peut créer des cours facultatifs ou obligatoires</p> -->

      <form class="form-horizontal" action="./PostCoursServlet" method="post">
        <div class="form-group">
          <label for="masterName" class="col-sm-2 control-label">Nom du master</label>
          <div class="col-sm-10">
            <select class="form-control" id="masterName" name="masterName">
            <% for(Master m : listMaster){ %>
            	<option value="<%= m.getId() %>"><%= m.getNom() %></option>
            <% } %>
            </select>
            </div>
          </div>
          <div class="form-group">
            <label for="contenuName" class="col-sm-2 control-label">Nom du contenu</label>
            <div class="col-sm-10">
              <select class="form-control" id="contenuName" name="contenuName">
            	<% for(Contenu c : listContenu){ %>
            		<option value="<%= c.getId() %>"><%= c.getNomMat() %></option>
           		<% } %>
            </select>
              </div>
            </div>
            <div class="form-group">
              <label for="teacherName" class="col-sm-2 control-label">Nom de l'enseignant</label>
              <div class="col-sm-10">
                <select class="form-control" id="teacherName" name="teacherName">
            		<% for(Personne p : listTeacher){ 
            				if(!p.getNom().equals("poleinfo3") || !p.getNom().equals("admin")){ %>
            					<option value="<%= p.getId() %>"><%= p.getPrenom() %> <%= p.getNom() %></option>
           			<% 		}
            			} %>
            	</select>
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
                      <option>O</option>
                      <option>N</option>
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
                <!-- <a href="./GetCoursServlet">Voir la liste des cours</a>  -->
              </div>
<% } %>
            </body>
          </html>
