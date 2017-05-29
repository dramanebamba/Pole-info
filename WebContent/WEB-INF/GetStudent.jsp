<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des etudiants</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<%@ page
	import="main.java.io.github.dramanebamba.pole_info.model.Master,
		main.java.io.github.dramanebamba.pole_info.model.Contenu,
		java.util.HashMap,
		java.util.List,pole_info.CoursDAO,
		pole_info.Personne"%>
<%
	String connected = (String) session.getAttribute("connected");
	
	@SuppressWarnings("unchecked")
	List<Personne> listeStudents = (List<Personne>) session.getAttribute("listStudent");
	
	if (connected == "true") 
	{
%>
<body>
	<div class="container">
		<h1>Liste des contenus de cours</h1>
		<div class="row">
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
		<br />
		<div class="row">
			<a class="btn btn-danger" href="./accueil">Revenir a la page precedente</a>
		</div>
	</div>
	<%
		} else {
	%>
	NOTHING TO SHOW
	<%} %>
</body>
</html>
