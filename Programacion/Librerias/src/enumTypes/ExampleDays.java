package enumTypes;

import java.util.Scanner;

public class ExampleDays {

	public static void main(String[] args) {
		Days today = Days.THURSDAY;
		
		System.out.println("Today is " + today);

		// go throw all values inside in the variable
		
		System.out.println("Days of the week are: " );
		for (Days aux : Days.values()) {
			System.out.println(aux);
		}
		
		boolean anotherone = true;
		
		while(anotherone) {
			try {
				// ask to the user a value
				Scanner keyboard = new Scanner(System.in);
				System.out.println("Give me a day of the week");
				String aux = keyboard.nextLine();
				today = Days.valueOf(aux.toUpperCase());
				System.out.println(today);
			}catch (IllegalArgumentException e) {
				anotherone = false;
			}
		}
	}

}
