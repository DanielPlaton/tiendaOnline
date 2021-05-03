package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import controlador.MyLogger;
import modelo.Usuarios;
import utils.ComprobarUsuarios;

/**
 * Servlet implementation class webAltaUsuario
 */
@WebServlet("/webAltaUsuario")
public class WebAltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static Logger logger = MyLogger.crearLogger(WebAltaUsuario.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WebAltaUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("Iniciando programa");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:  get ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		boolean existe = false;

		logger.info("Entrando por el post al pulsar el boton del formulario");
		Usuarios u = new Usuarios();
		u.setRoles(1);// insertando el rol clientes en el usuario
		String parametroEmail = request.getParameter("email");
		u.setEmail(parametroEmail);
		String parametroClave = request.getParameter("clave");
		Base64 base64 = new Base64();
		String claveEncriptada = new String(base64.encode(parametroClave.getBytes()));
		logger.info("contraseña Encriptada: ");
		u.setClave(claveEncriptada);
		
		
		String parametroNombre = request.getParameter("nombre");
		u.setNombre(parametroNombre);
		String parametroApellido1 = request.getParameter("apellido1");
		u.setApellido1(parametroApellido1);
		String parametroApellido2 = request.getParameter("apellido2");
		u.setApellido2(parametroApellido2);
		String parametroDireccion = request.getParameter("direccion");
		u.setDireccion(parametroDireccion);
		String parametroLocalidad = request.getParameter("localidad");
		u.setLocalidad(parametroLocalidad);
		String parametroProvincia = request.getParameter("provincia");
		u.setProvincia(parametroProvincia);
		String parametroTelefono = request.getParameter("telefono");
		u.setTelefono(parametroTelefono);
		String parametroDni = request.getParameter("dni");
		u.setDni(parametroDni);

		logger.info("Recogiendo los parametros introducidos por el usurio ");

		if (!parametroEmail.toString().isEmpty()  && !parametroClave.toString().isEmpty()
				&& !parametroApellido1.toString().isEmpty() && !parametroApellido2.toString().isEmpty()
				&& !parametroDireccion.toString().isEmpty() && !parametroLocalidad.toString().isEmpty()
				&& !parametroProvincia.toString().isEmpty() && !parametroTelefono.toString().isEmpty()
				&& !parametroDni.toString().isEmpty()) {
			existe = ComprobarUsuarios.existeUsuario(u);
			if (u != null && existe != true) {

				ComprobarUsuarios.llamarInsertarUsuario(u);
				request.getRequestDispatcher("/jsp/menuPrincipal.jsp").forward(request, response);
			} else {

				// response.getWriter().append(" No se ha podido insertar el usuario");
				logger.info("No se ha podido insertar el usuario");
				request.getRequestDispatcher("/jsp/formularioAltaUsuario.jsp").forward(request, response);
			}

		} else {

			// response.getWriter().append(" No se ha podido insertar el usuario");
			logger.info("No se ha podido insertar el usuario");
			request.getRequestDispatcher("/jsp/formularioAltaUsuario.jsp").forward(request, response);
		}
	}

}
