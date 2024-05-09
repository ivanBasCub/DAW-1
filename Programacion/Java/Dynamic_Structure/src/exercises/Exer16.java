package exercises;

import java.util.ArrayList;
import java.util.Iterator;

import basicExample.Alumno2;

public class Exer16 {

	public static void main(String[] args) {
		ArrayList<Alumno2> daw = new ArrayList<Alumno2>();
		
		daw.add(new Alumno2("Ivan", 21));
		daw.add(new Alumno2("Nickbeld", 19));
		daw.add(new Alumno2("Grunt", 34));
		daw.add(new Alumno2("Amelia", 18));
		
		Iterator iter = daw.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
