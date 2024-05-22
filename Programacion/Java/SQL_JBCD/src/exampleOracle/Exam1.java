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
			ResultSet query1 = stmt.executeQuery("select * from fabricante order by nomfab");
			
			ArrayList<Fabricante> list = new ArrayList<>();
			
			while (query1.next()) {
				list.add(new Fabricante(query1.getString("codfab"), query1.getString("nomfab")));
	 	     }
			
			
			// Collections.sort(list);
			
			for (Fabricante fabricante : list) {
				System.out.println(fabricante.toString());
			}
			
			stmt.close();
			
			//insercionDatos(conex);
			
			// Prepared Statement 
			// LOS ? DE LA SENTENCIA SQL SON PARAMETROS QUE METENMOS LOS LOS SET X MAS ADELANTE
			String sql = "select * from articulo where codart = ? OR nomart = ?";
			int id = 8;
			// CREAMOS UN STATEMAMENT CON UNA SENTENCIA SQL PREPARADA
			PreparedStatement test2 = conex.prepareStatement(sql);
			// COMANDO PARA INSERTAR LA INFORMACION DENTRO DE LA SENTENCIA
			test2.setInt(1, id);
			test2.setString(2, "portatil");
			ResultSet query2 = test2.executeQuery();
			
			while(query2.next()) {
				for (int i = 1; i <= query2.getMetaData().getColumnCount(); i++) {
					System.out.print(query2.getString(i)+"---");
				}System.out.println();
			}
			
			test2.close();
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
