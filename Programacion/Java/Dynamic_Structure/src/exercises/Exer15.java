package exercises;

import java.util.ArrayList;

import basicExample.Alumno2;

public class Exer15 {

	public static void main(String[] args) {
		ArrayList<Alumno2> daw = new ArrayList<Alumno2>();
		
		daw.add(new Alumno2("Ivan", 21));
		daw.add(new Alumno2("Nickbeld", 19));
		daw.add(new Alumno2("Grunt", 34));
		daw.add(new Alumno2("Amelia", 18));
		
		for (Alumno2 alum : daw) {
			System.out.println(alum.toString());
		}
	}
}
