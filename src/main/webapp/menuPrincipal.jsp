<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, modelo.*, DAO.*,utils.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Principal</title>
</head>
<body>

	<%!//recogemos los usuarios
	Session s = HibernateUtil.getSessionFactory().openSession();
	List<Usuarios> listaUsuarios = UsuarioDAO.getAllUsuarios(s);%>
	<%
	//cargamos los usuarios	
	pageContext.setAttribute("listaUsuarios", listaUsuarios);
	%>
	<h1>Menu principal</h1>

	<h3>Bienvenido, ${sessionScope.clientName}.</h3>

	<a href="/formularioAltaUsuario">Alta Usuarios</a>
	<br></br>
	<table border='solid'>
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

		<c:forEach varStatus="status" var="usuario"
			items="${pageScope.listaUsuarios}" begin="0"
			end="${pageScope.listaUsuarios.size() - 1}">
			<tr>
				<td><c:out value="${usuario.roles}" /></td>
				<td><c:out value="${usuario.email}" /></td>
				<td><c:out value="${usuario.clave}" /></td>
				<td><c:out value="${usuario.nombre}" /></td>
				<td><c:out value="${usuario.apellido1}" /></td>
				<td><c:out value="${usuario.apellido2}" /></td>
				<td><c:out value="${usuario.direccion}" /></td>
				<td><c:out value="${usuario.localidad}" /></td>
				<td><c:out value="${usuario.provincia}" /></td>
				<td><c:out value="${usuario.telefono}" /></td>
				<td><c:out value="${usuario.dni}" /></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>