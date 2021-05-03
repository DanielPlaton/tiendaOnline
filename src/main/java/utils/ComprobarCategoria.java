package utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.CategoriaDAO;
import controlador.MyLogger;
import modelo.Categoria;



public class ComprobarCategoria {

	public static Logger logger = MyLogger.crearLogger(ComprobarCategoria.class);
	public static boolean existeCategoria(Categoria c) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Categoria> listaCategorias = CategoriaDAO.getAllCategoria(session);
		boolean existe = false;

		for (int i = 0; i < listaCategorias.size(); i++) {
			if (listaCategorias.get(i).getNombre().equalsIgnoreCase(c.getNombre())) {
				existe = true;
			}

		}
		session.close();
		return existe;
		
		
	}
	
	public static void llamarInsertarCategoria(Categoria c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		CategoriaDAO.insertarCategoria(session, c);
		tx.commit();
		logger.info("Se ha insertado la categoria perfectamente");
		
	}
}
