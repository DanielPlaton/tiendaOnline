<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, modelo.*, DAO.*,utils.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="enlacesBotones.css">
<link rel="stylesheet" href="formulariocss.css">
<meta charset="ISO-8859-1">
<title>Menu Principal</title>
</head>
<body>


	<h1 align="center">Menu principal</h1>
	<jsp:include page="/cabecera.jsp" flush="true"/>
	<div class="divBoton">

		<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/formularioAltaUsuario.jsp">Alta
			Usuarios</a> 
		<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/formularioAltaRoles.jsp">Alta
			Roles</a>
			
		<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/formularioListarUsuario.jsp">Listar
			Usuarios</a>
			<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/formularioListarRoles.jsp">Listar
			Roles</a>
	</div>
	<br></br>
</body>
</html>