package exer1Class;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Line")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineOrder implements Serializable, Comparable,Comparator<LineOrder>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double price;
	private int units;
	@XmlAttribute(name="des")
	private String description;
	
	
	
	public LineOrder() {
		super();
	
	}

	public LineOrder(String description, int units, double price ) {
		super();
		setPrice(price);
		setUnits(units);
		setDescription(description);
	}
	
	@Override
	public String toString() {
		return "LineOrder [price=" + price + ", units=" + units + ", description=" + description + "]";
	}
	
	public double getTotal() {
		return units*price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	// Method to Compare To
	@Override
	public int compareTo(Object otter) {
		if(this.price == ((LineOrder) otter).getPrice()) {
			return 0;
		}
		else if(this.price < ((LineOrder) otter).getPrice()) {
			return -1;
		}
		else {
			return 1;
		}
		
		// return (int) (this.price - ((LineOrder) otter).getPrice());
	}

	@Override
	public int compare(LineOrder o1, LineOrder o2) {
		double total1 = o1.getTotal();
		double total2 = o2.getTotal();
		
		if(total1 < total2) {
			return -1;
		}else if(total1 > total2) {
			return 1;
		}else {
			return 0;
		}
	}
	
	
}
