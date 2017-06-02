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
<title>Liste de mes pr&eacute;f&eacute;rences</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link href="css/coming-sssoon.css" rel="stylesheet" />

<!--     Fonts     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Grand+Hotel'
	rel='stylesheet' type='text/css'>
</head>

<%@ page import="main.java.io.github.dramanebamba.pole_info.model.Preference,java.util.List" %>
<% @SuppressWarnings("unchecked") 
List<Preference> listPreference = (List<Preference>) session.getAttribute("listPreference");
int id = (Integer) session.getAttribute("id");
%>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="./accueil">Pole Info</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="./accueil">Menu</a></li>
			<li  class="active"><a href="./GetPreferenceServlet?id=<%=id%>">Mes pr&eacute;f&eacute;rences</a></li>
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
      <h1 class="page-header">Affichage des préférences</h1>
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
