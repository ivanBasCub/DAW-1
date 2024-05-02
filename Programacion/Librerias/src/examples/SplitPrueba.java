package examples;

public class SplitPrueba {

	public static void main(String[] args) {
		String orig ="aaa##bbb$$ccc";
		String[] result = orig.split("##|\\$\\$");
		for (String string : result) {
			System.out.println(string);
		}
		
	}
	
}
