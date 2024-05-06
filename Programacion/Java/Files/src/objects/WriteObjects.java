package objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjects {

	private static Products[] list = new Products[4];
	
	public static void main(String[] args) {
		final String PATH = "C:\\Files";
		
		list[0] = new Products("Chicken Meat", 5, 10.5);
		list[1] = new Products("Pork Meat", 3, 8);
		list[2] = new Products("Beef burger", 10, 5);
		list[3] = new Products("Chicken wings", 10, 10);
	
		try {
			// CREAMOS EL ARCHIVO PARA ALMACENAR LOS OBJETOS
			File fich = new File(PATH+"\\FastFood.ftw");
			FileOutputStream fileStream = new FileOutputStream(fich,true); // SI AÑADES TRUE NO SOBRESESCRIBES EL ARCHIVO
			ObjectOutputStream objFileWrite = new ObjectOutputStream(fileStream);
			
			// ESCRIBIENDO LOS OBJETOS
			for (Products product : list) {
				objFileWrite.writeObject(product);
			}
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
