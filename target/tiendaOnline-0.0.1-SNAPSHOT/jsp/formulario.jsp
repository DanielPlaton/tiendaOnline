<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/formulariocss.css">
</head>
<body>
	<%
	if (session != null) {
		session = request.getSession();
		session.invalidate();
	}
	%>

	<div>

		<form class="login-form" METHOD="POST"
			ACTION="http://localhost:8080/tiendaOnline/webLogin">
			<h1>Login</h1>
			<input type="text" name="email" placeholder="Introduce un email" />
			<br></br> <input type="password" name="clave"
				placeholder="Introducce una clave" /> <br></br> <INPUT
				type="SUBMIT" VALUE="Entrar">
		</form>
	</div>

</body>
</html>