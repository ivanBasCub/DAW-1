package exercises;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Exer03 {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> options = new ArrayList<String>();
		options.add("Add a Name");
		options.add("Search a Name");
		options.add("Remove a Name");
		options.add("Display the List");
		options.add("Exit");
		int op;
		do {
			op = JOptionPane.showOptionDialog(null, "Select a Option", "Choose One", 0, JOptionPane.INFORMATION_MESSAGE, null, options.toArray(), 0);
			
			switch (op) {
			case 0:
				names.add(JOptionPane.showInputDialog(null, "Give me a name", null, JOptionPane.INFORMATION_MESSAGE).toLowerCase());
				break;
			case 1:
				names.remove(JOptionPane.showInputDialog(null, "Remove the next Name", null, JOptionPane.INFORMATION_MESSAGE));
				break;
			case 2:
				boolean check = names.contains(JOptionPane.showInputDialog(null, "Search the name", null, JOptionPane.INFORMATION_MESSAGE).toLowerCase());
				if (check) {
					JOptionPane.showMessageDialog(null, "The name exists inside the list");
				}else {
					JOptionPane.showMessageDialog(null, "The name doesn't exists inside the list");
				}
				break;
			case 3:
				for (int i = 0; i < names.size(); i++) {
					System.out.println(names.get(i));
					
				}
				System.out.println("__________________________________");
				break;
			default:
				
			}
			
		}while(op != 4);
	}
}
