package hashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapDinamicExample {

	public static void main(String[] args) {
		// Se indica que tipo de datos se introduce (Clave / Valor)
		HashMap<Integer, String> hash = new HashMap<>();
		
		// Introducimos alguanos datos
		hash.put(1, "One");
		hash.put(2, "Two");
		hash.put(3, "Three");
		// en el caso de que usemos un system out println nos muestra el valor anterior
		System.out.println(hash.put(4, "Four"));
		
		// Ver el contenido de un hashMap
		System.out.println("-----------------------------");
		visualizeFor(hash);
		
		// Borrar un contenido del hash
		hash.remove(2);
		System.out.println("-----------------------------");
		visualizeFor(hash);
		
		// para ver si un elemento existe en el hashMap
		System.out.println("-----------------------------");
		System.out.println(hash.containsKey(2));
		System.out.println(hash.containsValue("Four"));
		System.out.println("-----------------------------");
		
		// usar un bucle for-each para recorrer el hashMap
		
		visualizeForEach(hash);
		
	}

	private static void visualizeForEach(HashMap<Integer, String> hash) {
		int clave;
		String valor;
		for (Map.Entry<Integer, String> element : hash.entrySet()) {
			clave = element.getKey();
			valor = element.getValue();
			System.out.println("> " + clave + ": " +valor);
		}
	}

	private static void visualizeFor(HashMap<Integer, String> hash) {
		for (int i = 1; i <= hash.size(); i++) {
			System.out.println(hash.get(i));
		}
	}
}
