package repasoExamen;

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

public class AlumnoDAO {
	/**
	 * Metodo que nos permite conectarnos con la BBDD
	 * @return
	 */
	private static Connection conexion() {
		Connection con=null;		
		String usr="c##insti",pass="insti";
		String url="jdbc:oracle:thin:@192.168.1.35:1521:xe";
		
		try {
			con = DriverManager.getConnection(url,usr,pass);
		} catch (SQLException e) {
			System.out.println("Error en la conexion a la BBDD");
		}
		return con;
	}
	
	// Ejercicio 3
	public static void create(Alumno al) {
		Connection conexion = conexion();
		String sql = "insert into Alumnos values(?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, al.getId());
			stmt.setString(2, al.getNombre());
			stmt.setDate(3, al.getFecNac());
			stmt.setFloat(4, al.getMedia());
			stmt.setString(5, al.getCurso());
			
			stmt.executeQuery();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Alumno read(int id) {
		Alumno al = null;
		Connection conexion = conexion();
		String sql="Select * from alumnos where num = ?";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet query = stmt.executeQuery();
			
			if(query.next()) {
				al =new Alumno(query.getInt("num"),query.getString("nombre"),query.getDate("Fnac"),query.getFloat("media"), query.getString("curso"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
	
	public static void update(Alumno al) {
		Connection conexion = conexion();
		String sql="update Alumnos set nombre = ?, fnac = ?, media = ?, curso = ? where num = ?";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, al.getNombre());
			stmt.setDate(2, al.getFecNac());
			stmt.setFloat(3,al.getMedia());
			stmt.setString(4, al.getCurso());
			stmt.setInt(5, al.getId());
			
			stmt.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(int id) {
		Connection conexion = conexion();
		String sql="delete from alumnos where num = ?";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	// Ejercicio 1
	public static void notaCorte(float nota, String curso){
		ArrayList<Alumno> aux = new ArrayList<>();
		Connection conexion = conexion();
		String sql = "Select * from alumnos where (media > ? and curso = ?)";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setFloat(1, nota);
			stmt.setString(2, curso);
			
			ResultSet query = stmt.executeQuery();
			
			while (query.next()) {
				aux.add(new Alumno(query.getInt("num"),query.getString("nombre"),query.getDate("Fnac"),query.getFloat("media"), query.getString("curso")));
			}
			
			for (Alumno alumno : aux) {
				System.out.println(alumno.toString());
			}
			conexion.close();
			} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// Ejercicio 2
	public static void informeAlumnosNota(float min, float max) {
		ArrayList<Alumno> aux = new ArrayList<>();
		Connection conexion = conexion();
		String sql = "select * from alumnos where (media > ?  and media < ?)";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setFloat(1, min);
			stmt.setFloat(2, max);
			
			ResultSet query = stmt.executeQuery();
			
			while (query.next()) {
				aux.add(new Alumno(query.getInt("num"),query.getString("nombre"),query.getDate("Fnac"),query.getFloat("media"), query.getString("curso")));
			}
			
			for (Alumno alumno : aux) {
				System.out.println(alumno.toString());
			}
			
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// Ejercicio 4
	public static ArrayList<Alumno> listadoAlumno() {
		ArrayList<Alumno> aux = new ArrayList<>();
		Connection conexion = conexion();
		String sql = "select * from alumnos";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			ResultSet query = stmt.executeQuery();
			
			while(query.next()) {
				aux.add(new Alumno(query.getInt("num"),query.getString("nombre"),query.getDate("Fnac"),query.getFloat("media"), query.getString("curso")));
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aux;
	}
	
	// Ejercicio 5
	public static void writeArchList(String curso) {
		ArrayList<Alumno> aux = new ArrayList<>();
		Connection conexion = conexion();
		String sql = "select * from alumnos where curso = ?";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, curso);
			
			ResultSet query = stmt.executeQuery();
			
			while(query.next()) {
				aux.add(new Alumno(query.getInt("num"),query.getString("nombre"),query.getDate("Fnac"),query.getFloat("media"), query.getString("curso")));
			}
			conexion.close();
			
			ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(new File("library\\data.dat")));
			
			for (Alumno alumno : aux) {
				obj.writeObject(alumno);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readArchList() {
		Alumno al = null;
		boolean keep = true;
		try {
			ObjectInputStream obj = new ObjectInputStream(new FileInputStream(new File("library\\data.dat")));
			
			while(keep) {
				al = (Alumno) obj.readObject();
				System.out.println(al.toString());
			}
		}catch (EOFException e) {
			System.out.println("Fin del archivo");
			keep = false;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
