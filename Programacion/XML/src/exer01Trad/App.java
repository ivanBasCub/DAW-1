package exer01Trad;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import exer1Class.LineOrder;
import exer1Class.Lines;

public class App {

	public static void main(String[] args) {
		String[] options = {"Write a XML","Read a XML","Write a Object","Read a Object","Object to XML", "XML to Object","Exit"};
		boolean exit = false;
		// Create a Array of objects
		LineOrder[] aux = new LineOrder[3];
		
		aux[0] = new LineOrder("Manzana",10,40);
		aux[1] = new LineOrder("Pera",25,30);
		aux[2] = new LineOrder("Mandarina",15,35);
		
		Arrays.sort(aux);
		
		Lines order = new Lines(aux);
		do {
			
			int choose = JOptionPane.showOptionDialog(null, "Choose one of the options below", "Menu", 0, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
			
			switch (choose) {
			case 0:
					writeXML(order);
				break;
			case 1:
					readXML();
				break;
			case 2:
					writeObjects(aux);
				break;
			case 3:
					readObjects();
				break;
			case 4:
				ObjectToXML();
				break;
			case 5:
				xmlToObject();
				break;
			default:
					exit = true;
				break;
			}
			
		}while(!exit);

	}
	
// Object to XML
private static void ObjectToXML() {
	try {
		ObjectInputStream fich = new ObjectInputStream(new FileInputStream(new File("C:\\Files","order.dat")));
		LineOrder[] aux = new LineOrder[3];
		boolean exit = false;
		int count = 0;
		do {
			try {
				aux[count] = (LineOrder) fich.readObject();
				count++;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (EOFException e) {
				exit = true;
			}
			
		}while(!exit);

		Lines order = new Lines(aux);
		
		JAXBContext context = JAXBContext.newInstance(Lines.class);
		Marshaller m = context.createMarshaller();
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(order, new File("C:\\Files","order.xml"));
		
		fich.close();
		
		JOptionPane.showMessageDialog(null, "The information pass to correctly to the XML");
	} catch ( IOException | JAXBException e) {
		e.printStackTrace();
	}
}
	
// XML to object Archive	
private static void xmlToObject() {
	try {
		JAXBContext context = JAXBContext.newInstance(Lines.class);
		Unmarshaller um = context.createUnmarshaller();
		
		Lines order = (Lines) um.unmarshal(new File("C:\\Files","order.xml"));
		
		ObjectOutputStream fich = new ObjectOutputStream(new FileOutputStream(new File("C:\\Files","order.dat")));
		
		// Call the method getter to get the array for objects inside the "superclass"
		for (LineOrder pat : order.getLines()) {
			fich.writeObject(pat);
		}
		
		fich.close();
		
		JOptionPane.showMessageDialog(null, "The information pass to correctly to the Object Archive");
	} catch (JAXBException | IOException e) {
	
		e.printStackTrace();
	}
}

	
// Objects
	
	// Write Archive
private static void writeObjects(LineOrder[] order) {
	try {
		ObjectOutputStream fich = new ObjectOutputStream(new FileOutputStream(new File("C:\\Files","order.dat")));
		
		for (int i = 0; i < order.length; i++) {
			fich.writeObject(order[i]);
		}
		
		fich.close();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}

	// Read Archive
private static void readObjects() {
	try {
		ObjectInputStream fich = new ObjectInputStream(new FileInputStream(new File("C:\\Files","order.dat")));
		boolean exit = false;
		do {
			try {
				LineOrder line = (LineOrder) fich.readObject();
				System.out.println(line.toString());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (EOFException e) {
				exit = true;
			}
			
		}while(!exit);
		
		fich.close();
	} catch (IOException e) {

		e.printStackTrace();
	}
}
	
// XML
	
	// Write a array of Objects in XML
	private static void writeXML(Lines order) {
		try {
			JAXBContext context = JAXBContext.newInstance(Lines.class);
			Marshaller m = context.createMarshaller();
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(order, new File("C:\\Files","order.xml"));
			
			
		} catch (JAXBException e) {
		
			e.printStackTrace();
		}
	}
	
	// Read a array of Objects in XML
	private static void readXML() {
		try {
			JAXBContext context = JAXBContext.newInstance(Lines.class);
			Unmarshaller um = context.createUnmarshaller();
			
			Lines order = (Lines) um.unmarshal(new File("C:\\Files","order.xml"));
			// Call the method getter to get the array for objects inside the "superclass"
			for (LineOrder pat : order.getLines()) {
				System.out.println(pat.toString());
			}
			
		} catch (JAXBException e) {
		
			e.printStackTrace();
		}
	}
}
