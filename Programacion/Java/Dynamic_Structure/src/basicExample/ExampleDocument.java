package basicExample;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ExampleDocument {

	public static void main(String[] args) {
		ArrayList<Comparable> c = new ArrayList<Comparable>();
		c.add(3);
		c.add(9.5);
		c.add(1,"Hello Majo!!");
		c.add(35);
		System.out.println("Display the Collection");
		displayCollection(c);
		System.out.println("___________________________________");
		// substitute
		c.set(1, "taaaaaaaaaaaaaaaa");
		System.out.println("Display the Collection");
		displayCollection(c);
		System.out.println("___________________________________");
		//deleted
		System.out.println("let's delete the content of position 1");
		c.remove(1);
		displayCollection(c);
		c.remove("taaaaaaaaaaaaaaaa");
		displayCollection(c);
	}

	public static void displayCollection(List<Comparable> c) {
		/*
		ListIterator<Comparable> iterator;
		//involking the ListIterator method were relate the iterator with the list to rerun it
		iterator = c.listIterator();
		String aux;
		//recorrecting the list using the iterator
		
		while (iterator.hasNext()) {
			System.out.println("The following value from the collection: ");
			System.out.println("This is the position: " + iterator.nextIndex());
			
			aux = String.valueOf(iterator.next());
			System.out.println("The value it contains is: " + aux);
		}
		*/
		for (int i = 0; i < c.size(); i++) {
			System.out.println(c.get(i));
		}
		
		/*
		  for (Comparable element : c){
		  	System.out.println(element);
		  }
		*/
	}
}
