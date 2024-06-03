package mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField codArtText;
	private JLabel nombre = new JLabel("");
	private JLabel precio = new JLabel("");
	private JLabel fabricante = new JLabel("");
	private Controlador control = new Controlador(this);
	
	/**
	 * Create the frame.
	 */
	public Vista() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel introData = new JPanel();
		contentPane.add(introData, BorderLayout.NORTH);
		
		JLabel codLabel = new JLabel("Codigo Articulo: ");
		codLabel.setHorizontalAlignment(SwingConstants.LEFT);
		introData.add(codLabel);
		
		codArtText = new JTextField();
		codArtText.setHorizontalAlignment(SwingConstants.LEFT);
		introData.add(codArtText);
		codArtText.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.mostrarResultado();
			}
		});
		introData.add(btnBuscar);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel etiqNombre = new JLabel("Nombre: ");
		panel.add(etiqNombre);
		
		panel.add(nombre);
		
		JLabel etqPrecio = new JLabel("Precio: ");
		panel.add(etqPrecio);
		
		panel.add(precio);
		
		JLabel etqFab = new JLabel("Nombre Fabricante: ");
		panel.add(etqFab);
		
		panel.add(fabricante);
		
	}
	
	
	// Metodos para introducir y sacar los datos de la vista
	public String getCodArtText () {
		return codArtText.getText();
	}
	
	public void setNombre(String value) {
		this.nombre.setText(value);
	}
	
	public void setPrecio(String value) {
		this.precio.setText(value);
	}
	
	public void setFabricante(String value) {
		this.fabricante.setText(value);
	}
}
