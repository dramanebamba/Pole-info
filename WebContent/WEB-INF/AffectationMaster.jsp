<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Affectation des étudiants</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<%@ page
	import="main.java.io.github.dramanebamba.pole_info.model.Master,java.util.List"%>
<% String connected = (String) session.getAttribute("connected");
     String pseudo = (String) session.getAttribute("login");
     
     @SuppressWarnings("unchecked")
     List<Master> listMaster = (List<Master>) session.getAttribute("listMaster");
     if(connected == "true"){%>
<body>
	<div class="container">
		<h1>Affectation des étudiants</h1>
		<a href="./GetAffectationMaster">Voir la liste des affectations</a>
		<form class="form-horizontal" action="./AffectationCours"
			method="post">
			<div class="form-group">
				<label for="exampleInputName2" class="col-sm-2 control-label">Sélectionner
					un master</label>
				<div class="col-sm-10">
					<select class="form-control" name="id_master">
						<% for(Master m : listMaster) {%>
						<option value="<%= m.getId() %>"><%= m.getNom() %></option>
						<% } %>
					</select>
				</div>
			</div>
			<% for(Master m : listMaster) {%>
			<input type="hidden" name="nom_master" value="<%= m.getNom() %>">
			<% } %>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Valider</button>
				</div>
			</div>
		</form>
	</div>
	<% } else{%>
	NOTHING TO SHOW
	<%} %>
</body>
</html>
