package servlet;

import java.awt.Robot;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.management.relation.Role;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controlador.*;
import modelo.*;
import utils.*;


/**
 * Servlet implementation class webLogin
 */
@WebServlet("/webLogin")
public class WebLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Transaction tx = null;
	Session session;
	public static Logger logger = MyLogger.crearLogger(WebLogin.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WebLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("Iniciando programa");
		// session = HibernateUtil.getSessionFactory().openSession();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		/*
		 * String parametroClave = request.getParameter("clave"); String parametroEmail
		 * = request.getParameter("email"); //
		 * response.getWriter().append(parametroEmail).append(parametroClave);
		 * 
		 * 
		 * 
		 * 
		 * Usuarios u = UsuarioDAO.getAllUsuario(session, parametroEmail,
		 * parametroClave); if (u != null) {
		 * response.getWriter().append("Bienvenido ").append(u.getNombre()); }else {
		 * 
		 * response.getWriter().append("Usuario o contrase?a incorrecta "); }
		 */

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
		Base64 base64 = new Base64();
		String claveEncriptada = new String(base64.encode(parametroClave.getBytes()));
		logger.info("Recogiendo los parametros introducidos por el usuario " + parametroClave + " " + parametroEmail);

		Usuarios u = ComprobarLogin.comprobarUsuarios(parametroEmail, claveEncriptada);
		logger.info("verificando si el usuario introducido existe o no");
		if (u != null) {
			// response.getWriter().append("Bienvenido ").append(u.getNombre());
			logger.info("el usuario introducido existe");
			String Name = u.getNombre();
			HttpSession session = request.getSession(true);
			session.setAttribute("clientName", Name);
			Date fechaActual = new java.util.Date();
			session.setAttribute("fecha", fechaActual);
			int opcion = u.getRoles();
			// List<Roles> listaRoles = RolesDAO.getAllRoles(this.session);
			switch (opcion) {
			case 1:
				request.getRequestDispatcher("/jsp/menuPrincipal.jsp").forward(request, response);
				break;
			case 2:
				request.getRequestDispatcher("/jsp/menuPrincipalEmpleados.jsp").forward(request, response);
				break;
			case 3:
				request.getRequestDispatcher("/jsp/menuPrincipalClientes.jsp").forward(request, response);
				break;

			}

		} else {
			logger.info("el usuario introducido no existe");
			request.getRequestDispatcher("/jsp/formulario.jsp").forward(request, response);

		}

	}

}
