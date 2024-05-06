package example;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadXML {

	public static void main(String[] args) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(Patner.class);
			Unmarshaller um = context.createUnmarshaller();
			
			// Read an Object in a XML Archive

			Patner par = (Patner) um.unmarshal(new File(".\\archives","partner.xml"));
			System.out.println(par.toString());
			
		} catch (JAXBException e) {
		
			e.printStackTrace();
		}
	}
	
}
