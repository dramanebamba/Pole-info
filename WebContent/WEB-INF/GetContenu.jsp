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
<%@ page
	import="main.java.io.github.dramanebamba.pole_info.model.Master,
		main.java.io.github.dramanebamba.pole_info.model.Contenu,
		java.util.HashMap,
		java.util.List,main.java.io.github.dramanebamba.pole_info.service.CoursDAO"%>
<%
	String connected = (String) session.getAttribute("connected");
	String pseudo = (String) session.getAttribute("login");
	
	@SuppressWarnings("unchecked")
	List<Contenu> listeDesContenus = (List<Contenu>) session.getAttribute("listContenu");
	
	@SuppressWarnings("unchecked")
	HashMap<Contenu, List<Master>> listMasters = (HashMap<Contenu, List<Master>>) session
			.getAttribute("listMasters");
	
	@SuppressWarnings("unchecked")
	List<Master> listAllMasters = (List<Master>) session.getAttribute("listAllMasters");
	if (connected == "true") 
	{
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
		<h1 class="page-header">Liste des contenus de cours</h1>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Description</th>
						<th>Apprentissage</th>
						<th>Horaires</th>
						<th>ECTS</th>
						<th>Projet</th>
						<th>Objectifs</th>
						<th>Contents</th>
						<th>Biblio</th>
						<th>Supprimer</th>
						<th>Parcours lié</th>
						<th>Facultatif</th>
					</tr>
				</thead>
				<tbody>
				<%
					for (Contenu c : listeDesContenus) // On affiche une ligne pour chaque contenu
						{
							// On place une ligne pour chaque master lié à ce contenu
							for (Master m : listMasters.get(c)) // 
							{
								String name_master = m.getNom(); // Recuperation du nom du master lié
								int id_master = m.getId();
								
								// Recuperation de la valeur du champs "obligatoire" de ce contenu pour ce master
								String obligatoire_final = (new CoursDAO().getObligatoire(c.getId(), id_master)
										.equals("O")) ? "Non" : "Oui";
				%>
				<tr>
					<td><%=c.getNomMat()%></td>
					<td><%=c.getDesc()%></td>
					<td><%=c.getApp()%></td>
					<td><%=c.getVolHoraire()%></td>
					<td><%=c.getEcts()%></td>
					<td><%=c.getVolume_projet()%></td>
					<td><%=c.getObj()%></td>
					<td><%=c.getContent()%></td>
					<td><%=c.getBiblio()%></td>
					<td class="test-align"><a
						href="./GetContenuServlet?operation=remove&id=<%=c.getId()%>">
							<span class="glyphicon glyphicon-trash"></span>
					</a></td>
					<td><form method="post" action="/pole_info/GetContenuServlet?operation=changeMaster">
							<p>
								<select name="changeMaster" onchange="this.form.submit()">
									<%
									for (Master masterAll : listAllMasters) 
									{
										if (masterAll.getNom().equals(name_master)) 
										{
										%>
											<option value=<%=(Integer.toString(id_master)+"/"+Integer.toString(masterAll.getId())+"/"+Integer.toString(c.getId()))%> selected><%=masterAll.getNom()%></option>
										<%
										} else {
										%>
											<option value=<%=(Integer.toString(id_master)+"/"+Integer.toString(masterAll.getId())+"/"+Integer.toString(c.getId()))%>><%=masterAll.getNom()%></option>
										<%
										}
									}
									%>
								</select>
							</p>
						</form></td>
					<td>
					<form method="post" 
					action="/pole_info/GetContenuServlet?operation=changeObligation">
						<p>
							<select name="changeObli" onchange="this.form.submit()">
								<option value=<%=Integer.toString(c.getId())+"/"+Integer.toString(id_master)+"/"+obligatoire_final%> selected><%= obligatoire_final %></option>
								<option value=<%=Integer.toString(c.getId())+"/"+Integer.toString(id_master)+"/"+obligatoire_final%>><%= (obligatoire_final.equals("Non"))?"Oui":"Non" %></option>
							</select>
						</p>
					</form>
					</td>
					</tr>
					<%
						}
							}
					%>
				</tbody>
			</table>
		</div>
		<br />
		<!-- <div class="row">
			<a class="btn btn-danger" href="./accueil">Annuler</a>
		</div> -->
	</div>
	<%
		} else {
	%>
	NOTHING TO SHOW
	<%} %>
</body>
</html>
