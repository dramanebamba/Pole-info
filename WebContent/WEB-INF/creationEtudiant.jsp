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
<title>Cr&eacute;tion d'un &eacute;tudiant</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link href="css/coming-sssoon.css" rel="stylesheet" />

<!--     Fonts     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Grand+Hotel'
	rel='stylesheet' type='text/css'>
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
			<li class="active"><a href="./GetManageStudent">&Eacute;tudiant</a></li>
			<li><a href="./GetManageTeacher">Enseignant</a></li>
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
		<div class="row">
			<H1>Formulaire de cr&eacute;ation d'un &eacute;tudiant</H1>
			<br />

			<form action="./PostCreateStudent" method="post">
				<!-- <form action="./PostCreateStudent?operation=createStudent" method="post"> -->
				<div class="form-group">
					<label>Nom</label> <input class="form-control" type="text"
						name="last_name" id="last_name" placeholder="Nom" />
				</div>
				<div class="form-group">
					<label>Pr&eacute;nom</label> <input class="form-control"
						type="text" name="first_name" id="first_name"
						placeholder="Pr&eacute;nom" />
				</div>
				<div class="form-group">
					<label>E-mail</label> <input class="form-control" type="text"
						name="email" id="mail" placeholder="prenom.nom@dauphine.eu" />
				</div>
				<div class="form-group">
					<label>Parcours</label> <SELECT class="form-control"
						name="parcours" id="parcours" size="1">
						<OPTION>SITN</OPTION>
						<OPTION>IF</OPTION>
						<OPTION>ID</OPTION>
					</SELECT>
				</div>
				<div class="form-group">
					<button class="btn btn-primary" type="submit">Cr&eacute;er
						l'&eacute;tudiant</button>
				</div>
			</form>
		</div>
		<div class="row">
			<input class="btn btn-info" type="button" name="import"
				value="Importation d'un &eacute;tudiant">
				<!-- <a class="btn btn-danger" href="./accueil">Annuler</a> -->
		</div>
	</div>
</body>
<% } %>
</html>