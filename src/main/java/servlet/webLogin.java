package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.UsuarioDAO;

import controlador.MyLogger;

import modelo.Usuarios;
import utils.HibernateUtil;

/**
 * Servlet implementation class webLogin
 */
@WebServlet("/webLogin")
public class webLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Transaction tx = null;
	Session session;
	public static Logger logger = MyLogger.crearLogger(webLogin.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public webLogin() {
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		/*
		String parametroClave = request.getParameter("clave");
		String parametroEmail = request.getParameter("email");
		// response.getWriter().append(parametroEmail).append(parametroClave);
		
		
		

		Usuarios u = UsuarioDAO.getAllUsuario(session, parametroEmail, parametroClave);
		if (u != null) {
			response.getWriter().append("Bienvenido ").append(u.getNombre());
		}else {
			
			response.getWriter().append("Usuario o contraseña incorrecta ");
		}*/

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
		
		String parametroClave = request.getParameter("clave");
		String parametroEmail = request.getParameter("email");
		logger.info("Recogiendo los parametros introducidos por el usurio "+parametroClave +" "+parametroEmail);
		
		Usuarios u = UsuarioDAO.getAllUsuario(session, parametroEmail, parametroClave);
		logger.info("verificando si el usuario introducido existe o no");
		if (u != null) {
			//response.getWriter().append("Bienvenido ").append(u.getNombre());
			logger.info("el usuario introducido existe");
			String Name = u.getNombre();
			HttpSession session = request.getSession(true);
			session.setAttribute("clientName", Name);
			request.getRequestDispatcher("menuPrincipal.jsp").forward(request, response);
			
		}else {
			logger.info("el usuario introducido no existe");
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
				
		}
		
		
	}

}
