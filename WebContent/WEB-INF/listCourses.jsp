<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des cours disponibles</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<%@ page import="model.Cours,java.util.List" %>
<% String connected = (String) session.getAttribute("connected");%>
<% String pseudo = (String) session.getAttribute("login");%>
<% List<Cours> listCourses = (List<Cours>) session.getAttribute("listCours");%>
<% if(connected == "true"){%>
<body>
	<div class="container">
		<h1>Les cours disponibles</h1>
		<% for(Cours c : listCours) {%>
				<tr>
					<td><%= c.getPeriode() %></td>
				</tr>
		<% } %>
		
	</div>
<% } else{%>
	NOTHING TO SHOW
<%} %>
</body>
</html>