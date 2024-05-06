package company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class App {

	public static void main(String[] args) {
		final String PATH = "C:\\Files";
		int limit;
		do {
			limit = Integer.parseInt(JOptionPane.showInputDialog("How many employees"));
			
		}while(limit <= 0);
		
		// Create a array of objects
		Employee company[] = new Employee[limit];
		
		// Ask the data for the employee
		
		inputData(company);
		
		// Create a file and save the data of the company
		File fich = new File(PATH+"\\company.ftw");

		// ESTE OBJETO NOS PERMITE CREAR UNA PESTAÑA PARA SELECCIONAR EL ARCHIVO EN LA RUTA INDICADA EN EL CONSTRUCTOR
		// JFileChooser chosser = new JFileChooser();
		
		// CREAMOS FILTROS PARA EL OBJETO JFILECHOSSER PARA QUE EL USUARIO PUEDA ELEGIR MAS SENCILLAMENTE EL ARCHIVO BUSCADO
		// FileNameExtensionFilter filter = new FileNameExtensionFilter("Compres Files", "zip","rar");
		
		// COMANDO PARA APLICAR LOS FILTROS 
		// chooser.setFileFilter(filter)
		// chooser.showOpenDialog(null);
		
		// APLICAR EL FICHERO SELECCIONADO POR EL USUARIO
		//File fich = chosser.getSelectedFile();
		
		
		saveData(company, fich);
		
		readData(company, fich);
		
	}

	private static void inputData(Employee[] company) {
		for (int i = 0; i < company.length; i++) {
			
			company[i] = new Employee(null, 0,0);
			company[i].setName(JOptionPane.showInputDialog("Name of the employee"));
			company[i].setSalary(Integer.parseInt(JOptionPane.showInputDialog("The salary of the employee")));
			company[i].setAge(Integer.parseInt(JOptionPane.showInputDialog("The age of the employee")));
		}
	}

	private static void readData(Employee[] company, File fich) {
		try {
			FileInputStream fileStream = new FileInputStream(fich);
			ObjectInputStream objFileRead = new ObjectInputStream(fileStream);
			
			for (Employee employee : company) {
				employee = (Employee) objFileRead.readObject();
				System.out.println(employee.toString());
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	private static void saveData(Employee[] company, File fich) {
		try {
			
			FileOutputStream fileStream = new FileOutputStream(fich);
			ObjectOutputStream objFileWrite = new ObjectOutputStream(fileStream);
			
			for (Employee employee : company) {
				objFileWrite.writeObject(employee);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
