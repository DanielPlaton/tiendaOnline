package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import DAO.CategoriaDAO;
import controlador.*;
import modelo.*;

/**
 * Servlet implementation class webAltaCategoria
 */
@WebServlet("/webAltaCategoria")
public class WebAltaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Logger logger = MyLogger.crearLogger(WebAltaCategoria.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WebAltaCategoria() {
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
		Categoria c = new Categoria();
		String parametroNombre = request.getParameter("nombre");
		String parametroDescripcion = request.getParameter("descripcion");

		logger.info("Recogiendo los parametros introducidos por el usurio ");
		c.setNombre(parametroNombre);
		c.setDescripcion(parametroDescripcion);
		if (!parametroNombre.toString().isEmpty() && !parametroDescripcion.toString().isEmpty()) {
			boolean existe = CategoriaDAO.existeCategoria(c);

			if (existe != true) {
				CategoriaDAO.insertarCategoria(c);
				request.getRequestDispatcher("/jsp/menuPrincipal.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/jsp/formularioAltaCategoria.jsp").forward(request, response);

			}
		} else {

			// response.getWriter().append("No se ha podido insertar el rol");
			logger.info("No se ha podido insertar la categoria");
			request.getRequestDispatcher("/jsp/formularioAltaCategoria.jsp").forward(request, response);
		}
	}

}
