package exer23;

import javax.xml.bind.annotation.*; // NO ES LA MEJOR FORMA DE HACER LAS COSAS

@XmlRootElement (name = "Patner")
@XmlAccessorType(XmlAccessType.FIELD)

public class Patner{
	@XmlAttribute(name="id")
	private int identificator;
	@XmlElement(name = "Nombre")
	private String Name;
	private String Date;
	
	
	// ES NECESARIO PARA EL JAXB PARA FUNCIONAR
	public Patner() {
		super();
	
	}

	public Patner(int identificator, String name, String date) {
		super();
		setIdentificator(identificator);
		setName(name);
		setDate(date);
	}

	public int getIdentificator() {
		return identificator;
	}
	
	public void setIdentificator(int identificator) {
		this.identificator = identificator;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getDate() {
		return Date;
	}
	
	public void setDate(String date) {
		Date = date;
	}
	
	@Override
	public String toString() {
		return "Patner [identificator=" + identificator + ", Name=" + Name + ", Date=" + Date + "]";
	}
	
	
}
