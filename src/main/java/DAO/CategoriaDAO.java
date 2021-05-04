package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Categoria;
import utils.HibernateUtil;



public class CategoriaDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();

	public static List<Categoria> getAllCategoria() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hQuery = "from Categoria";

		List<Categoria> listaCategorias = session.createQuery(hQuery, Categoria.class).list();
		session.close();
		return listaCategorias;
	}

	public static void insertarCategoria(Categoria c) {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		session.save(c);
		tx.commit();
		session.close();

	}
	
public static boolean existeCategoria(Categoria c) {
		List<Categoria> listaCategorias = CategoriaDAO.getAllCategoria();
		boolean existe = false;

		for (int i = 0; i < listaCategorias.size(); i++) {
			if (listaCategorias.get(i).getNombre().equalsIgnoreCase(c.getNombre())) {
				existe = true;
			}

		}
		return existe;
		
		
	}
	
}
