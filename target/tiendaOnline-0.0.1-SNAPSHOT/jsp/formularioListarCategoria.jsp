<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, modelo.*, DAO.*,utils.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Categorias</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/formulariocss.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/enlacesBotones.css">
</head>
<body>
<jsp:include page="/jsp/cabecera.jsp" flush="false"/>

	<%
	//recogemos los usuarios
	Session s = HibernateUtil.getSessionFactory().openSession();
	List<Categoria> listaCategorias = CategoriaDAO.getAllCategoria(s);
	s.close();
	%>

	<%
	//cargamos los roles	

	pageContext.setAttribute("listaCategorias", listaCategorias);
	%>
<br></br>
	<table class="table" border='solid'>
		<tr>
			<th>Nombre</th>
			<th>Descripcion</th>
		</tr>

		<c:forEach varStatus="status" var="categoria"
			items="${pageScope.listaCategorias}" begin="0"
			end="${pageScope.listaCategorias.size() - 1}">
			<tr>
				<td><c:out value="${categoria.nombre}" /></td>
				<td><c:out value="${categoria.descripcion}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>