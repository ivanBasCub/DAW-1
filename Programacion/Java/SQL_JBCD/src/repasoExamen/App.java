package repasoExamen;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) {
		ArrayList<Alumno> insituto;
		String[] botones = {"Ejercicio 1","Ejercicio 2","Ejercicio 4","Ejercicio 5","Salir"};
		int opcion;
		
		String[] btnEj2 = {"Bien","Notable"};
		int opEj2;
		
		String curso;
		float media;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Seleccionar una opcion", "Menu", 0, 1, null, botones, 0);
			
			switch (opcion) {
			// Ejercicio 1
			case 0:
				media = Float.parseFloat(JOptionPane.showInputDialog("La nota de corte"));
				curso = JOptionPane.showInputDialog("El curso que quieres comprobar");
				
				AlumnoDAO.notaCorte(media, curso);
				break;
			// Ejercicio 2
			case 1:
				opEj2 = JOptionPane.showOptionDialog(null, "Seleccionar una opcion", "Ejercicio 2", 0, 1, null, btnEj2, 0);
				
				if (opEj2 == 0) {
					AlumnoDAO.informeAlumnosNota(6, 7);
				}else {
					AlumnoDAO.informeAlumnosNota(7, 9);
				}
				break;
				
			// Ejercicio 4
			case 2:
				insituto = AlumnoDAO.listadoAlumno();
				
				System.out.println("Listado de alumnos por Id");
				Collections.sort(insituto);
				
				for (Alumno alumno : insituto) {
					System.out.println(alumno.toString());
				}
				
				System.out.println("Listado de alumnos por Nombre");
				insituto.sort(new AlumnoComparator());
	
				for (Alumno alumno : insituto) {
					System.out.println(alumno.toString());
				}
				
				insituto.clear();
				
				break;
			case 3:
				curso = JOptionPane.showInputDialog("El curso que quieres comprobar");
				
				AlumnoDAO.writeArchList(curso);
				AlumnoDAO.readArchList();
			}
		}while(opcion != botones.length-1);
	}
}
