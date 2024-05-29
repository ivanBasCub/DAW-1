package highSchool;

import java.io.Serializable;
import java.sql.Date;

public class Alumn implements Comparable<Alumn>,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Attributes
	private int idAlum;
	private String name;
	private Date fnac;
	private float media;
	private String curso;
	
	// Constructors
	public Alumn(int idAlum, String name, Date fnac, float media, String curso) {
		super();
		this.idAlum = idAlum;
		this.name = name;
		this.fnac = fnac;
		this.media = media;
		this.curso = curso;
	}

	public int getIdAlum() {
		return idAlum;
	}

	public void setIdAlum(int idAlum) {
		this.idAlum = idAlum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFnac() {
		return fnac;
	}

	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Alumn [idAlum=" + idAlum + ", name=" + name + ", fnac=" + fnac + ", media=" + media + ", curso=" + curso
				+ "]";
	}

	@Override
	public int compareTo(Alumn o) {
		if(this.idAlum > o.getIdAlum()) {
			return 1;
		}else if(this.idAlum < o.getIdAlum()) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
