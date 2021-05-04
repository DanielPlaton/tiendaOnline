<html>
<head>
<title>Login</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/formulariocss.css">
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
			ACTION="<%=request.getContextPath()%>/webLogin">
			<h1>Login</h1>
			<div class="form-floating">
				<input type="email" name="email" id="email" class="form-control"
					placeholder="Introduce un email" /> 
					<label for="floatingInput">Email </label>
			</div>
			<div class="form-floating">
				<input type="password" name="clave" id="clave" class="form-control"
					placeholder="Introducce una clave" /> <label
					for="floatingPassword">Password</label>
			</div>
			 <button class="w-100 btn btn-lg btn-primary" type="submit" value="Entrar">Entrar</button>
			
		</form>
	</div>

</body>
</html>