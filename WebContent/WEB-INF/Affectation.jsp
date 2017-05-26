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
		<%@ page import="main.java.io.github.dramanebamba.pole_info.model.Contenu,java.util.List" %>
		<% String connected = (String) session.getAttribute("connected");%>
		<% String pseudo = (String) session.getAttribute("login");%>
		<% List<Object[]> listCours = (List<Object[]>) session.getAttribute("listCours");%>
		<% List<Object[]> idCours = (List<Object[]>) session.getAttribute("idCours");%>
		<% if(connected == "true" && pseudo.equals("admin")){%>
    <body>
      <div class="container">
        <h1>Affectation des étudiants</h1>
        <a href="./GetAffectationServlet">Voir la liste des affectations</a>
        <p class="lead">Un responsable peut affecter un étudiant aux cours facultatifs</p>

        <form class="form-horizontal" action="./AffectationServlet" method="post">
              <div class="form-group">
                <label for="exampleInputName2" class="col-sm-2 control-label">Sélectionner un cours facultatif</label>
                <div class="col-sm-10">
                  <select class="form-control" name="id">
										<% for(Object c : idCours) {%>
													<<option><%= c.toString() %></option>>
										<% } %>

                  </select>
                </div>
              </div>
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
