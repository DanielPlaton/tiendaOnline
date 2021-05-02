package DAO;

import java.util.List;

import org.hibernate.Session;

import modelo.Categoria;



public class CategoriaDAO {

	
	public static List<Categoria> getAllCategoria(Session s) {
		String hQuery = "from Categoria";

		List<Categoria> listaCategorias = s.createQuery(hQuery, Categoria.class).list();
		return listaCategorias;
	}
	
	public static void insertarCategoria(Session s, Categoria c) {
		s.save(c);
		
	}
}
