package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelo.Usuarios;

public class UsuarioDAO {

	public static Usuarios getAllUsuario(Session s, String parametroEmail, String parametroClave) {
		String hQuery = "from Usuarios u where u.email= :email and u.clave= :clave";

		Usuarios usuario = (Usuarios) s.createQuery(hQuery, Usuarios.class)
				.setParameter("email", parametroEmail).setParameter("clave", parametroClave);
		return usuario;
	}
}
