package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		String parametroEmail = 	request.getParameter("email");
		String parametroClave = 	request.getParameter("clave");
		//response.getWriter().append(parametroEmail).append(parametroClave);
		
		 Usuarios u = UsuarioDAO.getAllUsuario(session,parametroEmail,parametroClave);
		 response.getWriter().append("Bienvenido ").append(u.getNombre());
		 */
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}