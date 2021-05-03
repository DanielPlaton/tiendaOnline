<html>
<head>
<title>Alta usuario</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/formularioAltaRoles.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/enlacesBotones.css">
</head>
<body>
<div>
<h1 class="h1AltaRol">Alta rol</h1>
<jsp:include page="/jsp/cabecera.jsp" flush="false"/>
	<form class="AltaRol-form" METHOD="POST"
		ACTION="http://localhost:8080/tiendaOnline/webAltaRol">
    <input type="text" name="rol" placeholder="Introduce un rol nuevo" />
    <br></br>
	<INPUT type="SUBMIT" VALUE="Aceptar">
	</form>
	</div>
</body>
</html>