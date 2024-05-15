package pr1estrdinamicas_IvanBascones;

import java.io.Serializable;

public class Academico implements Comparable<Academico>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int aIngreso;
	
	public Academico(String name, int aIngreso) {
		super();
		this.name = name;
		this.aIngreso = aIngreso;
	}
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
	
	@Override
	public String toString() {
		return "Academico [name=" + name + ", aIngreso=" + aIngreso + "]";
	}
	
	@Override
	public int compareTo(Academico o) {
		String aux=this.name;
		return aux.compareToIgnoreCase(o.getName());
	}
}
