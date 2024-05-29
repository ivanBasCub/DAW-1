package repasoExamen;

import java.util.Comparator;

public class AlumnoComparator implements Comparator<Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
		return o1.getNombre().compareToIgnoreCase(o2.getNombre());
	}

}
