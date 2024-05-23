package calculadora;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField num1Txt;
	public JTextField num2Txt;
	public JLabel resultadolbl;
	private static Controlador control;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					//control = new Controlador(frame);
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
	public Vista() {
		control = new Controlador(this);
		
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel PanelBotones = new JPanel();
		contentPane.add(PanelBotones, BorderLayout.SOUTH);
		
		JButton sumarBtn = new JButton("Sumar");
		
		PanelBotones.add(sumarBtn);
		
		JButton restarBtn = new JButton("Restar");
		
		PanelBotones.add(restarBtn);
		
		JButton multiplicabtn = new JButton("Multiplicar");
		PanelBotones.add(multiplicabtn);
		
		JButton dividirBtn = new JButton("Dividir");
		PanelBotones.add(dividirBtn);
		
		
		JPanel panelPedir = new JPanel();
		contentPane.add(panelPedir, BorderLayout.NORTH);
		
		num1Txt = new JTextField();
		panelPedir.add(num1Txt);
		num1Txt.setColumns(10);
		
		num2Txt = new JTextField();
		panelPedir.add(num2Txt);
		num2Txt.setColumns(10);
		
		JPanel panelResultado = new JPanel();
		contentPane.add(panelResultado, BorderLayout.CENTER);
		
		resultadolbl = new JLabel("Resultado");
		panelResultado.add(resultadolbl);
		
		sumarBtn.addActionListener(control);
		restarBtn.addActionListener(control);
		multiplicabtn.addActionListener(control);
		dividirBtn.addActionListener(control);
	}

}
