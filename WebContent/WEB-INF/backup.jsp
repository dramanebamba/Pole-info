<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<link rel="apple-touch-icon" sizes="76x76" href="images/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="images/favicon.png">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
	<title>Backup BDD</title>
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
	<link href="css/coming-sssoon.css" rel="stylesheet" />

    <!--     Fonts     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>
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