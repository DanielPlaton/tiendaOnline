<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, modelo.*, DAO.*,utils.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/enlacesBotones.css">
<link rel="stylesheet" href="../css/formulariocss.css">
<meta charset="ISO-8859-1">
<title>Menu Principal</title>
</head>
<body>


	<h1 align="center">Menu principal</h1>
	<jsp:include page="/jsp/cabecera.jsp" flush="true"/>
	<div class="divBoton">
		
		<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/jsp/formularioListarUsuario.jsp">Listar
			Usuarios</a>
			<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/jsp/formularioListarRoles.jsp">Listar
			Roles</a>
	</div>
	<br></br>
</body>
</html>