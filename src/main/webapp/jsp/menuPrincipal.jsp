<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, modelo.*, DAO.*,utils.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/enlacesBotones.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/formulariocss.css">
<meta charset="ISO-8859-1">
<title>Menu Principal</title>
</head>
<body>


	<h1 align="center">Menu principal</h1>
	<jsp:include page="/jsp/cabecera.jsp" flush="true" />
	<div class="divBoton">

		<a class="enlaceboton"
			href=<%=request.getContextPath() %>/jsp/formularioAltaUsuario.jsp>Alta
			Usuarios</a> 
		<a class="enlaceboton"
			href=<%=request.getContextPath() %>/jsp/formularioAltaRoles.jsp>Alta
			Roles</a> 
		<a class="enlaceboton"
			href=<%=request.getContextPath() %>/jsp/formularioAltaCategoria.jsp>Alta
			Categorias</a> 
			
				<a class="enlaceboton"
			href=<%=request.getContextPath() %>/jsp/formularioAltaProducto.jsp>Alta
			Producto</a> 
		<a class="enlaceboton"
			href=<%=request.getContextPath() %>/WebListarUsuarios>Listar
			Usuarios</a> 
			
		<a class="enlaceboton"
			href=<%=request.getContextPath() %>/WebListarRoles>Listar
			Roles</a>
			<a class="enlaceboton"
			href=<%=request.getContextPath() %>/WebListarCategoria>Listar
			Categorias</a>
			
					<a class="enlaceboton"
			href=<%=request.getContextPath() %>/WebListarProducto>Listar
			Productos</a>
	</div>
	<br></br>
</body>
</html>