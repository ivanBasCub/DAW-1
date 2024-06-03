package mvc;

public class Modelo {
	
	private String name = null;
	private String nomFab = null;
	private double price;
	
	
	// Constructor
	public Modelo(String name, String nomFab, double price) {
		super();
		setName(name);
		setNomFab(nomFab);
		setPrice(price);
	}
	
	// Getters y Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNomFab() {
		return nomFab;
	}

	public void setNomFab(String nomFab) {
		this.nomFab = nomFab;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
