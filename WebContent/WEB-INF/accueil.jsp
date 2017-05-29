<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<link rel="apple-touch-icon" sizes="76x76" href="images/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="images/favicon.png">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
	<title>Menu</title>
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
	<link href="css/coming-sssoon.css" rel="stylesheet" />

    <!--     Fonts     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>
</head>
<% String connected = (String) session.getAttribute("connected"); %>
<% String pseudo = (String) session.getAttribute("login"); %>
<% String role = (String) session.getAttribute("roles"); %>
<% int id_ma = (Integer) session.getAttribute("id_m"); %>
<% if (connected == "true") { %>
<body>

	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="./accueil">Pole Info</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="./accueil">Menu</a></li>
	      <li><a href="#">&Eacute;tudiant</a></li>
	      <li><a href="#">Enseignant</a></li>
	      <li><a href="#">Base de donn&eacute;es</a></li>
	      <li><a href="#">Exports JSON</a></li>
	      <li><a href="#">Masters & Contenus</a></li>
	      <li><a href="#">Affectations</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
      		<!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
      		<li>
      			<a href="">
      				<form action="./identification?operation=logout" method="post">
						<button class="btn-link" type="submit">
							<span class="glyphicon glyphicon-log-out"></span> Se déconnecter
						</button>
					</form>
				</a>
			</li>
    	</ul>
	  </div>
	</nav>

	<div class="container">
		<!-- <h1>Menu</h1> -->
		<% if (role.equals("S")) { // Etudiant %>
			<h2>Enseignements</h2>
			<a class="btn btn-default" href="./PostPreferenceServlet"> Indiquer mes
			pr&eacute;f&eacute;rences </a><br /> <br />
		<% } else if (role.equals("M")) { // Enseignant %>
		<h2>&Eacute;tudiant</h2>
<<<<<<< HEAD
		<a class="btn btn-default" href="./creationEtudiant"> Cr&eacute;ation d'un &Eacute;tudiant</a>
		<br /> <br /> 
=======
		<a href="./creationEtudiant"> Cr&eacute;ation d'un &Eacute;tudiant
		</a><br /> <br /> <a href="./PostPreferenceServlet"> Indiquer ses
			pr&eacute;f&eacute;rences </a><br /> <br />
>>>>>>> branch 'master' of https://github.com/dramanebamba/pole_info.git
		<a href="./listStudents?id=<%=id_ma%>"> Visualiser la liste des etudiants </a>
		<br /> <br />

		<h2>Enseignant</h2>
		<a class="btn btn-default" href="./creationEnseignant"> Cr&eacute;ation d'un enseignant </a><br />
		<br />
		<% if (pseudo.equals("admin")) { %>

		<h2>Base de donn&eacute;es</h2>
		<a class="btn btn-warning" href="./GetBackupServlet"> Liste des sauvegardes de la base de
			donn&eacute;es </a><br /> <br /> <a class="btn btn-warning" href="./GetCreateBackupServlet">
			Cr&eacute;er une sauvegarde de la base de donn&eacute;es </a><br /> <br />
		<!-- <a href="./GetRestoreBackupServlet"> Restaurer la derni&eacute;re
			sauvegarde de la base de donn&eacute;es </a><br /> <br /> -->

		<h2>Exportations JSON</h2>
		<form action="./listCourses?operation=getlistCourses" method="post">
			<button class="btn btn-info" type="submit">Exportation
				fichier JSON des affectations des &eacute;tudiants a un cours</button>
		</form>
		<br />
		<form action="./listParcours?operation=getlistParcours" method="post">
			<button class="btn btn-info" type="submit">Exportation
				fichier JSON des enseigants responsables des cours d'un parcours</button>
		</form>
		<br />

		<h2>Gestion des masters et contenus</h2>
		<a class="btn btn-default" href="./PostContenuServlet"> G&eacute;rer les contenus d'un cours</a><br />
		<br />
		<a class="btn btn-default" href="./PostMasterServlet"> G&eacute;rer les masters</a><br />

		<h2>Gestion des affectation</h2>
		<a class="btn btn-default" href="./AffectationMaster"> Affecter un &eacute;tudiant aux cours facultatifs</a><br />
		<br />
		
		<h2>Gestion des cours</h2>
		<a href="./PostCoursServlet"> Création de cours obligatoires/facultatifs</a><br />
		<br />
		
		<% } %>
		<% } else { %>
		<br />
		Erreur: Votre compte n'est ni un Enseignant, ni un &Eacute;tudiant, veuillez contacter l'administrateur.
		<br />
		<% } %>
		<!-- <form action="./identification?operation=logout" method="post">
			<button class="btn btn-danger" type="submit">Se
				d&eacute;connecter</button>
		</form> -->
		<br />
	</div>
	<% } else { %>
	<br />
	Erreur : vous n'&ecirc;tes plus connect&eacute;.
	<br />
	<% } %>
</body>
</html>
