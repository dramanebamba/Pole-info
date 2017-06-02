<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<%-- VARIABLES ET IMPORTS --%>
<%@ page pageEncoding="UTF-8"%>
<%@ page
	import="main.java.io.github.dramanebamba.pole_info.model.Personne,java.util.List,main.java.io.github.dramanebamba.pole_info.model.*"%>
<%
	String connected = (String) session.getAttribute("connected");
	String pseudo = (String) session.getAttribute("login");
	
	@SuppressWarnings("unchecked")
	List<Affectation> numAffectation = (List<Affectation>) session.getAttribute("numAffectation");
	
	Contenu nom_contenu = (Contenu) session.getAttribute("nom_contenu");
	String nom_master = (String) request.getAttribute("nom_master");
	
	@SuppressWarnings("unchecked")
	List<Personne> affectedStudents = (List<Personne>) session.getAttribute("affectedStudents");
	if (connected == "true" && pseudo.equals("admin")) {
%>

<body>
	<div class="container">
		<h1>
			Consulter les affectations -
			<%
			out.println(nom_master + " - " + nom_contenu.getNomMat());
		%>
		</h1>
		<p class="lead">
			Nombre d'étudiant affecté à ce cours :
			<%
			out.println(numAffectation);
		%>
		</p>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>Prénom</th>
						<th>Nom</th>
						<th>Notes</th>
						<th>Année</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Personne p : affectedStudents) {
					%>
					<tr>
						<td><%=p.getPrenom()%></td>
						<td><%=p.getNom()%></td>
						<td><%=p.getNotes()%></td>
						<td><%=p.getAnnee_master()%></td>
						<td class="test-align"><a
							href="./GetAffectation?operation=remove&id="> <span
								class="glyphicon glyphicon-trash"></span>
						</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<br />
		<div class="row">
			<a class="btn btn-danger" href="./accueil">Annuler</a>
		</div>
	</div>
	<%
		} else {
	%>
	NOTHING TO SHOW
	<%} %>
</body>
</html>
