package basicExample;

import java.util.HashSet;
import java.util.Iterator;

public class HashExample {

	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(1);
		set.add("Anacleto");
		set.add("Anselmo");
		set.add(24);
		set.add('a');
		
		Iterator iterator = set.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
