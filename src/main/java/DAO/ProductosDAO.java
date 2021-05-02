package DAO;

import java.util.List;

import org.hibernate.Session;

import modelo.Productos;



public class ProductosDAO {

	
	public static List<Productos> getAllCategoria(Session s) {
		String hQuery = "from Productos";

		List<Productos> listaCategorias = s.createQuery(hQuery, Productos.class).list();
		return listaCategorias;
	}
	
	public static void insertarProductos(Session s, Productos p) {
		s.save(p);
		
	}
}
