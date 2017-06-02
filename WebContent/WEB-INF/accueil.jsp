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
<title>Menu</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link href="css/coming-sssoon.css" rel="stylesheet" />

<!--     Fonts     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Grand+Hotel'
	rel='stylesheet' type='text/css'>
</head>
<%
	String connected = (String) session.getAttribute("connected");

	String pseudo = (String) session.getAttribute("login");

	String role = (String) session.getAttribute("roles");

	int id_ma = (Integer) session.getAttribute("id_m");
	
	int id = (Integer) session.getAttribute("id");
	
	if (connected == "true") {
%>
<body
	style="background-image: url('images/student.jpeg'); background-repeat: repeat; background-size: cover">

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="./accueil">Pole Info</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="./accueil">Menu</a></li>
			<%
				if (role.equals("S")) {
			%>
			<li><a href="./GetManagePreference">Pr&eacute;f&eacute;rences</a></li>
			<%
				}
			%>
			<%
				if (role.equals("M")) {
			%>
			<li><a href="./GetManageStudent">&Eacute;tudiant</a></li>
			<li><a href="./GetManageTeacher">Enseignant</a></li>
			<li><a href="./GetManageDataBase">Base de donn&eacute;es</a></li>
			<li><a href="./GetManageJSON">Exports JSON</a></li>
			<li><a href="./GetManageMasterContenu">Masters &amp; Contenus</a></li>
			<li><a href="./GetManageAffectation">Affectations</a></li>
			<li><a href="./GetManageCours">Cours</a></li>
			<%
				}
			%>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
			<li><a href="./GetDeconnexion"> <span
					class="glyphicon glyphicon-log-out"></span> Se déconnecter
			</a></li>
		</ul>
	</div>
	</nav>

	<div class="container" style="padding-top: 70px;">
		<!-- <h1>Menu</h1> -->
		<%
			if (role.equals("S")) { // Etudiant
		%>
		<div class="page-header">
			<h1 style="color: #000;">
				Bienvenue sur votre espace Pole Info <br /> <small style="color: #FFF;">Votre
					page d'accueil est en cours de construction ! Vous pouvez accéder à
					vos fonctionnalités via la barre de navigation située plus haut</small>
			</h1>
		</div>


		<%
			} else if (role.equals("M")) { // Enseignant
		%>
		<div class="page-header">
			<h1 style="color: #000;">
				Bienvenue sur votre espace Pole Info <br /> <small style="color: #FFF;">Votre
					page d'accueil est en cours de construction pour les enseignants ! Vous pouvez accéder à
					vos fonctionnalités via la barre de navigation située plus haut</small>
			</h1>
		</div>
		<%
			} else {
		%>
		<br /> Erreur: Votre compte n'est ni un Enseignant, ni un
		&Eacute;tudiant, veuillez contacter l'administrateur. <br />
		<%
			}
		%>
		<br />
	</div>
	<%
		} else {
	%>
	<br /> Erreur : vous n'&ecirc;tes plus connect&eacute;.
	<br />
	<%
		}
	%>
	<!-- <div class="cover black" data-color="black"></div>  -->
</body>
</html>
