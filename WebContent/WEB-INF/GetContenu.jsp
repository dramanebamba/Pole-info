<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<%@ page import="main.java.io.github.dramanebamba.pole_info.model.Contenu,java.util.List" %>
<% String connected = (String) session.getAttribute("connected");%>
<% String pseudo = (String) session.getAttribute("login");%>
<% List<Contenu> listeDesContenus = (List<Contenu>) session.getAttribute("listContenu");%>
<% if(connected == "true" && pseudo.equals("admin")){%>
<body>
	<div class="container">
	<h1>Liste des contenus de cours</h1>
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
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
		<% for(Contenu c : listeDesContenus) {%>
				<tr>
					<td><%= c.getNomMat() %></td>
					<td><%= c.getDesc()  %></td>
					<td><%= c.getApp() %></td>
					<td><%= c.getVolHoraire() %></td>
					<td><%= c.getEcts() %></td>
					<td><%= c.getVolume_projet() %></td>
					<td><%= c.getObj() %></td>
					<td><%= c.getContent() %></td>
					<td><%= c.getBiblio() %></td>
					<td class="test-align">
						<a href="./GetContenuServlet?operation=remove&id=<%= c.getId()%>">
						<span class="glyphicon glyphicon-trash"></span>
						</a>
					</td>
				</tr>
		<% } %>
		</tbody>
		</table>
		</div>
		<br/>
		<div class="row">
			<a class="btn btn-danger" href="./accueil">Annuler</a>
		</div>
	</div>
<% } else{%>
	NOTHING TO SHOW
<%} %>
</body>
</html>
