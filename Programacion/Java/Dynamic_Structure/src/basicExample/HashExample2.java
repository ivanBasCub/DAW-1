package basicExample;

import java.util.HashSet;
import java.util.Iterator;

public class HashExample2 {

	public static void main(String[] args) {
		HashSet<Alumno> daw1 = new HashSet<Alumno>();
		HashSet<Alumno> daw2 = new HashSet<Alumno>();
		
		Alumno alu1 = new Alumno(1, "Studar", 15, "DAW1");
		Alumno alu2 = new Alumno(2, "Steve", 15, "DAW1");
		Alumno alu3 = new Alumno(3, "Alsemo", 15, "DAW1");
		Alumno alu4 = new Alumno(4, "leocadio", 15, "DAW1");
				
		daw1.add(new Alumno(5, "Macareno", 15, "DAW1"));
		daw1.add(alu4);
		
		visualizeSet(daw1);
		
		daw2.addAll(daw1); // adding a full collection
		
		daw2.add(alu2);
		daw2.add(alu1);
		daw2.add(alu3);
		
		System.out.println("--------------------------");
		visualizeSet(daw2);
		daw2.remove(alu2); // Remove a object
		
		// removeElement(daw2);
		
		System.out.println("--------------------------");
		visualizeSet(daw2);

		daw2.retainAll(daw1); // BORRAR TODO MENOS LO INDICADO
		
		// daw2.removeAll(daw1); // Remove a collection
		System.out.println("--------------------------");
		visualizeSet(daw2);
	}

	private static void removeElement(HashSet<Alumno> daw2) {
		Iterator iter = daw2.iterator();
		
		while(iter.hasNext()) {
			Alumno aux = (Alumno) iter.next();
			
			if(aux.getId()==4) {
				iter.remove();
			}
		}
	}
	
	public static void visualizeSet(HashSet<Alumno> daw1) {
		Iterator iterator = daw1.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
