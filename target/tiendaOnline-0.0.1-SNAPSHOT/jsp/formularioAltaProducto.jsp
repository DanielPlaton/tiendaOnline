<html>
<head>
<title>Alta Productos</title>
<link rel="stylesheet" href="css/formularioAltaProducto.css">
<link rel="stylesheet" href="css/enlacesBotones.css">

</head>
<body>
	<div>

		<h1 class="h1AltaProducto">Alta Produtos</h1>
		<jsp:include page="/jsp/cabecera.jsp" flush="false" />
		<div>
			<form class="h1AltaProducto" METHOD="post"
				ACTION="http://localhost:8080/tiendaOnline/webAltaProducto">
				<input type="text" name="nombre"placeholder="Introduce un nombre categoria" /> 
			    <input type="text"	name="descripcion" placeholder="Introducce una descripcion" /> 
					<br></br>
				<input type="double" name="precio" placeholder="Introduce un precio" />
				<input type="int" name="stock"	placeholder="Introduce el stock" />
				 <br></br> 
				<input type="date" name="fecha_alta"	placeholder="Fecha alta" /> 
				<input type="date"name="fecha_baja" placeholder="Fecha de baja" /> 
					<br></br>
				<input type="float" name="impuesto"	placeholder="Introduce el impuesto" />
				<br></br>
				 <INPUT	type="SUBMIT" VALUE="Aceptar">


			</form>

		</div>
</body>
</html>