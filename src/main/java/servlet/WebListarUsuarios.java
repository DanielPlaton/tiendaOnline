package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import DAO.UsuarioDAO;
import modelo.Usuarios;
import utils.HibernateUtil;
/**
 * Servlet implementation class WebListarUsuarios
 */
@WebServlet("/WebListarUsuarios")
public class WebListarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebListarUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		List<Usuarios> listaUsuarios = UsuarioDAO.getAllUsuarios(s);
		s.close();
		
		request.setAttribute("listaUsuarios", listaUsuarios);
		request.getRequestDispatcher("/jsp/formularioListarUsuario.jsp").forward(request, response);
		
	}

}
