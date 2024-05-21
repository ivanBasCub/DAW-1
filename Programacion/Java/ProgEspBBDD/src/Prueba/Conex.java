package Prueba;

import java.sql.*;

public class Conex {

	public static void main(String[] args) {
		try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection  conexion = DriverManager.getConnection("jdbc:oracle:thin:@10.1.2.167:1521:xe","c##bdarticulos","bdarticulos");
	         
	         // Consulta 1
	         Statement stmt = conexion.createStatement();
	 	     ResultSet rset =stmt.executeQuery("select * from articulo");
	 	     
	 	    while (rset.next()) {
	 	         System.out.println (rset.getString("precio"));
	 	     }
	 	    stmt.close();
	 	     // Consulta 2
	 	     Statement stmt2 = conexion.createStatement();
	 	     ResultSet query2 = stmt2.executeQuery("select * from articulo a join fabricante f on a.codFab = f.codFab");

	 	     System.out.println(" CodArt    NomArt  Precio  NomFab");
	 	     while(query2.next()) {
	 	    	System.out.print(query2.getString(1));
	 	    	System.out.print(" " + query2.getString(2));
	 	    	System.out.print(" " + query2.getString(3));
	 	    	System.out.print(" " + query2.getString(6));
	 	    	System.out.println();
	 	     }
	 	     
	 	     stmt2.close();
	 	     
	 	     
//	 	     insercionDatos(conexion);
	 	     
	 	     conexion.close();
	        }catch (SQLException | ClassNotFoundException ex) {
	            System.out.println("Error en la conexión de la base de datos");
	        }	
	}

	// Insertar informacion a la bbdd
	
	private static void insercionDatos(Connection conexion) throws SQLException {
		// Insercion de datos
		 
		Statement stmt3 = conexion.createStatement();
		String consulta = "insert into fabricante values('0000000018','Renault')";
			// Cualquier modificador de informacion
		stmt3.executeUpdate(consulta);
		
		
		stmt3.close();
	}
}
