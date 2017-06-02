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
<title>Liste des &eacute;tudiants</title>
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
	import="main.java.io.github.dramanebamba.pole_info.model.Master,
		main.java.io.github.dramanebamba.pole_info.model.Contenu,
		java.util.HashMap,
		java.util.List,main.java.io.github.dramanebamba.pole_info.service.CoursDAO,
		main.java.io.github.dramanebamba.pole_info.model.Personne"%>
<%
	String connected = (String) session.getAttribute("connected");

	@SuppressWarnings("unchecked")
	List<Personne> listeStudents = (List<Personne>) session.getAttribute("listStudent");

	if (connected == "true") {
%>
<body>
	<!-- style="background-image: url('images/student.jpeg'); background-repeat: repeat; background-size: cover" -->
	
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
			<li><a href="./GetManageMasterContenu">Masters &amp; Contenus</a></li>
			<li><a href="./GetManageAffectation">Affectations</a></li>
			<li><a href="./GetManageCours">Cours</a></li>
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
		<h1 class="page-header">Liste des contenus de cours</h1>
		<div class="row">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>Nom</th>
							<th>Prenom</th>
							<th>E-mail</th>
							<th>Telephone</th>
							<th>Fax</th>
							<th>Notes</th>
							<th>Master</th>
							<th>Annee de master</th>
							<th>Adresse</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Personne p : listeStudents) // On affiche une ligne pour chaque etudiant
								{
						%>
						<tr>
							<td><%=p.getNom()%></td>
							<td><%=p.getPrenom()%></td>
							<td><%=p.getEmail()%></td>
							<td><%=p.getTelephone()%></td>
							<td><%=p.getFax()%></td>
							<td><%=p.getNotes()%></td>
							<td><%=p.getId_master()%></td>
							<td><%=p.getAnnee_master()%></td>
							<td><%=p.getAdress()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
		<br />
		<!-- <div class="row">
			<a class="btn btn-danger" href="./accueil">Revenir a la page
				precedente</a>
		</div> -->
	</div>
	<%
		} else {
	%>
	NOTHING TO SHOW
	<%} %>
</body>
</html>
