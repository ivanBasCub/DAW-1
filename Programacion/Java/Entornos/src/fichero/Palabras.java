package fichero;

public class Palabras {

	String[] palabras = {"pollo","pallo","mocos","tomos"};
	
	public String aleatorio() {
		int i = (int) (Math.random() * (palabras.length - 1));
		return palabras[i];
	}
}
