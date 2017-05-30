<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<%@ page import="main.java.io.github.dramanebamba.pole_info.model.Master,java.util.List" %>
<% String connected = (String) session.getAttribute("connected");%>
<% String pseudo = (String) session.getAttribute("login");%>
<% int nb_student = (Integer) session.getAttribute("nbStudent");%>
<% if(connected == "true" && pseudo.equals("admin")){%>
<body>
	<h1> <%= nb_student %> </h1>	
<% } else{%>
	NOTHING TO SHOW
<%} %>
</body>
</html>