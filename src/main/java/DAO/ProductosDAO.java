package DAO;

import java.util.List;

import org.hibernate.Session;

import modelo.Productos;



public class ProductosDAO {

	
	public static List<Productos> getAllProductos(Session s) {
		String hQuery = "from Productos";

		List<Productos> listaProductos = s.createQuery(hQuery, Productos.class).list();
		return listaProductos;
	}
	
	public static void insertarProductos(Session s, Productos p) {
		s.save(p);
		
	}
}
