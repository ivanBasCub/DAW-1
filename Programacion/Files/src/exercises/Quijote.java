package exercises;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Quijote {

	public static void main(String[] args) {
		final String PATH = "C:\\Files";
		File quijote = new File(PATH,"\\quijote.txt");
		int count= 0;
		// PARA PODER LEER UN FICHERO PRIMERO TENEMOS QUE ESCRIBIRLO CON dataoutputStream
		try {
			DataInputStream lect = new DataInputStream(new FileInputStream(quijote));
			
			
			
			
			System.out.println(count);
		}
		catch (NullPointerException e) {
			System.out.println(count + " Error null");
		}
		catch (FileNotFoundException e) {
			
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
