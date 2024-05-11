package exercises;

import java.util.ArrayList;
import java.util.Iterator;

import basicExample.Alumno2;

public class Exer14 {

	public static <E> void main(String[] args) {
	       
        ArrayList clase = new ArrayList();
        Alumno2 alum;
        
        clase.add(new Alumno2("Pepe",17));
        clase.add("John");
        clase.add(28);
        
        Iterator iter=clase.iterator();

        while (iter.hasNext()){
        	System.out.println(iter.next());
        	
        }
    }

}
