
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, modelo.*, DAO.*,utils.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar usuarios</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/formulariocss.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/enlacesBotones.css">
</head>
<body>
	<jsp:include page="/jsp/cabecera.jsp" flush="false" />
	<%
	//recogemos los usuarios
	List<Usuarios> listaUsuarios = (List<Usuarios>) request.getAttribute("listaUsuarios");
	%>

	<table class="table" border='solid'>
		<tr>
			<th>Rol</th>
			<th>Email</th>
			<th>Clave</th>
			<th>nombre</th>
			<th>apellido 1</th>
			<th>apellido 2</th>
			<th>direccion</th>
			<th>localidad</th>
			<th>provincia</th>
			<th>telefono</th>
			<th>dni</th>
		</tr>


		<%
		for (int i = 0; i < listaUsuarios.size(); i++) {
		%>
		<tr>
			<td><%=String.valueOf(listaUsuarios.get(i).getRoles())%></td>
			<td><%=listaUsuarios.get(i).getEmail().toString()%></td>
			<td><%=listaUsuarios.get(i).getClave().toString()%></td>
			<td><%=listaUsuarios.get(i).getNombre().toString()%></td>
			<td><%=listaUsuarios.get(i).getApellido1().toString()%></td>
			<td><%=listaUsuarios.get(i).getApellido2().toString()%></td>
			<td><%=listaUsuarios.get(i).getDireccion().toString()%></td>
			<td><%=listaUsuarios.get(i).getLocalidad().toString()%></td>
			<td><%=listaUsuarios.get(i).getProvincia().toString()%></td>
			<td><%=listaUsuarios.get(i).getTelefono().toString()%></td>
			<td><%=listaUsuarios.get(i).getDni().toString()%></td>
			</tr>
		<%
		}
		%>
	</table>
</body>
</html>