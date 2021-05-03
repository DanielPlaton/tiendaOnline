<html>
<head>
<title>Alta usuario</title>
<link rel="stylesheet" href="css/formularioAltaCategoria.css">
<link rel="stylesheet" href="css/enlacesBotones.css">

</head>
<body>
	<div>

		<h1 class="h1AltaCategoria">Alta Categoria</h1>
		<jsp:include page="/jsp/cabecera.jsp" flush="false" />
		<div>
			<form class="h1AltaCategoria" METHOD="post"
				ACTION="http://localhost:8080/tiendaOnline/webAltaCategoria" name="formCategoria">
				<input type="text" name="nombre" placeholder="Introduce un nombre categoria" />
				<br></br>
					<textarea name="descripcion"></textarea>
					<br></br> 
					<INPUT
					type="SUBMIT" VALUE="Aceptar">
			</form>

		</div>
</body>
</html>