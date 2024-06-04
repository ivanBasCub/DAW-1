package mvc;

public class Controlador {

	private Vista ventana;
	private Conexion conect = new Conexion("c##bdarticulos", "bdarticulos", "10.1.2.167");
	
	// Constructor
	public Controlador(Vista ventana){
		this.ventana = ventana;
	}
	
	/*
	 * Coger el codigo que da el usuario 
	 * Recoger la informacion de la BBDD
	 * Mostrar la informacion en la vista 
	 */

	public void mostrarResultado() {
		String codArt = ventana.getCodArtText();
		Modelo aux = conect.searchData(codArt);
		
		if(aux != null) {
			ventana.setNombre(aux.getName());
			ventana.setFabricante(aux.getNomFab());
			ventana.setPrecio(Double.toString(aux.getPrice()));
		}else {
			ventana.setNombre("");
			ventana.setFabricante("");
			ventana.setPrecio("");
		}
	}

}
