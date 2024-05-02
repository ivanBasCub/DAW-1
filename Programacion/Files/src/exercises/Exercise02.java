package exercises;

import java.io.File;

public class Exercise02 {

	public static void main(String[] args) {
		final String PATH ="C:\\Files";
		File fileName = new File(PATH);
		String[] files = fileName.list();
		
		for (String aux : files) {
			System.out.println(aux);
		}
		
		
	}
}
