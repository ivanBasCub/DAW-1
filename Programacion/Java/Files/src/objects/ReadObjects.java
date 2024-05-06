package objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.ObjectInputStream;


public class ReadObjects {

	private static Products[] list = new Products[4];
	
	public static void main(String[] args) {
		final String PATH = "C:\\Files";
		try {
			// CREAMOS EL ARCHIVO PARA ALMACENAR LOS OBJETOS
			File fich = new File(PATH+"\\FastFood.ftw");
			FileInputStream fileStream = new FileInputStream(fich);
			ObjectInputStream objFileRead = new ObjectInputStream(fileStream);
			
			// LEEMOS LOS OBJETOS
			for (int i = 0; i < list.length; i++) {
				list[i] = (Products) objFileRead.readObject();
				System.out.println(list[i].toString());
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
