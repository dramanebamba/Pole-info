<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="utf-8" />
			<title>Choisir un cours facultatif</title>
			<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
		</head>
		<body>
			<div class="container">
				<h1>Mes préférences</h1>
			<!--<p class="lead">Un étudiant peut entrer ses préférences concernant les cours facultatifs auxquels il a accès.</p>-->

				<form method="post" action="Preferences">
					<fieldset>
						<legend>Préférences</legend>
						<p>Vous pouvez indiquer vos préférences ici.</p>
						<c:forEach items="${ messages }" var="message" varStatus="boucle">
							<input type="checkbox" value =message> ${ message }</input><br />
						</c:forEach>
						<input type="submit" value="Valider" class="sansLabel" /> <br />
					</fieldset>
				</form>
			</div>

		</body>
	</html>
