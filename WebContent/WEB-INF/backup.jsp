<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<title>Backup BDD</title>
</head>
<% String connected = (String) session.getAttribute("connected");%>
<% String pseudo = (String) session.getAttribute("login");%>
<% if(connected == "true" && pseudo != null){%>
<body>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" action="./PostCreateBackupServlet" method="post">
				<h1>Sauvegarde de la base de données</h1>
				<div class="form-group">
					<label for="etiq">&Eacute;tiquette</label>
					<input class="form-control" type="text" name="etiq" id="etiq"/>
				</div>
				<div class="form-group">
					<button class="btn btn-primary" type="submit">Sauvegarder la BDD</button>
				</div> 
			</form>
			
			<div class="row">
				<a class="btn btn-danger" href="./accueil">Annuler</a>
			</div>
		</div>	
	</div>
<% } else{%>
	NOTHING TO SHOW
<%} %>
</body>
</html>