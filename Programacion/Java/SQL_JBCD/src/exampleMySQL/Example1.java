package exampleMySQL;

import java.sql.*;

public class Example1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://10.1.6.70:3306/alamacenamientoinformatica";
			String username = "c##abraham";
			String password = "abraham";
			
			Connection conex = DriverManager.getConnection(url,username,password);
			Statement stmt = conex.createStatement();
			ResultSet query1 = stmt.executeQuery("select * from fabricante");
			
			while(query1.next()) {
				for (int i = 1; i <= query1.getMetaData().getColumnCount(); i++) {
					System.out.print(query1.getString(i)+"------");
				}System.out.println();
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
