<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des cours</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
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
