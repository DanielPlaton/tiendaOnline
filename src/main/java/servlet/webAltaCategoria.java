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

import DAO.CategoriaDAO;
import DAO.RolesDAO;
import controlador.MyLogger;
import modelo.Categoria;
import modelo.Roles;
import utils.HibernateUtil;

/**
 * Servlet implementation class webAltaCategoria
 */
@WebServlet("/webAltaCategoria")
public class webAltaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Transaction tx = null;
	Session session;
	public static Logger logger = MyLogger.crearLogger(webAltaCategoria.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public webAltaCategoria() {
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		logger.info("Entrando por el post al pulsar el boton del formulario");
		Categoria c = new Categoria();
		String parametroNombre = request.getParameter("nombre");
		String parametroDescripcion = request.getParameter("descripcion");
		
		logger.info("Recogiendo los parametros introducidos por el usurio ");

		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		List<Categoria> listaCategorias = CategoriaDAO.getAllCategoria(session);
		boolean existe = false;

		for (int i = 0; i < listaCategorias.size(); i++) {
			if (listaCategorias.get(i).getNombre().equalsIgnoreCase(parametroNombre)) {
				existe = true;
			}

		}
		if (existe != true) {
			logger.info(parametroDescripcion);
			logger.info(parametroNombre);
			
			c.setNombre(parametroNombre);
			c.setDescripcion(parametroDescripcion);
			
			CategoriaDAO.insertarCategoria(session, c);
			tx.commit();
			//response.getWriter().append("Se ha insertado la categoria bien");
			logger.info("Se ha insertado la categoria perfectamente");
			request.getRequestDispatcher("/jsp/menuPrincipal.jsp").forward(request, response);
		} else {

			//response.getWriter().append("No se ha podido insertar el rol");
			logger.info("No se ha podido insertar la categoria");
			request.getRequestDispatcher("/jsp/formularioAltaCategoria.jsp").forward(request, response);
		}
		session.close();
	}

}
