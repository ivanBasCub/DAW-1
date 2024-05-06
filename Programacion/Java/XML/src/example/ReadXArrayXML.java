package example;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadXArrayXML {

	public static void main(String[] args) {
		
		// The main strategy is read the XML file and save in the "superclass" and print with a foreach the vector inside the "superclass" 
		try {
			JAXBContext context = JAXBContext.newInstance(Group.class);
			Unmarshaller um = context.createUnmarshaller();
			
			Group grupo = (Group) um.unmarshal(new File(".\\archives","group.xml"));
			// Call the method getter to get the array for objects inside the "superclass"
			for (Patner pat : grupo.getPatners()) {
				System.out.println(pat.toString());
			}
			
		} catch (JAXBException e) {
		
			e.printStackTrace();
		}
	}
}

