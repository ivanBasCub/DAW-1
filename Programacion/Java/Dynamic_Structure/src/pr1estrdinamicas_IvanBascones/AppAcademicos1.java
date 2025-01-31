package pr1estrdinamicas_IvanBascones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JOptionPane;


public class AppAcademicos1 {

	public static void main(String[] args) {
		HashMap<Character, Academico> realAcademia = new HashMap<>();
		// 	EL METODO FUNCIONA POR LO QUE VOY A DEJAR 4 EJEMPLOS PARA HACER LAS PRUEBAS

//		for (int i = 0; i < 3; i++) {
//			nuevoAcademico(realAcademia);
//		}
		realAcademia.put('Z',new Academico("Ivan",2010));
		realAcademia.put('J',new Academico("Zacarias",1800));
		realAcademia.put('A',new Academico("Julio",1700));
		realAcademia.put('F',new Academico("Angela",2100));
		
		System.out.println("Ordenar por el nombre:");
		listaAcademicosNom(realAcademia);
		System.out.println("-------------------------------------");
		System.out.println("Ordenar por Año:");
		listaAcademicoIngreso(realAcademia);
		System.out.println("-------------------------------------");
		System.out.println("Ordenar por la clave:");
		ListaAcademicoClave(realAcademia);
		// INSERTAMOS LA INFORMACION EN EL ARCHIVO
		insertarinformacion(realAcademia);
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
	
	// MOSTAR LA LISTA DE ACADEMICOS EN ORDEN AL NOMBRE
	private static void listaAcademicosNom(HashMap<Character, Academico> academia) {
		List<Academico> lista = new ArrayList<>(academia.values());
		
		Collections.sort(lista);
		
		for (Academico academico : lista) {
			System.out.println(academico.getName());
		}
	}
	
	// MOSTAR LA LISTA DE ACADEMICOS EN ORDEN AL AÑO DE INGRESO
	private static void listaAcademicoIngreso(HashMap<Character, Academico> academia) {
        List<Academico> lista = new ArrayList<>(academia.values());
        
        lista.sort(Comparator.comparingInt(a -> a.getaIngreso()));
        for (Academico academico : lista) {
            System.out.println(academico.getName() + " " + academico.getaIngreso());
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
