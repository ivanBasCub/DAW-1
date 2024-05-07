package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exer02 {

	public static void main(String[] args) {
		// Create a ArrayList of Strings
		ArrayList<String> lista = new ArrayList<String>();
		Scanner keyboard = new Scanner(System.in);
		String aux;
		boolean exit = false;
		
		while(!exit) {
			System.out.println("Give me a String");
			aux = keyboard.nextLine();
			switch (aux) {
			case "0":
					exit = true;
				break;
			default:
				lista.add(aux);
			break;
			}
		}
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
}
