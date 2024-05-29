package highSchool;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnDAO {
	// CONNECT TO THE DATABASES
	private static Connection connect() {
		Connection con=null;		
		String usr="c##alumnos",pass="alumnos";
		String url="jdbc:oracle:thin:@10.1.6.249:1521:xe";
		
		try {
			con = DriverManager.getConnection(url,usr,pass);
		} catch (SQLException e) {
			System.out.println("Error en la conexion a la BBDD");
		}
		return con;
	}

	// EXERCISE 1
	/**
	 * 
	 * @param corte Nota de corte para filtrar los alumnos con menor nota
	 * @param curso El curso que queremos mirar
	 *
	 * @return Devuelve un {@link ArrayList} de objetos {@link Alumn} que son del resultado de la consulta SQL
	 */
	public static ArrayList<Alumn> alumListNote(float corte, String curso){
		ArrayList<Alumn> list = new ArrayList<>();
		String sql = "select * from alumnos where (media >= ? and curso = ?)";
		
		Connection conex = connect();
		try {
			PreparedStatement stmt = conex.prepareStatement(sql);
			stmt.setDouble(1, corte);
			stmt.setString(2, curso);
			
			ResultSet query = stmt.executeQuery();
			
			while(query.next()) {
				list.add(new Alumn(query.getInt("num"),query.getString("nombre"),query.getDate("fnac"),query.getFloat("media"),query.getString("curso")));
			}
			conex.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// EXERCISE 2
	public static ArrayList<Alumn> listAlumn(float min, float max){
		ArrayList<Alumn> list = new ArrayList<>();
		String sql = "Select * from alumnos where (media > ? and media < ?) order by media asc";
		
		Connection conex = connect();
		try {
			PreparedStatement stmt = conex.prepareStatement(sql);
			stmt.setFloat(1, min);
			stmt.setFloat(2, max);
			
			ResultSet query = stmt.executeQuery();
			while(query.next()) {
				list.add(new Alumn(query.getInt("num"),query.getString("nombre"),query.getDate("fnac"),query.getFloat("media"),query.getString("curso")));
			}
			conex.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// EXERCISE 3
	public static void create(Alumn alumno) {
		if (alumno != null) {
			Connection conex = connect();
			String sql = "insert into alumnos values (?,?,?,?,?)";
			
			try {
				PreparedStatement query = conex.prepareStatement(sql);
				query.setInt(1, alumno.getIdAlum());
				query.setString(2, alumno.getName());
				query.setDate(3, alumno.getFnac());
				query.setFloat(4, alumno.getMedia());
				query.setString(5, alumno.getCurso());
				
				query.executeUpdate();
				conex.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
	public static Alumn read(int idAlumn) {
		Alumn aux = null;
		Connection conex = connect();
		String sql = "select * from alumnos where num = ?";
		
		try {
			PreparedStatement stmt = conex.prepareStatement(sql);
			stmt.setInt(1, idAlumn);
			
			ResultSet query = stmt.executeQuery();
			
			if(query.next()) {
				aux = new Alumn(query.getInt("num"),query.getString("nombre"),query.getDate("fnac"),query.getFloat("media"),query.getString("curso"));
				conex.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aux;
	}
	
	public static void update(Alumn alumno) {
		if(alumno != null) {
			Connection conex = connect();
			String sql = "update alumnos set nombre = ?, fnac = ?, media = ?, curso = ? where num = ?";
			
			try {
				PreparedStatement stmt = conex.prepareStatement(sql);
				stmt.setString(1, alumno.getName());
				stmt.setDate(2, alumno.getFnac());
				stmt.setFloat(3, alumno.getMedia());
				stmt.setString(4, alumno.getCurso());
				stmt.setInt(5, alumno.getIdAlum());
				
				stmt.executeUpdate();
				conex.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void delete(int idAlumn) {
		Connection conex = connect();
		String sql = "delete from alumnos where num = ?";
		
		try {
			PreparedStatement stmt = conex.prepareStatement(sql);
			stmt.setInt(1, idAlumn);
			
			stmt.executeUpdate();
			conex.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// EXERCISE 4
	public static ArrayList<Alumn> list(){
		ArrayList<Alumn> aux = new ArrayList<>();
		Connection conex = connect();
		String sql = "select  * from alumnos";
		
		try {
			PreparedStatement stmt = conex.prepareStatement(sql);
			
			ResultSet query = stmt.executeQuery();
			while(query.next()) {
				aux.add(new Alumn(query.getInt("num"),query.getString("nombre"),query.getDate("fnac"),query.getFloat("media"),query.getString("curso")));
			}
			
			conex.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aux;
	}
	
	//EXERCISE 5
	public static void writeArchArray(String clasroom) {
		ArrayList<Alumn> aux = new ArrayList<>();
		Connection conex = connect();
		String sql = "select  * from alumnos where curso = ?";
		
		try {
			PreparedStatement stmt = conex.prepareStatement(sql);
			stmt.setString(1, clasroom);
			ResultSet query = stmt.executeQuery();
			
			while(query.next()) {
				aux.add(new Alumn(query.getInt("num"),query.getString("nombre"),query.getDate("fnac"),query.getFloat("media"),query.getString("curso")));
			}
			
		
			ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(new File("library\\data.dat")));
		
			for (Alumn alumn : aux) {
				obj.writeObject(alumn);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readArchArray() {
		Alumn aux = null;
		boolean keep=true;
		
		try {
			ObjectInputStream obj = new ObjectInputStream(new FileInputStream(new File("library\\data.dat")));
			// USAMOS UNA VARIABLE BOOLEANA PARA EL BUCLE Y CUANDO SE DE LA EXCEPCION EOFEXCEPTION SALIMOS DEL BUCLE
			while(keep) {
				aux = (Alumn) obj.readObject();
				System.out.println(aux.toString());
				;
			}
			
		} catch (EOFException e) {
			System.out.println("File finish");
			keep=false;
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
