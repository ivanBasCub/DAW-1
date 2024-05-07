package exer1Class;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Lineas")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lines {
	
	private LineOrder[] lines;

	public Lines() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Lines(LineOrder[] lines) {
		super();
		this.lines = lines;
	}

	public LineOrder[] getLines() {
		return lines;
	}

	public void setLines(LineOrder[] lines) {
		this.lines = lines;
	}


}
