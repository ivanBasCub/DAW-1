package practica1;

public class Articulo {

	private int  price;
	private String id, name, codfab;
	
	public Articulo(String id, String name, int price, String codfab) {
		super();
		setId(id);
		setCodfab(codfab);
		setName(name);
		setPrice(price);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodfab() {
		return codfab;
	}

	public void setCodfab(String codfab) {
		this.codfab = codfab;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Articulo [price=" + price + ", id=" + id + ", name=" + name + ", codfab=" + codfab + "]";
	}

}
