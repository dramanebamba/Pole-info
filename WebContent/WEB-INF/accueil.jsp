<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<% String connected = (String) session.getAttribute("connected"); %>
<% String pseudo = (String) session.getAttribute("login"); %>
<% String role = (String) session.getAttribute("roles"); %>
<% int id_ma = (Integer) session.getAttribute("id_m"); %>
<% if (connected == "true") { %>
<body>
	<div class="container">
		<h1>Menu</h1>
		<br />
		<% if (role.equals("S")) { // Etudiant %>
		CE QUE PEUT FAIRE L'ETUDIANT
		<% } else if (role.equals("M")) { // Enseignant %>
		<h2>&Eacute;tudiant</h2>
		<a href="./creationEtudiant"> Cr&eacute;ation d'un &Eacute;tudiant
		</a><br /> <br /> <a href="./PostPreferenceServlet"> Indiquer ses
			pr&eacute;f&eacute;rences </a><br /> <br />
		<a href="./listStudents?id=<%=id_ma%>"> Visualiser la liste des etudiants </a>
		<br /> <br />

		<h2>Enseignant</h2>
		<a href="./creationEnseignant"> Cr&eacute;ation d'un enseignant </a><br />
		<br />
		<% if (pseudo.equals("admin")) { %>

		<h2>Base de donn&eacute;es</h2>
		<a href="./GetBackupServlet"> Liste des sauvegardes de la base de
			donn&eacute;es </a><br /> <br /> <a href="./GetCreateBackupServlet">
			Cr&eacute;er une sauvegarde de la base de donn&eacute;es </a><br /> <br />
		<!-- <a href="./GetRestoreBackupServlet"> Restaurer la derni&eacute;re
			sauvegarde de la base de donn&eacute;es </a><br /> <br /> -->

		<h2>Exportations JSON</h2>
		<form action="./listCourses?operation=getlistCourses" method="post">
			<button class="btn btn-primary" type="submit">Exportation
				fichier JSON des affectations des &eacute;tudiants a un cours</button>
		</form>
		<br />
		<form action="./listParcours?operation=getlistParcours" method="post">
			<button class="btn btn-primary" type="submit">Exportation
				fichier JSON des enseigants responsables des cours d'un parcours</button>
		</form>
		<br />

		<h2>Gestion des masters et contenus</h2>
		<a href="./PostContenuServlet"> G&eacute;rer les contenus d'un cours</a><br />
		<br />
		<a href="./PostMasterServlet"> G&eacute;rer les masters</a><br />

		<h2>Gestion des affectation</h2>
		<a href="./AffectationMaster"> Affecter un &eacute;tudiant aux cours facultatifs</a><br />
		<br />
		<% } %>
		<% } else { %>
		<br />
		Erreur: Votre compte n'est ni un Enseignant, ni un �tudiant, veuillez contacter l'administrateur.
		<br />
		<% } %>
		<form action="./identification?operation=logout" method="post">
			<button class="btn btn-danger" type="submit">Se
				d&eacute;connecter</button>
		</form>
		<br />
	</div>
	<% } else { %>
	<br />
	Erreur : vous n'�tes plus connect�.
	<br />
	<% } %>
</body>
</html>
