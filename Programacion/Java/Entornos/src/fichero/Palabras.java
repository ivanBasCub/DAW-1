package fichero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Palabras {

	ArrayList<String> palabras = new ArrayList<>();
	
	public String aleatorio() {
		int num = (int) (Math.random() * (palabras.size()));
		return palabras.get(num);
	}
	
	public void readFile() {
		try {
			ObjectInputStream obj = new ObjectInputStream(new FileInputStream(new File("..\\archives\\data.txt")));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
