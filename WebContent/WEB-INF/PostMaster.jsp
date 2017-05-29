<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Ajouter un master</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<h1>Création de master</h1>
		<p class="lead">Un responsable peut créer un master</p>

		<form class="form-horizontal" action="./PostMasterServlet"
			method="post">
			<div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Intitulé
					du master</label>
				<div class="col-sm-10">
					<input type="text" name="nom" class="form-control"
						placeholder="M2 MIAGE SITN">
				</div>
			</div>
			<div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Description
					du master</label>
				<div class="col-sm-10">
					<input type="text" name="description" class="form-control"
						placeholder="Système d'information et technologies nouvelles">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Créer</button>
				</div>
			</div>
		</form>
		<a href="./GetMasterServlet">Voir la liste des masters</a>
	</div>

</body>
</html>
