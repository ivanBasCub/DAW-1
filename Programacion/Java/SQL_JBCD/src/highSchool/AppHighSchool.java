package highSchool;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class AppHighSchool {

	public static void main(String[] args) {
		String[] options = {"Exercise 1","Exercise 2","Exercise 4","Exercise 5","Exit"};
		ArrayList<Alumn> alumns;
		int option;
		
		do {
			option = JOptionPane.showOptionDialog(null, "Select One", "Menu", 0, 1, null, options, 0);
			
			switch (option) {
			
			//Exercise 1
			case 0:
				float note = Float.parseFloat(JOptionPane.showInputDialog("Give the cut-off mark (0-10)"));
				String curso = JOptionPane.showInputDialog("Give me the curso (1A,1B,2A,2B)");
				
				if (note >= 0 && note <= 10) {
					alumns = AlumnDAO.alumListNote(note, curso);
					
					for (Alumn alumn : alumns) {
						System.out.println(alumn.toString());
					}
					
					alumns.clear();
					
				}else {
					JOptionPane.showMessageDialog(null, "Error: The cut-off mark is out of values indicate");
				}
				break;
				
			// Exercise 2
			case 1:
				String[] optinforms = {"Good","Notable"};
				
				int opt = JOptionPane.showOptionDialog(null, "Select One type the inform", "Menu", 0, 1, null, optinforms, 0);
				
				if (opt == 0) {
					alumns = AlumnDAO.listAlumn(6, 7);
					
					for (Alumn alumn : alumns) {
						System.out.println(alumn.toString());
					}
				}else {
					alumns = AlumnDAO.listAlumn(7, 9);
					
					for (Alumn alumn : alumns) {
						System.out.println(alumn.toString());
					}
				}
				
				alumns.clear();
				
				break;
			
			// EXERCISE 4
			case 2:
				alumns = AlumnDAO.list();
				

				System.out.println("Order by the name");
				alumns.sort(new Compa());
				for (int i = 0; i < alumns.size(); i++) {
					System.out.println(alumns.get(i).toString());
				}
				
				System.out.println("Order by the id");
				Collections.sort(alumns);
				for (int i = 0; i < alumns.size(); i++) {
					System.out.println(alumns.get(i).toString());
				}
				
				break;
			case 3:
				curso = JOptionPane.showInputDialog("Give me the classrom");
				AlumnDAO.writeArchArray(curso);
				
				AlumnDAO.readArchArray();
				break;
			}
			
		}while(option != options.length-1);
		
	}
}
