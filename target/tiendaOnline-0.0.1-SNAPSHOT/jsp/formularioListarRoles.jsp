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
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/formulariocss.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/enlacesBotones.css">
</head>
<body>
<jsp:include page="/jsp/cabecera.jsp" flush="false"/>

<%
	//recogemos los usuarios
	List<Roles> listaRoles = (List<Roles>) request.getAttribute("listaRoles");
	%>

<br></br>
	<table class="table" border='solid'>
		<tr>
			<th>Rol</th>
		</tr>
<%
		for (int i = 0; i < listaRoles.size(); i++) {
		%>
		<tr>
			<td><%=listaRoles.get(i).getRol()%></td>

			</tr>
		<%
		}
		%>
	</table>
</body>
</html>