<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<% String connected = (String) request.getAttribute("connected");%>
<% if(connected == "true"){%>
<body>
	<div class="container">
		<h1>Menu</h1>
		<a href="./creationEtudiant"> Création d'un étudiant </a><br />
		<br />
		<a href="./Preferences"> Indiquer ses préférences </a><br />
		<br />
		<form action="./identification?operation=logout" method="post">
			<button class="btn btn-danger" type="submit">Se déconnecter</button>
		</form>
		<br/>
	</div>
<% } else{%>
	NOTHING TO SHOW
<%} %>
</body>
</html>