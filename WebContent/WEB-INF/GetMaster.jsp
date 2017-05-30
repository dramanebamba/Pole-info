<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<%@ page import="main.java.io.github.dramanebamba.pole_info.model.Master,java.util.List" %>
<% String connected = (String) session.getAttribute("connected");%>
<% String pseudo = (String) session.getAttribute("login");%>
<% List<Master> listeDesMasters = (List<Master>) session.getAttribute("listMaster");%>
<% if(connected == "true" && pseudo.equals("admin")){%>
<body>
	<div class="container">
	<h1>Liste des masters</h1>
		<div class="row">
		<table class="table">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Description</th>
					<th>Frequentation</th>
				</tr>
			</thead>
			<tbody>
		<% for(Master c : listeDesMasters) {%>
				<tr>
					<td><%= c.getNom() %></td>
					<td><%= c.getDesc()  %></td>
					<td><a href="./GetMasterDetailsServlet?id=<%= c.getId()%>"> D&eacute;tails Master </a></td>
					<td class="test-align">
						<a href="./GetMasterServlet?operation=remove&id=<%= c.getId()%>">
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
