package exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Exercise09 {

	public static void main(String[] args) {
		final String PATH = "C:\\Files";
		String fileName;
		
		// Ask for the name of the file do you want to copy
		fileName = JOptionPane.showInputDialog("Introduce the name of the archive format (name.extension)");
		File file1 = new File(PATH,fileName);
		
		// Extract the content of the file
		
		copyFile(PATH, fileName, file1);
	}

	private static void copyFile(final String PATH, String fileName, File file1) {
		int c;
		String content = "";
		try {
			FileInputStream fileInput = new FileInputStream(file1);
			while((c = fileInput.read()) != -1) {
				content += (char) c;
			}
			fileInput.close();
			
			fileName = fileName.substring(0, fileName.length()-4) + "copy" + fileName.substring(fileName.length()-4, fileName.length());
			
			File fileCopy = new File(PATH,fileName);
			
			writeFile(fileCopy,content);
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeFile(File fileName,String content) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName,true);
			
			for (int i = 0; i < content.length(); i++) {
				fileOut.write(content.charAt(i));
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
	
}
