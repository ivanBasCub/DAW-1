package example;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class WriteArrayXml {

	public static void main(String[] args) {
		
		// Create a vector to keep the info of the objects 
		Patner[] aux = new Patner[3];
		
		aux[0] = new Patner(10,"Jose Manuel","24-05-2024");
		aux[1] = new Patner(20,"Anacleto","22-05-2024");
		aux[2] = new Patner(30,"Pedro Sanchez","20-05-2024");
		
		// Save the vector inside a "superclass" to create the root of the XML File
		Group grupo = new Group(aux);
		
		// writeFail1(aux);
		
		writeCorrect(grupo);
	}

	// Write the "superclass" inside the XML file to save all the objects inside the array
	private static void writeCorrect(Group grupo) {
		try {
			// PUEDES MODIFICAR LOS XML EN EL CASO DE LA QUE LA CLASE NO TENGA UN TAMAÑO PREDEFINIDO EN EL ARRAY
			JAXBContext context = JAXBContext.newInstance(Group.class);
			Marshaller m = context.createMarshaller();
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(grupo, new File(".\\archives","group.xml"));
			
			
		} catch (JAXBException e) {
		
			e.printStackTrace();
		}
	}
	
	// WITH A NORMAL ARRAY OF OBJECTS ONLY SAVE IN THE FILE THE LAST ONE
	// NOT THE CORRECT OPTION
	
	// POSIBLE OPTION IT CREATE A OBJECT TO SAVE THE ARRAY AND PRINT
	private static void writeFail1(Patner[] group) {
		try {
			JAXBContext context = JAXBContext.newInstance(Patner.class);
			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
			
			for (Patner patner : group) {
				m.marshal(patner, new File(".\\archives","group.xml"));
			}
	
		} catch (JAXBException e) {
		
			e.printStackTrace();
		}
	}
}
