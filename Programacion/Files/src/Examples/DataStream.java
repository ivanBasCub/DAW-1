package Examples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

	public static void main(String[] args) {
		final String PATH = "C:\\Files";
		String dni ="12345678A";
		int edad = 26;
		String nombre ="Juan Pérez Garcia";
		File fich = new File(PATH+"\\orderLineCharcuteria.dat");
		
		
		// Escritura de un archivo
//		try {
//			DataOutputStream salida = new DataOutputStream(new FileOutputStream(fich));
//			for (int i = 0; i < 5; i++) {
//				writeData(dni, edad, nombre, salida);
//			}
//			salida.close();
//			
//		}catch (IOException e) {
//			System.out.println("Error de entrada/salida");
//			System.exit(0);
//		}
//		
		
		// Lectura de un archivo
		try {
			DataInputStream entrada = new DataInputStream(new FileInputStream(fich));
				readData(entrada);
				
			entrada.close();
		}catch (IOException e) {
			System.out.println("Error de entrada/salida");
			System.exit(0);
		}
		
	}

	private static void readData(DataInputStream entrada) throws IOException {
		String dni;
		int edad;
		String nombre;
		dni = entrada.readUTF();
		entrada.readChar(); // Eliminar el tabulador 
		edad=entrada.readInt();
		entrada.readChar();
		nombre = entrada.readUTF();
		System.out.println("DNI: " + dni + "\tEdad: " + edad + "\tNombre: "+ nombre);
	}

	private static void writeData(String dni, int edad, String nombre, DataOutputStream salida) throws IOException {
		salida.writeUTF(dni);
		salida.writeInt(edad);
		salida.writeUTF(nombre);
	}
}
