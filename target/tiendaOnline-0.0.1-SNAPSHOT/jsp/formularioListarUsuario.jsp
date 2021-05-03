<%@ page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, modelo.*, DAO.*,utils.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar usuarios</title>
<link rel="stylesheet" href="css/formulariocss.css">
<link rel="stylesheet" href="css/enlacesBotones.css">
</head>
<body>
<jsp:include page="/jsp/cabecera.jsp" flush="false"/>
<%
	//recogemos los usuarios
	Session s = HibernateUtil.getSessionFactory().openSession();
	List<Usuarios> listaUsuarios = UsuarioDAO.getAllUsuarios(s);
	s.close();
	
	pageContext.setAttribute("listaUsuarios", listaUsuarios);
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