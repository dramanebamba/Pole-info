<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<%@ page import="pole_info.Backup,java.util.List" %>
<% String connected = (String) session.getAttribute("connected");%>
<% String pseudo = (String) session.getAttribute("login");%>
<% List<Backup> listBackup = (List<Backup>) session.getAttribute("listBackup");%>
<% if(connected == "true" && pseudo.equals("admin")){%>
<body>
	<div class="container">
	<h1>Liste des sauvegardes de la base de données</h1>
		<div class="row">
		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Date de la sauvegarde</th>
					<th>&Eacute;tiquette</th>
					<th>Supprimer</th>
					<th>Restaurer</th>
				</tr>
			</thead>
			<tbody>
		<% for(Backup b : listBackup) {%>
				<tr>
					<td><%= b.getIdBackup() %></td>
					<td><%= b.getDate()  %></td>
					<td><%= b.getLabel() %></td>
					<td class="test-align">
						<a href="GetManageBackupServlet?operation=remove&id=<%=b.getIdBackup() %>">
						<span class="glyphicon glyphicon-trash"></span>
						</a>
					</td>
					<td class="text-align">
						<a href="GetManageBackupServlet?operation=restore&id=<%=b.getIdBackup() %>">
						<span class="glyphicon glyphicon-upload"></span>
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