package hashMap;

public class Academico {

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
}
