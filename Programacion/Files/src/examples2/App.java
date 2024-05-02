package examples2;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import objects.Products;

public class App {
	
	public static void main(String[] args) {
		final String PATH = "C:\\Files";
		Products[] listPorducts = new Products[5];
		
		// Para meter datos usaremos los archivos .dat
		File fich = new File(PATH+"\\prueba.dat");
		
		for (int i = 0; i < listPorducts.length; i++) {
			inputDataProducts(listPorducts, i);
		}
		
		try {
			DataOutputStream output = new DataOutputStream(new FileOutputStream(fich));
			
			
			for (int i = 0; i < listPorducts.length; i++) {
				output.writeUTF(listPorducts[i].getDescription());
				output.writeInt(listPorducts[i].getUnits());
				output.writeDouble(listPorducts[i].getPrice());
			}
			
			for (Products products : listPorducts) {
				System.out.println(products.toString());
			}
			
		} 
		catch (EOFException e) {
			System.out.println("Finish the archive");
			
		}
		catch (IOException e) {
			System.out.println("Error de entrada/salida");
		}
		
	}

	private static void inputDataProducts(Products[] listPorducts, int i) {
		String input;
		int aux;
		listPorducts[i] = new Products( "",0, 0);
		input = JOptionPane.showInputDialog("Give me the units of the product");
		aux = Integer.parseInt(input);
		listPorducts[i].setUnits(aux);
		input = JOptionPane.showInputDialog("Give me the prize of the product");
		aux = Integer.parseInt(input);
		listPorducts[i].setPrice(aux);
		input = JOptionPane.showInputDialog("Give me the desciption of the product");
		listPorducts[i].setDescription(input);
	}
	
}
