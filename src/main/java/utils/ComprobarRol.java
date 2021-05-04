package utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.*;
import controlador.*;
import modelo.*;



public class ComprobarRol {

	public static Logger logger = MyLogger.crearLogger(ComprobarRol.class);
	public static boolean comprobarRol(Roles r) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		List<Roles> listaRoles = RolesDAO.getAllRoles(session);
		boolean existe = false;

		for (int i = 0; i < listaRoles.size(); i++) {
			if (listaRoles.get(i).getRol().equalsIgnoreCase(r.getRol())) {
				existe = true;
			}

		}
		return existe;
	}

	
	public static void llamarInsertarRol(Roles r) {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		RolesDAO.insertarRoles(session, r);
		//response.getWriter().append("Se ha insertado el usuario bien");
		logger.info("Se ha insertado el usuario perfectamente");
		tx.commit();
		session.close();
	}
	
	public static List<Roles> llamarBuscarRoles(List<Roles> lisRoles) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		lisRoles = RolesDAO.getAllRoles(session);
		session.close();
		return lisRoles;
		
		
	}
}
