package pr1estrdinamicas_IvanBascones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JOptionPane;



public class AppAcademicos2 {

	
	public static void main(String[] args) {
		// CREAMOS EL MISMO HASHMAP QUE EN LA ANTERIOR PARTE PARA PODER GUARDAR LA INFORMACIÓN DEL ARCHIVO Y MODIFICARLO
		HashMap<Character, Academico> realAcademia = new HashMap<>();
		// VARIABLES QUE SON NECESARIAS PARA LA CREACIÓN DEL MENU Y EL BUCLE
		String[] options = {"Listar los academicos por nombre","Listar los academicos por letra","Añadir un academico","Borrar un academico por letra","Salir"};
		boolean exit = false;
		int result;
		
		String filename = "academicos.dat";
		// CONSEGUIR LA INFORMACIÓN DEL ARCHIVO Y PASARLA AL HASHMAP
		try {
			ObjectInputStream archive = new ObjectInputStream(new FileInputStream(new File(".\\archives",filename)));
			realAcademia = (HashMap<Character, Academico>) archive.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		// MENU INFORMATIVO PARA EL USUARIO
		do {
			result = JOptionPane.showOptionDialog(null, "Selecciona la siguiente opcion:", "Menu", 0, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
			
			switch (result) {
			case 0:
				listaAcademicosNom(realAcademia);
				break;
			case 1:
				ListaAcademicoClave(realAcademia);
				break;
			case 2:
				nuevoAcademico(realAcademia);
				break;
			case 3:
				char aux = JOptionPane.showInputDialog("Sillon que quieras borrar").charAt(0);
				if((aux >= 'A' && aux <= 'Z')|| (aux >= 'a' && aux <= 'z')) {
					realAcademia.remove(aux);
				}
				break;	
			case 4:
				exit = true;
				break;
			}
		}while(!exit);
		
		// INTRODUCIR LA COMO QUEDO LA INFORMACION EN EL ARCHIVO DAT
		insertarinformacion(realAcademia);
	}
	
	// MOSTAR LA LISTA DE ACADEMICOS EN ORDEN AL NOMBRE
	private static void listaAcademicosNom(HashMap<Character, Academico> academia) {
		List<Academico> lista = new ArrayList<>(academia.values());
	
		Collections.sort(lista);
			
		for (Academico academico : lista) {
			System.out.println(">" + academico.getName());
		}
	}
	
	// MOSTAR LA LISTA DE ACADEMICOS EN ORDEN LA SILLA
	private static void ListaAcademicoClave(HashMap<Character, Academico> academia) {	
		TreeMap<Character, Academico> aux = new TreeMap<>();
		
		aux.putAll(academia);
		
		for (char letra : aux.keySet()) {
			System.out.println("Clave: " + letra + ", Nombre: " + aux.get(letra).getName());
		}
	}
		
	// CREAMOS EL METODO DE NUEVOACADEMICO PARA INSERTAR EN EL MAPA LOS DATOS
	private static boolean nuevoAcademico(HashMap<Character, Academico> realAcademia) {
			char letter;
			String aux;
			int year;
			
			// PEDIMOS LOS DATOS AL USUARIO
			
			aux = JOptionPane.showInputDialog("Nombre del Academico");
			year = Integer.parseInt(JOptionPane.showInputDialog("Año de Ingreso"));
			letter = JOptionPane.showInputDialog("Sillon que ocupa").charAt(0);
			
			// CREAMOS EL OBJETO
			Academico nuevo = new Academico(aux, year);
			
			// COMPROBAMOS SI LA LETRA INTRODUCIDA ES CORRECTO 
			if((letter >= 'A' && letter <= 'Z')|| (letter >= 'a' && letter <= 'z')) {
				realAcademia.put(letter, nuevo);
				return true;
			}else {
				return false;
			}
	}
		
	// GUARDAR LA INFORMACION EN UN ARCHIVO DE DATOS
	private static void insertarinformacion(HashMap<Character, Academico> academia) {
		String filename ="academicos.dat";
			
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(".\\archives",filename)));
				
			oos.writeObject(academia);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
