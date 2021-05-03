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
import org.hibernate.transform.AliasToEntityMapResultTransformer;

import DAO.RolesDAO;
import DAO.UsuarioDAO;
import controlador.MyLogger;
import modelo.Roles;
import modelo.Usuarios;
import utils.ComprobarRol;
import utils.HibernateUtil;

/**
 * Servlet implementation class webAltaRol
 */
@WebServlet("/webAltaRol")
public class webAltaRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Logger logger = MyLogger.crearLogger(webAltaRol.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public webAltaRol() {
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
		response.getWriter().append("Served at: asdsadasd ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		logger.info("Entrando por el post al pulsar el boton del formulario");
		Roles r = new Roles();
		String parametroRol = request.getParameter("rol");
		logger.info("Recogiendo los parametros introducidos por el usurio ");
		r.setRol(parametroRol);
		boolean existe = ComprobarRol.comprobarRol(r);
	
		if (existe != true) {
			ComprobarRol.llamarInsertarRol(r);
			// response.getWriter().append("Se ha insertado el rol bien");
			logger.info("Se ha insertado el rol perfectamente");
			request.getRequestDispatcher("/menuPrincipal.jsp").forward(request, response);
		} else {

			// response.getWriter().append("No se ha podido insertar el rol");
			logger.info("No se ha podido insertar el rol");
			request.getRequestDispatcher("/formularioAltaRoles.jsp").forward(request, response);
		}

	}

}
