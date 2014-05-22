import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaServidor extends JFrame {

	private JPanel contentPane;
	private Servidor s;
	private Thread servidorDemonio;
	private JTextField estado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaServidor frame = new VentanaServidor();
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
	public VentanaServidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estado Servidor");
		lblNewLabel.setBounds(10, 11, 90, 14);
		contentPane.add(lblNewLabel);
		
		estado = new JTextField();
		estado.setBounds(10, 36, 391, 20);
		contentPane.add(estado);
		estado.setColumns(10);
		
		estado.setText("PARADO");
		
		JButton btnNewButton = new JButton("Arrancar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				servidorDemonio = new Thread(s);
				servidorDemonio.start();
				estado.setText("ARRANCADO");
			}
		});
		btnNewButton.setBounds(10, 68, 89, 23);
		contentPane.add(btnNewButton);

		//CReamos Servidor
		s=new Servidor();
	}
}
