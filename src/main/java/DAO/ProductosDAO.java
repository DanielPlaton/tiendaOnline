package DAO;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controlador.MyLogger;
import modelo.Productos;

import utils.HibernateUtil;



public class ProductosDAO {
	public static Logger logger = MyLogger.crearLogger(ProductosDAO.class);
	
	public static List<Productos> getAllProductos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hQuery = "from Productos";

		List<Productos> listaProductos = session.createQuery(hQuery, Productos.class).list();
		session.close();
		return listaProductos;
	}
	
	public static void insertarProductos(Productos p) {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		session.save(p);
		logger.info("Se ha insertado el producto perfectamente");
		tx.commit();
		session.close();
		
	}
	
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
		List<Productos> listaProductos = ProductosDAO.getAllProductos();
		for (int i = 0; i < listaProductos.size(); i++) {
			if (listaProductos.get(i).getNombre().equalsIgnoreCase(p.getNombre())) {
				existe = true;
			}

		}
		session.close();
		return existe;
	}
}
