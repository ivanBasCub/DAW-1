package Examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInput {

	public static void main(String[] args) {
		final String PATH ="C:\\Files";
		File fileName = new File(PATH, "Test.txt");
		printFile(fileName);
		writeFile(fileName);
		printFile(fileName);
	}

	
	// Hay una clase mejor File writer and File reader
	// Cargar informacion en el buffer BufferedReader o BufferedWriter
	// Clase Scanner es para leer la informacion de un fiechero
	private static void writeFile(File fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName,true);
			String frase = "Buenos dias";
			for (int i = 0; i < frase.length(); i++) {
				fileOut.write(frase.charAt(i));
			}
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void printFile(File fileName) {
		int c;
		try {
			FileInputStream fileInput = new FileInputStream(fileName);
			while((c = fileInput.read()) != -1) {
				System.out.print((char) c);
			}
			System.out.println();
			fileInput.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
