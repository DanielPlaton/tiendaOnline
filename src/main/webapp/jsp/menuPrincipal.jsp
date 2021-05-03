<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, modelo.*, DAO.*,utils.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/enlacesBotones.css">
<link rel="stylesheet" href="css/formulariocss.css">
<meta charset="ISO-8859-1">
<title>Menu Principal</title>
</head>
<body>


	<h1 align="center">Menu principal</h1>
	<jsp:include page="/jsp/cabecera.jsp" flush="true" />
	<div class="divBoton">

		<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/jsp/formularioAltaUsuario.jsp">Alta
			Usuarios</a> 
		<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/jsp/formularioAltaRoles.jsp">Alta
			Roles</a> 
		<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/jsp/formularioAltaCategoria.jsp">Alta
			Categorias</a> 
			
				<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/jsp/formularioAltaProducto.jsp">Alta
			Producto</a> 
		<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/jsp/formularioListarUsuario.jsp">Listar
			Usuarios</a> 
			
		<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/jsp/formularioListarRoles.jsp">Listar
			Roles</a>
			<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/jsp/formularioListarCategoria.jsp">Listar
			Categorias</a>
			
					<a class="enlaceboton"
			href="http://localhost:8080/tiendaOnline/jsp/formularioListarProducto.jsp">Listar
			Productos</a>
	</div>
	<br></br>
</body>
</html>