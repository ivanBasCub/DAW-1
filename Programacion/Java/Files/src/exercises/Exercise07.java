package exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Exercise07 {

	public static void main(String[] args) {
		final String PATH = "C:\\Files";
		File fileName = new File(PATH,"Tester.txt");
		String content ="";
		int c,total= 0;
		
		String input = JOptionPane.showInputDialog("Letra que quieras buscar");
		
		
		// SAVE THE INFORMATION OF A VARIABLE
		try {
			FileInputStream fileInput = new FileInputStream(fileName);
			while((c = fileInput.read()) != -1) {
				content = content + (char) c;
			}
			fileInput.close();
			// FIND THE LETTER IN THE CONTENT OF THE FYLE
			for (int i = 0; i < content.length(); i++) {
				if (input.charAt(0) == content.charAt(i)) {
					total ++;
				}
			}
			// SHOW TO THE USER
			JOptionPane.showMessageDialog(null, "Total times appears the letter " + input.charAt(0) + ": " + total, "total", 1);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}