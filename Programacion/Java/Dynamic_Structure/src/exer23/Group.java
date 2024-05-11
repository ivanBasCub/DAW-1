package exer23;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

// create this class to save the array of objects inside and save in a XML file

@XmlRootElement(name="group")
@XmlAccessorType(XmlAccessType.FIELD)
public class Group{
	
	private Patner[] patners;
	
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Group(Patner[] patners) {
		super();
		this.patners = patners;
	}

	public Patner[] getPatners() {
		return patners;
	}

	public void setPatners(Patner[] patners) {
		this.patners = patners;
	}
}
