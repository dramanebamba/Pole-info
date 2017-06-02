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
<title>Liste des contenus</title>
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
	if (connected == "true"){
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
		<h1 class="page-header">Création de contenu</h1>
		<!-- <p class="lead">Un responsable peut créer un contenu de cours</p> -->

		<form class="form-horizontal" action="./PostContenuServlet"
			method="post">
			<%-- <div class="form-group">
            <label for="exampleInputName2" class="col-sm-2 control-label">Identifiant du contenu</label>
            <div class="col-sm-10">
              <input type="text" name="id" class="form-control" placeholder="Entrer un id">
              </div>
          </div> --%>
			<div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Intitulé
					du contenu</label>
				<div class="col-sm-10">
					<input type="text" name="nom" class="form-control"
						placeholder="Entrer le nom du contenu ex : Maths, Décision...">
				</div>
			</div>
			<div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Description
					du contenu</label>
				<div class="col-sm-10">
					<input type="text" name="description" class="form-control"
						placeholder="Bref description du contenu du cours">
				</div>
			</div>
			<div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Apprentissage
					?</label>
				<div class="col-sm-10">
					<select class="form-control" name="apprentissage">
						<option>O</option>
						<option>N</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Volume
					horaire ?</label>
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
				<label for="exampleInputName2" class="col-sm-2 control-label">Volume
					projet (heures)</label>
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
					<input type="text" name="objectives" class="form-control"
						placeholder="Objectifs">
				</div>
			</div>
			<div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Contents</label>
				<div class="col-sm-10">
					<input type="text" name="contents" class="form-control"
						placeholder="contents">
				</div>
			</div>
			<div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Bibliographie</label>
				<div class="col-sm-10">
					<input type="text" name="biblio" class="form-control"
						placeholder="Références bibliographiques">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Créer</button>
				</div>
			</div>
		</form>
		<a href="./GetContenuServlet">Voir la liste des contenus</a>
	</div>
</body>
<% } %>
</html>
