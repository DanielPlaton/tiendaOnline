<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, modelo.*, DAO.*,utils.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Rol</title>
<link rel="stylesheet" href="formulariocss.css">
<link rel="stylesheet" href="enlacesBotones.css">
</head>
<body>

	<%
	//recogemos los usuarios
	Session s = HibernateUtil.getSessionFactory().openSession();
	List<Roles> listaRoles = RolesDAO.getAllRoles(s);
	s.close();
	%>

	<%
	//cargamos los roles	

	pageContext.setAttribute("listaRoles", listaRoles);
	%>
<br></br>
	<table class="table" border='solid'>
		<tr>
			<th>Rol</th>
		</tr>

		<c:forEach varStatus="status" var="rol"
			items="${pageScope.listaRoles}" begin="0"
			end="${pageScope.listaRoles.size() - 1}">
			<tr>
				<td><c:out value="${rol.rol}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>