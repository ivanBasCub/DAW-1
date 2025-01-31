package hashMap;

import java.io.Serializable;

public class Academico implements Comparable,Serializable{
	
	// ATRIBUTOS DE LA CLASE Y EL SERIAL DE LA CLASE
	private static final long serialVersionUID = 1L;
	private String name;
	private int aIngreso;
	
	// CONSTRUCTORES DE LA CLASE
	public Academico() {
		super();

	}
	
	public Academico(String name, int aIngreso) {
		super();
		setName(name);
		setaIngreso(aIngreso);
	}
	
	// SETTERS Y GETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getaIngreso() {
		return aIngreso;
	}
	public void setaIngreso(int aIngreso) {
		this.aIngreso = aIngreso;
	}
	
	// METODO TOSTRING
	@Override
	public String toString() {
		return "Academico [name=" + name + ", aIngreso=" + aIngreso + "]";
	}
	
	// METODO COMPARETO
	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
