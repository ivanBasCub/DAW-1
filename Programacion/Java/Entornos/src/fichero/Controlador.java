package fichero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{

	Vista ventana;
	Palabras mod;
	
	public Controlador(Vista ventana, Palabras mod) {
		super();
		this.ventana = ventana;
		this.mod = mod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String result = mod.aleatorio();
		ventana.resultadolbl.setText(result);	
	}

	
}


