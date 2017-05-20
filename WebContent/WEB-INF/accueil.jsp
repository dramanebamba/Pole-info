<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<% String connected = (String) session.getAttribute("connected");%>
<% String pseudo = (String) session.getAttribute("login");%>
<% if(connected == "true"){%>
<body>
	<div class="container">
		<h1>Menu</h1>
		<a href="./creationEtudiant"> Cr&eacute;ation d'un &Eacute;tudiant </a><br />
		<br />
		<a href="./creationEnseignant"> Cr&eacute;ation d'un enseignant </a><br />
		<br />
		<a href="./PostPreferenceServlet"> Indiquer ses pr&eacute;f&eacute;rences </a><br />
		<br />
		<%if(pseudo.equals("admin")){ %>
			<a href="./GetBackupServlet"> Save da BDD </a><br />
			<br />
		<%} %>
		<br />
		<form action="./identification?operation=logout" method="post">
			<button class="btn btn-danger" type="submit">Se d&eacute;connecter</button>
		</form>
		<br/>
	</div>
<% } else{%>
	NOTHING TO SHOW
<%} %>
</body>
</html>