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
<title>Masters &amp; Contenus</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link href="css/coming-sssoon.css" rel="stylesheet" />

<!--     Fonts     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Grand+Hotel'
	rel='stylesheet' type='text/css'>
</head>
<% 	String connected = (String) session.getAttribute("connected");
	String pseudo = (String) session.getAttribute("login");
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
		<h1 class="page-header">Création de master</h1>
		<!-- <p class="lead">Un responsable peut créer un master</p> -->

		<form class="form-horizontal" action="./PostMasterServlet"
			method="post">
			<div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Intitulé
					du master</label>
				<div class="col-sm-10">
					<input type="text" name="nom" class="form-control"
						placeholder="M2 MIAGE SITN">
				</div>
			</div>
			<div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Description
					du master</label>
				<div class="col-sm-10">
					<input type="text" name="description" class="form-control"
						placeholder="Système d'information et technologies nouvelles">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Créer</button>
				</div>
			</div>
		</form>
		<a href="./GetMasterServlet">Voir la liste des masters</a>
	</div>
</body>
<% } %>
</html>
