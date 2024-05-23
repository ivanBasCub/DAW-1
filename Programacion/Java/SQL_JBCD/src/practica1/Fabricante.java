package practica1;

public class Fabricante {

	private String id;
	private String name;
	
	public Fabricante(String id, String name) {
		super();
		setId(id);
		setName(name);
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
	
}
