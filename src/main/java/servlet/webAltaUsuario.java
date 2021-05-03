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

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.UsuarioDAO;
import controlador.MyLogger;
import modelo.Usuarios;
import utils.ComprobarLogin;
import utils.ComprobarUsuarios;
import utils.HibernateUtil;

/**
 * Servlet implementation class webAltaUsuario
 */
@WebServlet("/webAltaUsuario")
public class webAltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static Logger logger = MyLogger.crearLogger(webAltaUsuario.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public webAltaUsuario() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:  get ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		boolean existe = false;
		
		logger.info("Entrando por el post al pulsar el boton del formulario");
		Usuarios u= new Usuarios();
		u.setRoles(3);//insertando el rol clientes en el usuario
		String parametroEmail = request.getParameter("email");
		u.setEmail(parametroEmail); 
		String parametroClave = request.getParameter("clave");
		u.setClave(parametroClave);
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

		existe = ComprobarUsuarios.existeUsuario(u);
		
		if (u != null && existe != true) {
			ComprobarUsuarios.llamarInsertarUsuario(u);
			request.getRequestDispatcher("/menuPrincipal.jsp").forward(request, response);
		}else {
			
			//response.getWriter().append(" No se ha podido insertar el usuario");
			logger.info("No se ha podido insertar el usuario");
			request.getRequestDispatcher("/formularioAltaUsuario.jsp").forward(request, response);
		}
		
	}

}
