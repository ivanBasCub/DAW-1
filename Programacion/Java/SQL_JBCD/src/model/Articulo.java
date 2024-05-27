package model;

public class Articulo {

	private int codArt;
	private String nomArt;
	private double precio;
	private int codFab;
	private String nomFab;
	
	public Articulo(int codArt, String nomArt, double precio, int codFab) {
		setCodArt(codArt);
		setNomArt(nomArt);
		setPrecio(precio);
		this.codFab = codFab;
	}

	public Articulo(int codArt, String nomArt, double precio, String nomFab) {
		setCodArt(codArt);
		setNomArt(nomArt);
		setPrecio(precio);
		setNomFab(nomFab);
	}
	
	public Articulo(int codArt, String nomArt, double precio,int codFab, String nomfab) {
		setCodArt(codArt);
		setNomArt(nomArt);
		setPrecio(precio);
		this.codFab = codFab;
		setNomFab(nomfab);
	}
	
	public Articulo() {
		setCodArt(0);
		setNomArt("");
		setPrecio(0.0);
		this.codFab = 0;
		setNomFab("");
	}
	
	public int getCodArt() {
		return codArt;
	}

	public void setCodArt(int codArt) {
		this.codArt = codArt;
	}

	public String getNomArt() {
		return nomArt;
	}

	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNomFab() {
		return nomFab;
	}

	public void setNomFab(String nomFab) {
		this.nomFab = nomFab;
	}

	public int getCodFab() {
		return codFab;
	}

	public void setCodFab(int codFab) {
		this.codFab = codFab;
	}

	@Override
	public String toString() {
		return "Articulo [codArt=" + codArt + ", nomArt=" + nomArt + ", precio=" + precio + ", codFab=" + codFab
				+ ", nomFab=" + nomFab + "]";
	}

}
