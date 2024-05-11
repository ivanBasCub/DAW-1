package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField date;
	private JTextField id;
	private JPanel datos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba frame = new VentanaPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrueba() {

		Color negro = new Color(0,0,0);
		LineBorder linea = new LineBorder(negro,3);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		datos = new JPanel();
		datos.setBackground(new Color(255, 128, 0));
		textName = new JTextField();
		textName.setBounds(93, 9, 86, 20);
		
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(datos, BorderLayout.CENTER);
		datos.setLayout(null);
		JLabel LabelNombre = new JLabel("Nombre:");
		LabelNombre.setBounds(8, 8, 54, 20);
		datos.add(LabelNombre);
		
		LabelNombre.setVerticalAlignment(SwingConstants.TOP);
		LabelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		LabelNombre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		datos.add(textName);
		
		JLabel lblNewLabel = new JLabel("Identificador");
		lblNewLabel.setBounds(8, 55, 78, 14);
		datos.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(93, 52, 86, 20);
		datos.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setBounds(8, 129, 46, 14);
		datos.add(lblNewLabel_1);
		
		date = new JTextField();
		date.setBounds(65, 126, 86, 20);
		datos.add(date);
		date.setColumns(10);
		
		
		
		datos.setBorder(linea);
		
		
		
		textName.setColumns(10);
		
		JLabel north = new JLabel("Norte");
		contentPane.add(north, BorderLayout.NORTH);
		
		JLabel Este = new JLabel("Este");
		contentPane.add(Este, BorderLayout.EAST);
		
		JLabel Oeste = new JLabel("Oeste");
		contentPane.add(Oeste, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("cambiar ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTexto();
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}
	
	public void cambiarTexto() {
		textName.setText("Ivan");
		
	}
}
