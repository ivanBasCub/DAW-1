package exer1Class;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Line")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	double price;
	int units;
	@XmlAttribute(name="des")
	String description;
	
	
	
	public LineOrder() {
		super();
	
	}

	public LineOrder(String description, int units, double price ) {
		super();
		this.price = price;
		this.units = units;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "LineOrder [price=" + price + ", units=" + units + ", description=" + description + "]";
	}
	
	public double getTotal() {
		return units*price;
	}
	
	
}
