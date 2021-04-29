package DAO;

import java.util.List;

import org.hibernate.Session;

import modelo.Roles;

public class RolesDAO {
	
	public static List<Roles> getAllRoles(Session s) {
		String hQuery = "from Roles";

		List<Roles> listaRoles = s.createQuery(hQuery, Roles.class).list();
		return listaRoles;
	}
	
	public static void insertarRoles(Session s, Roles r) {
		s.save(r);
		
	}
}
