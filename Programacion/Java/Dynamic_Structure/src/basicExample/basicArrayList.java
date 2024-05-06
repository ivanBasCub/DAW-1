package basicExample;

import java.util.ArrayList;
import java.util.Scanner;

public class basicArrayList {

	public static void main(String[] args) {
		
		ArrayList<Integer> dnamic = new ArrayList<Integer>();
		Scanner keyboard = new Scanner(System.in);
				
		// Ask data for ArrayList
		int aux = 0;
		while(true) {
			System.out.println("Give me a number");
			try {
				aux = keyboard.nextInt();
				dnamic.add(aux);
			} catch (Exception e) {
				break;
			}
		}
	
		keyboard.close();
		// Print ArrayList
		for (int i = 0; i < dnamic.size(); i++) {
			System.out.println(dnamic.get(i));
		}
	}
}
