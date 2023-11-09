package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Categoria;

public class DAOCategoria {
	public ArrayList<Categoria> getAllCategorias(Connection con) throws SQLException {
		ResultSet rs;
		ArrayList<Categoria> lista = new ArrayList<Categoria>();

		Statement st;
		st = con.createStatement();
		String ordenSql = "SELECT * FROM CATEGORIA";
		rs = st.executeQuery(ordenSql);

		while (rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setId(rs.getInt("ID"));
			categoria.setNombre(rs.getString("NOMBRE"));
			categoria.setDescripcion(rs.getString("DESCRIPCION"));
			categoria.setGuarnicion(rs.getString("GUARNICION"));
			lista.add(categoria);
		}
		rs.close();
		st.close();

		return lista;
	}
}
