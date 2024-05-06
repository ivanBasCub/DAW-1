package example;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class WriteXML {

	public static void main(String[] args) {
		// 
		try {
			JAXBContext context = JAXBContext.newInstance(Patner.class);
			Marshaller m = context.createMarshaller();
			
			// Create the object to write
			
			Patner par = new Patner(1, "Ivan", "24-04-24");
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Indicar que este bien tabulado el archivo XML
			m.marshal(par, new File(".\\archives","partner.xml"));
			
			
		} catch (JAXBException e) {
		
			e.printStackTrace();
		}
	}
}
