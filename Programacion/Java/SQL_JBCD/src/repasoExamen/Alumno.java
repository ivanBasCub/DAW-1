package repasoExamen;

import java.io.Serializable;
import java.sql.Date;

public class Alumno implements Comparable<Alumno>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributos de la clase
	private int id;
	private String nombre;
	private Date fecNac;
	private float media;
	private String curso;
	
	// Constructores
	public Alumno(int id, String nombre, Date fecNac, float media, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecNac = fecNac;
		this.media = media;
		this.curso = curso;
	}

	// Metodos Get y Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecNac() {
		return fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
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
	
	// Impresion por pantalla
	@Override
	public String toString() {
		return "Alumnos [id=" + id + ", nombre=" + nombre + ", fecNac=" + fecNac + ", media=" + media + ", curso="
				+ curso + "]";
	}

	@Override
	public int compareTo(Alumno o) {
		if(this.id > o.getId()) {
			return 1;
		}else if(this.id < o.getId()) {
			return -1;
		}else {
			return 0;
		}
	}
	
	
	
}
