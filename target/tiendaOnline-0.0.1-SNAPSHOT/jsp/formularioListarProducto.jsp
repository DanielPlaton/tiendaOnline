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
	//recogemos los productos
	List<Productos> listaProductos = (List<Productos>) request.getAttribute("listaProductos");
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

		<%
		for (int i = 0; i < listaProductos.size(); i++) {
		%>	<tr>
			<td><%=String.valueOf(listaProductos.get(i).getCategorias())%></td>
			<td><%=listaProductos.get(i).getNombre().toString()%></td>
			<td><%=listaProductos.get(i).getDescripcion().toString()%></td>
			<td><%=listaProductos.get(i).getPrecio().toString()%></td>
			<td><%=listaProductos.get(i).getStock().toString()%></td>
			<td><%=listaProductos.get(i).getApellido2().toString()%></td>
			<td><%=listaProductos.get(i).getDireccion().toString()%></td>
			<td><%=listaProductos.get(i).getLocalidad().toString()%></td>
			<td><%=listaProductos.get(i).getProvincia().toString()%></td>
			<td><%=listaProductos.get(i).getTelefono().toString()%></td>
			
			</tr>
		<%
		}
		%>
	</table>
</body>
</html>