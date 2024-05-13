package hashMap;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Exer06 {

	public static void main(String[] args) {
		HashMap<Character, Academico> Ral = new HashMap<>();
		boolean exit = false;
	
		for (int i = 0; i <3; i++) {
			newAcademic(Ral);
		}
		
		visualize(Ral);
	}
	
	private static void visualize(HashMap<Character, Academico> hash) {
		char clave;
		Academico valor;
		for (Map.Entry<Character, Academico> element : hash.entrySet()) {
			clave = element.getKey();
			valor = element.getValue();
			System.out.println("> " + clave + ": " +valor.toString());
		}
	}

	
	public static boolean newAcademic(HashMap<Character, Academico> Ral) {
		char letter;
		String name;
		int year;
		
		letter = JOptionPane.showInputDialog("chair he occupies").charAt(0);
		name = JOptionPane.showInputDialog("Name of the academic");
		year = Integer.parseInt(JOptionPane.showInputDialog("Year"));
		
		if (letter >= 'A' && letter <= 'a') {
			Ral.put(letter, new Academico(name, year));
			return true;
		}else {
			return false;
		}
		
		
		

	}
}
