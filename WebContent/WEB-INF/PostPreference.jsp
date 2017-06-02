<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link rel="apple-touch-icon" sizes="76x76" href="images/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="images/favicon.png">

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<title>Mes pr&eacute;f&eacute;rences</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link href="css/coming-sssoon.css" rel="stylesheet" />

<!--     Fonts     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Grand+Hotel'
	rel='stylesheet' type='text/css'>
</head>
<%@ page
	import="
	main.java.io.github.dramanebamba.pole_info.model.Contenu,
	main.java.io.github.dramanebamba.pole_info.model.Master,
	java.util.List"%>
<%
	@SuppressWarnings("unchecked")
	List<Master> listMaster = (List<Master>) session.getAttribute("listMaster");

	@SuppressWarnings("unchecked")
	List<Contenu> listContenu = (List<Contenu>) session.getAttribute("listContenu");
%>

<body>
	<div class="container">
		<h1>Création d'une pr&eacute;f&eacute;rence</h1>
		<a href="./GetPreferenceServlet">Voir la liste des préférences</a>

		<p class="lead">Un étudiant peut choisir ses préférences</p>

		<form class="form-horizontal"
			action="./PostCreatePreferenceServlet?operation=masterChoice"
			method="post">
			<div class="form-group">
				<label for="Master" class="col-sm-2 control-label">Master</label>
				<div class="col-sm-10">
					<!-- <input type="text" name="id_master" class="form-control" placeholder="Identifiant master"> -->
					<select class="form-control" id="id_master" name="id_master"
						onchange="this.form.submit()">
						<option value="0"></option>
						<%
							for (Master m : listMaster) {
						%>
						<option value="<%=m.getId()%>"><%=m.getNom()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
		</form>
		<form class="form-horizontal"
			action="./PostCreatePreferenceServlet?operation=postPreference"
			method="post">
			<div class="form-group">
				<label for="id_contenu" class="col-sm-2 control-label">Contenu</label>
				<div class="col-sm-10">
					<!-- <input type="text" name="id_contenu" class="form-control" placeholder="Identifiant du contenu"> -->
					<select class="form-control" id="id_contenu" name="id_contenu">
						<option value="0"></option>
						<%
							for (Contenu c : listContenu) {
						%>
						<option value="<%=c.getId()%>"><%=c.getNomMat()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
			<!-- <div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Identifiant
					de la personne</label>
				<div class="col-sm-10">
					<input type="text" name="id_personne" class="form-control"
						placeholder="Identifiant de la personne">
				</div>
			</div>  -->
			<div class="form-group">
				<label for="niveau" class="col-sm-2 control-label">Niveau</label>
				<div class="col-sm-10">
					<select id="niveau" name="niveau" class="form-control">
						<option></option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Créer</button>
					<a href="./accueil" class="btn btn-danger">Annuler</a>
				</div>
			</div>
		</form>
	</div>

</body>
</html>
