<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<link rel="apple-touch-icon" sizes="76x76" href="images/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="images/favicon.png">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
	<title>Cr&eacute;ation d'un enseignant</title>
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
	<link href="css/coming-sssoon.css" rel="stylesheet" />

    <!--     Fonts     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>
</head>
<% String connected = (String) session.getAttribute("connected");

	String pseudo = (String) session.getAttribute("login");

	String role = (String) session.getAttribute("roles");
	
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
			<li class="active"><a href="./GetManageTeacher">Enseignant</a></li>
			<li><a href="./GetManageDataBase">Base de donn&eacute;es</a></li>
			<li><a href="./GetManageJSON">Exports JSON</a></li>
			<li><a href="./GetManageMasterContenu">Masters &amp;
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
	<h1>Formulaire de cr&eacute;ation d'un enseignant</h1>
	
	<div class="row">
		<form action="./PostCreateEnseignant" method="post">
			<div class="form-group">
			<label>Nom</label> <input class="form-control" type="text" name="last_name" />
			</div>
			<div class="form-group">
			<label>Pr&eacute;nom</label> <input class="form-control" type="text" name="first_name"/>
			</div>
			<div class="form-group">
			<label>E-mail</label> <input class="form-control" type="email" name="mail" />
			</div>
			<div class="form-group">
			<button type="submit" class="btn btn-primary">Cr&eacute;er l'enseignant</button>
			</div>
		</form>
	</div>
	
	<div class="row">
		<input class="btn btn-info" type="button" name="import" value="Importation d'un enseignant">
		<!-- <a class="btn btn-danger" href="./accueil">Annuler</a> -->
	</div>
	
	</div>
</body>
<% } %>
</html>