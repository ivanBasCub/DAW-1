package exercises;

import java.util.ArrayList;

import basicExample.Alumno2;

public class Exer17 {

	public static void main(String[] args) {
		ArrayList<Alumno2> daw = new ArrayList<Alumno2>();
		// Add students inside the ArrayList
		
		daw.add(new Alumno2("Ivan", 21));
		daw.add(new Alumno2("Nickbeld", 17));
		daw.add(new Alumno2("Grunt", 34));
		daw.add(new Alumno2("Amelia", 15));
		
		// Visualize the students inside the array when the age is below 18
		for (Alumno2 menor : daw) {
			if(menor.getEdad() < 18) {
				System.out.println(menor);
			}
		}
		
		// Remove the students under 18
		System.out.println("----------------------------------");
		for (int i = 0; i < daw.size(); i++) {
			if(daw.get(i).getEdad() < 18) {
				daw.remove(i);
			}
		}
		
		// Remove the students with less 18 ages
		for (Alumno2 clase : daw) {
			System.out.println(clase);
		}
		
	}

}
