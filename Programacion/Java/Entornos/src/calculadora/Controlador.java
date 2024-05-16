package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
	Vista ventana;
	
	public Controlador(Vista ventana) {
		super();
		this.ventana = ventana;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(event.getActionCommand());
		String num1Str = ventana.num1Txt.getText();
		String num2Str = ventana.num2Txt.getText();
		
		int num1 = Integer.parseInt(num1Str);
		int num2 = Integer.parseInt(num2Str);
		String accion = event.getActionCommand();
		
		int result = 0;
		switch (accion) {
		case "Sumar":
			result = Modelo.suma(num1, num2);
			break;

		case "Restar":
			result = Modelo.resta(num1, num2);
			break;
		case "Multiplicar":
			result =(int) Modelo.multiplicar(num1, num2);
			break;
		case "Dividir":
			result = (int)Modelo.dividir(num1, num2);
			break;

		}		
		ventana.resultadolbl.setText(String.valueOf(result));
	}
}
