package Examples;

import java.io.File;
import java.io.IOException;

public class UsingFiles {

	public static void main(String[] args) {
		final String PATH ="C:\\Files";
		File fileName = new File(PATH,"prueba.png");
		
		if (!fileName.exists()) {
			System.out.println("Does not exists");
			System.out.println("relative-> " + fileName.getPath());
			System.out.println("absolute-> " + fileName.getAbsolutePath());
			try {
				fileName.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
				System.out.println("absolute-> " + fileName.getAbsolutePath());
				
				if (fileName.isDirectory()) {
					System.out.println("Is a directory");
				}else {
					System.out.println("Is a file");
				}
		}
	}
}
