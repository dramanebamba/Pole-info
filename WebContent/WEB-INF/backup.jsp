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
		<form action="./PostBackupServlet" method="post">
			<legend>Etiquette</legend>
			<div class="form-group row">
				<label class="col-sm-2 col-lg-2 col-form-label" for="label">Login</label>
				<div class="col-sm-10 col-lg-10">
					<textarea id="label" rows="5" class="form-control" placeholder="Insérer la description de la sauvegarde"/></textarea>
				</div>
			</div>
			
			<div class="form-group row">
				<button class="btn btn-primary" type="submit">Sauvegarder la BDD</button>
			</div> 
		</form>
		
		<div class="row">
			<a class="btn btn-danger" href="./accueil">Annuler</a>
		</div>
		
	</div>
<% } else{%>
	NOTHING TO SHOW
<%} %>
</body>
</html>