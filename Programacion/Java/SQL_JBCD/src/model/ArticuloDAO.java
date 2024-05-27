package model;

import java.sql.*;



public class ArticuloDAO {
	// Metodo para conectar a la BBDD
	private static Connection conect() {
		Connection con=null;		
		String usr="c##bdarticulos",pass="bdarticulos";
		String url="jdbc:oracle:thin:@10.1.6.249:1521:xe";
		
		try {
			con = DriverManager.getConnection(url,usr,pass);
		} catch (SQLException e) {
			System.out.println("Error en la conexion a la BBDD");
		}
		return con;
	}
	
	// Metodo para insertar un nuevo dato a traves de un objeto
	public static void insert(Articulo art) {
		if (art != null) {
			Connection conex = conect();
			String sql = "INSERT INTO Articulo VALUES (?,?,?,?)";
			
			try {
				PreparedStatement query = conex.prepareStatement(sql);
				query.setInt(1, art.getCodArt());
				query.setString(2, art.getNomArt());                
				query.setDouble(3, art.getPrecio());
				query.setInt(4, art.getCodFab());
				query.executeUpdate();
				conex.close();
			} catch (SQLException e) {
				System.out.println("Error al insertar");
			}
		}
	}
	// Leer la informacion de un objeto mediante el codigo dado por el usuario
	public static Articulo read(String codart) {
		Articulo art = null;
		String sql = "SELECT * FROM articulo WHERE codart = ?";
		
		Connection conex = conect();
		PreparedStatement stmt;
		
		try {
			stmt = conex.prepareStatement(sql);
			stmt.setString(1, codart);
			
			ResultSet query = stmt.executeQuery();
			
			if (query.next()) {
				art = new Articulo(query.getInt("codart"), query.getString("nomart"), query.getInt("precio"), query.getInt("codfab"));
				conex.close();
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta SQL");
		}
		return art;
	}
	
	public static Articulo readFab(String codart) {
		Articulo art = null;
		String sql = "Select a.*,f.nomfab from articulo a join fabricante f on a.codfab = f.codfab where a.codart = ?";
		
		Connection conex = conect();
		
		PreparedStatement stmt;
		try {
			stmt = conex.prepareStatement(sql);
			stmt.setString(1, codart);
			
			ResultSet query = stmt.executeQuery();
			
			if(query.next()) {
				art = new Articulo(query.getInt("codart"),query.getString("nomart"), query.getDouble("precio"),query.getString("nomfab"));
				conex.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return art;
	}
	
	// Actualizar la informacion de un mediante el objeto Articulo dado por el usuario
	public static void update(Articulo articulo) {
        if (articulo != null) {
            String sql = "UPDATE Articulo "
                    + "SET NomArt=?, Precio=?, CodFab=? "
                    + "WHERE CodArt = ?";
            try {
                Connection conexion = conect();
                PreparedStatement sentencia = conexion.prepareStatement(sql);

                sentencia.setString(1, articulo.getNomArt());
                sentencia.setDouble(2, articulo.getPrecio());                
                sentencia.setInt(3, articulo.getCodFab());
                sentencia.setInt(4, articulo.getCodArt()); 

                sentencia.executeUpdate();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error al actualizar un alumno.");
            }
        }
    }
	
	// Metodo para borrar la informacion de un codigo de un articulo dado por el usuario
	public static void delete(String codArt) {
        String sql = "DELETE FROM Articulo "
                + "WHERE CodArt = ?";
        try {
            Connection conexion = conect();
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, codArt); 

            sentencia.executeUpdate();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar un artículo.");
        }
    }
}
