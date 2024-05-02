package exercises;

import java.io.File;

public class Exercise04 {

	public static void main(String[] args) {
		
		final String PATH ="C:\\Files";
		File fileName = new File(PATH);
		File[] files = fileName.listFiles();
		
		for (File aux : files) {
			if (aux.isDirectory()) {
				System.out.println("d- " + aux.getName());
			}else {
				System.out.println("f- " + aux.getName());
			}
		}
	
	}
}