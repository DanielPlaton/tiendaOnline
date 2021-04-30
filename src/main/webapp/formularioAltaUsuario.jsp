<html>
<head>
<title>Alta usuario</title>
<link rel="stylesheet" href="formularioAltaUsuario.css">
</head>
<body>
<div>
<h1 class="h1AltaUsuario">Alta usuarios</h1>
	<form class="h1AltaUsuario" METHOD="post"
		ACTION="http://localhost:8080/tiendaOnline/webAltaUsuario">
    <input type="text" name="email" placeholder="Introduce un email" />
	<input type="password" name="clave" placeholder="Introducce una clave" />
	   <br></br>
	<input type="text" name="nombre" placeholder="Introduce un nombre" />
	    <input type="text" name="apellido1" placeholder="Introduce el primer apellido" />
    <br></br>
	    <input type="text" name="apellido2" placeholder="Introduce el segundo apellido" />
	    <input type="text" name="direccion" placeholder="Introduce una direccion" />
    <br></br>
	    <input type="text" name="localidad" placeholder="Introduce una localidad" />

	    <input type="text" name="provincia" placeholder="Introduce una provincia" />
    <br></br>
	    <input type="text" name="telefono" placeholder="Introduce un telefono" />

	    <input type="text" name="dni" placeholder="Introduce un dni" />
    <br></br>
	<INPUT type="SUBMIT" VALUE="Aceptar">
	</form>
	</div>
</body>
</html>