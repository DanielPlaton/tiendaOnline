package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

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

import DAO.ProductosDAO;
import controlador.MyLogger;
import modelo.Productos;
import utils.HibernateUtil;

/**
 * Servlet implementation class webAltaProducto
 */
@WebServlet("/webAltaProducto")
public class WebAltaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Logger logger = MyLogger.crearLogger(WebAltaProducto.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WebAltaProducto() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
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
		Productos p = new Productos();
		p.setCategorias(11);// insertando la primera categoria en los productos
		String parametroNombre = request.getParameter("nombre");
		p.setNombre(parametroNombre);
		String parametroDescripcion = request.getParameter("descripcion");
		p.setDescripcion(parametroDescripcion);
		String parametroPrecio = request.getParameter("precio");
		if (!parametroPrecio.isEmpty()) {
			p.setPrecio(Double.parseDouble(parametroPrecio));
		}

		String parametroStock = request.getParameter("stock");
		if (!parametroStock.isEmpty()) {
			p.setStock(Integer.parseInt(parametroStock));
		}
		String parametroFechaAlta = request.getParameter("fecha_alta");

		Timestamp fechaTime = ProductosDAO.transformarFecha(parametroFechaAlta);

		logger.info(fechaTime);
		p.setFecha_alta(fechaTime);

		String parametroFechaBaja = request.getParameter("fecha_baja");
		Timestamp fechaTime2 = ProductosDAO.transformarFecha(parametroFechaBaja);
		p.setFecha_baja(fechaTime2);

		String parametroImpuesto = request.getParameter("impuesto");
		if(!parametroImpuesto.isEmpty()) {
		p.setImpuesto(Float.parseFloat(parametroImpuesto));
		}

		logger.info("Recogiendo los parametros introducidos por el usurio ");

		if (!parametroNombre.toString().isEmpty() && !parametroDescripcion.toString().isEmpty()
				&& !parametroPrecio.toString().isEmpty() && !parametroStock.toString().isEmpty()
				&& !parametroImpuesto.toString().isEmpty()) {
			boolean existe = ProductosDAO.existeProducto(p);
			if (existe != true) {
				ProductosDAO.insertarProductos(p);
				request.getRequestDispatcher("/jsp/menuPrincipal.jsp").forward(request, response);
			}else {

				// response.getWriter().append("No se ha podido insertar el rol");
				logger.info("No se ha podido insertar la categoria");
				request.getRequestDispatcher("/jsp/formularioAltaProducto.jsp").forward(request, response);

			}
		} else {

			// response.getWriter().append("No se ha podido insertar el rol");
			logger.info("No se ha podido insertar la categoria");
			request.getRequestDispatcher("/jsp/formularioAltaProducto.jsp").forward(request, response);

		}

	}

}
