package example;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Exam1 {

	public static void main(String[] args) {
		
		String username = "c##programacion";
		String password = "programacion";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conex = DriverManager.getConnection("jdbc:oracle:thin:@10.1.6.249:1521:xe",username,password);
			Statement stmt = conex.createStatement();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
