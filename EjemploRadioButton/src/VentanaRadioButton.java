import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaRadioButton extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ButtonGroup grupoDeBotones;
	private JRadioButton opcion1;
	private JRadioButton opcion2;
	private JRadioButton opcion3;
	
	//Base de datos
	BD bd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRadioButton frame = new VentanaRadioButton();
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
	public VentanaRadioButton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPregunta = new JLabel("Pregunta");
		lblPregunta.setBounds(10, 55, 46, 14);
		contentPane.add(lblPregunta);
		
		textField = new JTextField();
		textField.setBounds(79, 52, 334, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		grupoDeBotones = new ButtonGroup();

		
		opcion1 = new JRadioButton("Opcion 1");
		opcion1.setSelected(true);
		opcion1.setBounds(6, 103, 109, 23);
		contentPane.add(opcion1);
		
		opcion2 = new JRadioButton("Opcion 2");
		opcion2.setBounds(6, 140, 109, 23);
		contentPane.add(opcion2);
		
		opcion3 = new JRadioButton("Opcion 3");
		opcion3.setBounds(6, 180, 109, 23);
		contentPane.add(opcion3);
		
		//Añadimos los botones a un grupo de botones
		grupoDeBotones.add(opcion1);
		grupoDeBotones.add(opcion2);
		grupoDeBotones.add(opcion3);
		
		JButton Guardar = new JButton("Guardar");
		Guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String opcion="";
				if(opcion1.isSelected()) 
					opcion="opcion1";
				else if(opcion2.isSelected())
					opcion="opcion2";
				else
					opcion="opcion3";
				bd.insertarPregunta(textField.getText(), opcion);
			}
		});
		Guardar.setBounds(10, 228, 89, 23);
		contentPane.add(Guardar);
		
		bd=new BD();
	}
}
