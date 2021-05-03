<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*, modelo.*, DAO.*,utils.*,org.hibernate.Session"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/formularioAltaUsuario.css">
<link rel="stylesheet" href="../css/enlacesBotones.css">
<title>Cabecera</title>

</head>
<body>

	<h3>Bienvenido, ${sessionScope.clientName}. ${sessionScope.fecha}.
	</h3>

	<div class="divVolverAtras">
		
			<a  name="volverAtras" class="enlaceboton" href="javascript:history.back()"> Volver Atrás</a>
			
			<a name="cerrarSesion" class="enlaceboton"
			onclick="cerrarSession"
			href="http://localhost:8080/tiendaOnline/jsp/formulario.jsp">Cerrar
			sesion</a> <br></br>

	</div>
</body>
</html>