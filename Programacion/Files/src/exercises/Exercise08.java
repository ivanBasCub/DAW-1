package exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Exercise08 {

	public static void main(String[] args) {
		final String PATH = "C:\\Files";
		String fileName;
		boolean repeat = true;
		boolean check = false;
		// Ask for the name of two files
		fileName = JOptionPane.showInputDialog("Introduce the name of the archive format (name.extension)");
		File file1 = new File(PATH,fileName);
		fileName = JOptionPane.showInputDialog("Introduce the name of the archive format (name.extension)");
		File file2 = new File(PATH,fileName);
		try {
			FileInputStream file1Content = new FileInputStream(file1);
			FileInputStream file2Content = new FileInputStream(file2);
				
			do {
				
				if(file1Content.read()== file2Content.read()) {
					check= true;
				}else {
					check = false;
					break;
				}
				
				
			}while(file1Content.read() != -1|| file2Content.read() != -1);
			
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		
		
		if (check) {
			System.out.println("Are the same");
		}else {
			System.out.println("Aren't the same");
		}
		
		
	}
	
}
