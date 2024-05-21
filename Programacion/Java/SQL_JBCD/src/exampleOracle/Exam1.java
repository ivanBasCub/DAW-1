package exampleOracle;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

public class Exam1 {

	public static void main(String[] args) {
		
		String username = "c##bdarticulos";
		String password = "bdarticulos";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conex = DriverManager.getConnection("jdbc:oracle:thin:@10.1.6.249:1521:xe",username,password);
			Statement stmt = conex.createStatement();
			ResultSet query1 = stmt.executeQuery("select * from fabricante");
			
			ArrayList<Fabricante> list = new ArrayList<>();
			
			while (query1.next()) {
				list.add(new Fabricante(query1.getString("codfab"), query1.getString("nomfab")));
	 	     }
			
			
			Collections.sort(list);
			
			for (Fabricante fabricante : list) {
				System.out.println(fabricante.toString());
			}
			
			stmt.close();
			
			//insercionDatos(conex);
			
			conex.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void insercionDatos(Connection conexion) throws SQLException {
		// Insercion de datos
		 
		Statement stmt3 = conexion.createStatement();
		String consulta = "insert into fabricante values('0000001108','Caballo Homosexual de las Montañas')";
			// Cualquier modificador de informacion
		stmt3.executeUpdate(consulta);
		
		
		stmt3.close();
	}
}
