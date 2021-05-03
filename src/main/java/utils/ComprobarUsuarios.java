package utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.UsuarioDAO;
import controlador.MyLogger;
import modelo.Usuarios;


public class ComprobarUsuarios {

	public static Logger logger = MyLogger.crearLogger(ComprobarUsuarios.class);
	 
	
	public static boolean existeUsuario(Usuarios u) {
		boolean existe= false;
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Usuarios> listaUsuarios= UsuarioDAO.getAllUsuarios(session);
		for(int i=0;i < listaUsuarios.size();i++) {
			if(listaUsuarios.get(i).getEmail().equalsIgnoreCase(u.getEmail())) {
				existe= true; 
				//response.getWriter().append(" El email introducido ya existe coje otro ");
				logger.info(" El email introducido ya existe coje otro ");
			}
		}
		session.close();
		return existe;
	}
	
	public static void llamarInsertarUsuario(Usuarios u) {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		UsuarioDAO.insertarUsuario(session, u);
		//response.getWriter().append("Se ha insertado el usuario bien");
		logger.info("Se ha insertado el usuario perfectamente");
		tx.commit();
		session.close();
	}
}
