package examples2;

public class Products {

	private double price;
	private int units;
	private String description;
	
	public Products(int unit, double price, String descrip) {
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
