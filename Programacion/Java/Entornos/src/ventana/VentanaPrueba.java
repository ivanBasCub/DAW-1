package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class VentanaPrueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelNombre = new JLabel("Nombre:");
		LabelNombre.setBounds(113, 10, 116, 37);
		LabelNombre.setVerticalAlignment(SwingConstants.TOP);
		LabelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		LabelNombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(LabelNombre);
		
		textField = new JTextField();
		textField.setBounds(234, 18, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
