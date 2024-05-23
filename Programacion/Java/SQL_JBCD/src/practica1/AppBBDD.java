package practica1;

public class AppBBDD {

	public static void main(String[] args) {
		Articulo art1 = ArticuloDAW.read("0000000003");
		Fabricante fab1 = null;
		
		System.out.println(art1.toString());
		
	}
}
