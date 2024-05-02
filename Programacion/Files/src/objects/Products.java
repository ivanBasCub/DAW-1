package objects;

import java.io.Serializable;

// PARA PODER GUARDAR OBJEOS EN UN ARCHIVO NECESITAMOS IMPLEMENTAR SERIALIZABLE
public class Products implements Serializable{
	//ES PARA INDICAR QUE LA VERSION DE LA CLASE OBJETO PARA QUE PUEDA FUNCIONAR TANTO EN LA ESCRITURA, LECTURA, CREACION DE UN OBJETO
	private static final long serialVersionUID = 2L;
	
	private double price;
	private int units;
	private String description;
	
	
	public Products(String descrip, int unit, double price) {
		setUnits(unit);
		setPrice(price);
		setDescription(descrip);
	}
	
	public double getTotal() {
		return price*units;
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

	@Override
	public String toString() {
		return "Products [price=" + price + ", units=" + units + ", description=" + description + "]";
	}
	
	
	
}
