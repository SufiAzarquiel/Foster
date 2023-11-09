package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.FosterConnection;
import dao.DAOCategoria;
import dao.DAOProducto;
import model.Categoria;
import model.Producto;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArrayList<Categoria> categorias = null;

	private ArrayList<Producto> productos;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String op = request.getParameter("op");

		// Singleton connection
		Connection con = (Connection) session.getAttribute("con");
		if (con == null) {
			try {
				con = FosterConnection.conecta();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("con", con);
		}

		switch (op) {
		case "inicio": {
			try {
				categorias = new DAOCategoria().getAllCategorias(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			session.setAttribute("categorias", categorias);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		case "platos": {
			String categoriaId = request.getParameter("categoriaid");
			String categoriaNombre = request.getParameter("nombrecategoria");
			try {
				productos = new DAOProducto().getProductosByCategoria(con, Integer.parseInt(categoriaId));
			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.setAttribute("nombrecategoria", categoriaNombre);
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}