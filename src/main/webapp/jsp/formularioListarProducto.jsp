<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, modelo.*, DAO.*,utils.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Productos</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/formulariocss.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/enlacesBotones.css">
</head>
<body>
	<jsp:include page="/jsp/cabecera.jsp" flush="false" />

	<%
	//recogemos los usuarios
	Session s = HibernateUtil.getSessionFactory().openSession();
	List<Productos> listaProductos = ProductosDAO.getAllProductos(s);
	s.close();
	%>

	<%
	//cargamos los roles	

	pageContext.setAttribute("listaProductos", listaProductos);
	%>
	<br></br>
	<table class="table" border='solid'>
		<tr>
			<th>categorias</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>precio</th>
			<th>stock</th>
			<th>fecha_alta</th>
			<th>fecha_baja</th>
			<th>impuesto</th>

		</tr>

		<c:forEach varStatus="status" var="producto"
			items="${pageScope.listaProductos}" begin="0"
			end="${pageScope.listaProductos.size() - 1}">
			<tr>
				<td><c:out value="${producto.categorias}" /></td>
				<td><c:out value="${producto.nombre}" /></td>
				<td><c:out value="${producto.descripcion}" /></td>
				<td><c:out value="${producto.precio}" /></td>
				<td><c:out value="${producto.stock}" /></td>
				<td><c:out value="${producto.fecha_alta}" /></td>
				<td><c:out value="${producto.fecha_baja}" /></td>
				<td><c:out value="${producto.impuesto}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>