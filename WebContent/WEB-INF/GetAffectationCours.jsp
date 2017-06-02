<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<title>Affectation cours</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link href="css/coming-sssoon.css" rel="stylesheet" />

<!--     Fonts     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Grand+Hotel'
	rel='stylesheet' type='text/css'>
</head>

<%@ page
	import="main.java.io.github.dramanebamba.pole_info.model.Master,java.util.List"%>
<% String connected = (String) session.getAttribute("connected");
     String pseudo = (String) session.getAttribute("login");
     
     @SuppressWarnings("unchecked")
     List<Object[]> listCours = (List<Object[]>) session.getAttribute("listCours");
     
     @SuppressWarnings("unchecked")
     List<Master> nomMaster = (List<Master>) session.getAttribute("nomMaster");
     
     String id_master = (String) request.getAttribute("id_master");
     String nom_master = (String) request.getAttribute("nom_master");
     if(connected == "true" && pseudo.equals("admin")){%>
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
		<h1 class="page-header">
			Consulter les affectations -
			<% for(Master m : nomMaster) {%>
			<%= m.getNom() %>
			<% } %>
		</h1>
		<form class="form-horizontal" action="./GetAffectation" method="post">
			<div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Sélectionner
					un cours facultatif</label>
				<div class="col-sm-10">
					<select class="form-control" name="id_contenu">
						<%
                int i = 0;
                for (i=0;i<listCours.size(); i++){%>
						<option value=<%out.println(listCours.get(i)[0]);%>>
							<%out.println(listCours.get(i)[1]);%>
						</option>
						<% } %>
					</select>
				</div>
			</div>
			<input type="hidden" name="id_master"
				value=<% out.println(id_master);%>>
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
