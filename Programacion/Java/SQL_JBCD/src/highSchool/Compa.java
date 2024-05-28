package highSchool;

import java.util.Comparator;

public class Compa implements Comparator<Alumn>{

	@Override
	public int compare(Alumn o1, Alumn o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}
