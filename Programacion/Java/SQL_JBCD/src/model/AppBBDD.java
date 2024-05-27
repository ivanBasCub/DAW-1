package model;

public class AppBBDD {

	public static void main(String[] args) {
		Articulo art1 = ArticuloDAO.readFab("0000000004");		
		System.out.println(art1.toString());
		
	}
}
