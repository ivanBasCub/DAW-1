package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.proxy.annotation.Pre;

public class FabricanteDAO {

	private static Connection conect() {
		Connection con=null;		
		String usr="c##bdarticulos",pass="bdarticulos";
		String url="jdbc:oracle:thin:@10.1.2.167:1521:xe";
		
		try {
			con = DriverManager.getConnection(url,usr,pass);
		} catch (SQLException e) {
			System.out.println("Error en la conexion a la BBDD");
		}
		return con;
	}
	
	public static Fabricante read(String codfab) {
		Fabricante fab = null;
		String sql = "SELECT * FROM fabricante where codfab = ?";
		
		Connection conex = conect();
		try {
			PreparedStatement stmt = conex.prepareStatement(sql);
			stmt.setString(1, codfab);
			
			ResultSet query = stmt.executeQuery();
			
			if(query.next()) {
				fab = new Fabricante(query.getString("codfab"), query.getString("nomfab"));
				conex.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fab;
	}
	
	public static void create(Fabricante fab) {
		if (fab != null) {
			Connection conex = conect();
			String sql = "insert into fabricante values (?,?)";
			
			try {
				PreparedStatement query = conex.prepareStatement(sql);
				query.setString(1, fab.getId());
				query.setString(2, fab.getName());
				query.executeUpdate();
				conex.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void update(Fabricante fab) {
		if (fab != null) {
			Connection conex = conect();
			String sql = "update fabricante set nomfab = ? where codfab = ?";
			
			try {
				PreparedStatement query = conex.prepareStatement(sql);
				query.setString(1, fab.getId());
				query.setString(2, fab.getName());
				query.executeUpdate();
				conex.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void delete() {
		String sql = "delete from fabricante where codfab = ?";
		Connection conex = conect();
		
	}
}
