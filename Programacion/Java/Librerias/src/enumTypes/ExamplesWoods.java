package enumTypes;

public class ExamplesWoods {

	public static void main(String[] args) {
		
		for (WoodType aux : WoodType.values()) {
			System.out.println("type: " + aux + " color: " + aux.getCOLOR() + " Density: " + aux.getDENSITY());
		}
		
	}
	
}
