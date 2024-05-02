package warehouse;

import exceptions.NegativeValueException;

public class App {

	public static void main(String[] args) {
		
		try {
			Appliance house[] = new Appliance[20];
			house[0] = new Appliance(15,"A");
			house[1] = new Appliance(12, "B");;
			house[2] = new Cooler(12, 15, "C");
			house[3] = new Cooler(25, 05, "F");;
			house[4] = new Washer(54, 10, "E");
			house[5] = new Washer(50, 14, "d");
			
			printHouse(house);
			
			house[3] = null;
			printHouse(house);
			
			
		} catch (NegativeValueException e) {
			e.printStackTrace();
		}
		
	}

	private static void printHouse(Appliance[] house) {
		for (Appliance item : house) {
			if (item != null) {
				System.out.println(item.toString());
			}
		}
	}
	
}
