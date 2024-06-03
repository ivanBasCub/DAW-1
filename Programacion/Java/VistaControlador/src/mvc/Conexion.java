package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

	private Connection con;

	public Conexion(String usr, String pass, String ip) {
		String url = "jdbc:oracle:thin:@"+ip+":1521:xe";
		try {
			con = DriverManager.getConnection(url,usr,pass);
		} catch (SQLException e) {
			System.out.println("Error en la conexion a la BBDD");
		}
	}
	
	public Modelo searchData(String codArt) {
		Modelo aux = null;
		String sql = "select a.nomart, f.nomfab, a.precio  from articulo a join fabricante f on f.codfab = a.codfab where a.codart = ?";
	
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, codArt);
			
			ResultSet query = stmt.executeQuery();
			
			if(query.next()) {				
				aux = new Modelo(query.getString("nomart"),query.getString("nomfab"),query.getDouble("precio"));
			}
			
			query.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aux;
	}
	
	public void closeConexion() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
