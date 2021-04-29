package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.UsuarioDAO;
import controlador.MyLogger;
import modelo.Usuarios;
import utils.HibernateUtil;

/**
 * Servlet implementation class webAltaUsuario
 */
@WebServlet("/webAltaUsuario")
public class webAltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Transaction tx = null;
	Session session;
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
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
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
		List<Usuarios> listaUsuarios= UsuarioDAO.getAllUsuarios(session);
		for(int i=0;i < listaUsuarios.size();i++) {
			if(listaUsuarios.get(i).getEmail().equalsIgnoreCase(u.getEmail())) {
				existe= true; 
				response.getWriter().append("El email introducido ya esixte coje otro");
			}
			
		}

		
		if (u != null && existe != true) {
			UsuarioDAO.insertarUsuario(session, u);
			response.getWriter().append("Se ha insertado el usuario bien");
			logger.info("Se ha insertado el usuario perfectamente");
			tx.commit();
		}else {
			
			response.getWriter().append("No se ha podido insertar el usuario");
			logger.info("No se ha podido insertar el usuario");
		}
	}

}
