package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Producto;

public class DAOProducto {
	public ArrayList<Producto> getProductosByCategoria(Connection con, int idCategoria) throws SQLException {
		ResultSet rs;
		ArrayList<Producto> lista = new ArrayList<Producto>();

		Statement st;
		st = con.createStatement();
		String ordenSql = "SELECT * FROM PRODUCTO WHERE CATEGORIAID = " + idCategoria;
		rs = st.executeQuery(ordenSql);

		while (rs.next()) {
			Producto producto = new Producto();
			producto.setId(rs.getInt("ID"));
			producto.setTitulo(rs.getString("TITULO"));
			producto.setImagen(rs.getString("IMAGEN"));
			lista.add(producto);
		}
		rs.close();
		st.close();

		return lista;
	}
}
