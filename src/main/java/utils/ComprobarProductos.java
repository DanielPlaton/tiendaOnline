package utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.ProductosDAO;
import DAO.UsuarioDAO;
import controlador.MyLogger;
import modelo.Productos;
import modelo.Usuarios;



public class ComprobarProductos {
	public static Logger logger = MyLogger.crearLogger(ComprobarProductos.class);
	public static Timestamp transformarFecha(String fecha) {

		Timestamp timestamp = null;
		Date d = null;
		try {
			

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
			d = formatter.parse(fecha);
			
			timestamp = new java.sql.Timestamp(d.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return timestamp;
	}
	
	public static boolean existeProducto(Productos p) {
		boolean existe= false;
		Session session = HibernateUtil.getSessionFactory().openSession();	
		List<Productos> listaProductos = ProductosDAO.getAllProductos(session);
		for (int i = 0; i < listaProductos.size(); i++) {
			if (listaProductos.get(i).getNombre().equalsIgnoreCase(p.getNombre())) {
				existe = true;
			}

		}
		session.close();
		return existe;
	}
	
	public static void llamarInsertarProducto(Productos p) {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		ProductosDAO.insertarProductos(session, p);
		tx.commit();
		// response.getWriter().append("Se ha insertado la categoria bien");
		logger.info("Se ha insertado el producto perfectamente");
		session.close();
	}

}
