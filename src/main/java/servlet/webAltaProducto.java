package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import DAO.ProductosDAO;
import controlador.MyLogger;
import modelo.Categoria;
import modelo.Productos;
import utils.HibernateUtil;

/**
 * Servlet implementation class webAltaProducto
 */
@WebServlet("/webAltaProducto")
public class webAltaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Transaction tx = null;
	Session session;
	public static Logger logger = MyLogger.crearLogger(webAltaProducto.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public webAltaProducto() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		p.setCategorias(11);// insertando el rol clientes en el usuario
		String parametroNombre = request.getParameter("nombre");
		p.setNombre(parametroNombre);
		String parametroDescripcion = request.getParameter("descripcion");
		p.setDescripcion(parametroDescripcion);
		String parametroPrecio = request.getParameter("precio");
		p.setPrecio(Double.parseDouble(parametroPrecio));
		String parametroStock = request.getParameter("stock");
		p.setStock(Integer.parseInt(parametroStock));
		String parametroFechaAlta = request.getParameter("fecha_alta");

		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp timestamp = Timestamp.valueOf(formatter.format(parametroFechaAlta));
		logger.info(timestamp);
		p.setFecha_alta(timestamp);

		String parametroFechaBaja = request.getParameter("fecha_baja");

		Timestamp timestamp2 = Timestamp.valueOf(formatter.format(parametroFechaBaja));
		logger.info(timestamp2);
		p.setFecha_baja(timestamp2);

		String parametroImpuesto = request.getParameter("impuesto");
		p.setImpuesto(Float.parseFloat(parametroImpuesto));

		logger.info("Recogiendo los parametros introducidos por el usurio ");

		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		List<Productos> listaProductos = ProductosDAO.getAllCategoria(session);
		boolean existe = false;

		for (int i = 0; i < listaProductos.size(); i++) {
			if (listaProductos.get(i).getNombre().equalsIgnoreCase(parametroNombre)) {
				existe = true;
			}

		}
		if (existe != true) {

			ProductosDAO.insertarProductos(session, p);
			tx.commit();
			// response.getWriter().append("Se ha insertado la categoria bien");
			logger.info("Se ha insertado el producto perfectamente");
			request.getRequestDispatcher("/menuPrincipal.jsp").forward(request, response);
		} else {

			// response.getWriter().append("No se ha podido insertar el rol");
			logger.info("No se ha podido insertar la categoria");
			request.getRequestDispatcher("/formularioAltaProducto.jsp").forward(request, response);
		}
		session.close();
	}

}
