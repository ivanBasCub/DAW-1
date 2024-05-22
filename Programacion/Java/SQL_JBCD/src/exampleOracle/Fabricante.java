package exampleOracle;

public class Fabricante implements Comparable<Fabricante> {

	private String id, name;
	
	public Fabricante(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Fabricante [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Fabricante o) {
		return this.getName().compareTo(o.getName());
	}
	

}
