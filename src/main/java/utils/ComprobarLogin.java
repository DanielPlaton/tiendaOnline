package utils;

import org.hibernate.Session;

import DAO.UsuarioDAO;
import modelo.Usuarios;
import utils.HibernateUtil;



public class ComprobarLogin {

	
	public static Usuarios comprobarUsuarios(String email, String contraseña) {
		Usuarios u= null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		 u = UsuarioDAO.getAllUsuario(s, email, contraseña);
		s.close();
		return u;
	}
}
