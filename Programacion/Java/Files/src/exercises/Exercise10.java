package exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Exercise10 {

	public static void main(String[] args) {
		final String PATH = "C:\\Files";
		String fileName;
		
		// Ask for the name of two files
		fileName = JOptionPane.showInputDialog("Introduce the name of the archive format (name.extension)");
		File file1 = new File(PATH,fileName);
		fileName = JOptionPane.showInputDialog("Introduce the name of the archive format (name.extension)");
		File file2 = new File(PATH,fileName);
		
		// Show the information in the screen
		printFile(file1);
		printFile(file2);
		
	}
	
	private static void printFile(File fileName) {
		int c;
		try {
			FileInputStream fileInput = new FileInputStream(fileName);
			System.out.print(fileName.getName()+ ": ");
			
			while((c = fileInput.read()) != -1) {
				System.out.print((char) c);
			}
			System.out.println();
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
