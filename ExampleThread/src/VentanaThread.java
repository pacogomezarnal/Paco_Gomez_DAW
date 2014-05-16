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


public class VentanaThread extends JFrame {

	private JPanel contentPane;
	private JTextField eventos;
	
	Hilo h1;
	Thread hilo1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaThread frame = new VentanaThread();
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
	public VentanaThread() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setBounds(21, 28, 46, 14);
		contentPane.add(lblNewLabel);
		
		eventos = new JTextField();
		eventos.setBounds(21, 87, 243, 20);
		contentPane.add(eventos);
		eventos.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Eventos");
		lblNewLabel_1.setBounds(21, 62, 139, 14);
		contentPane.add(lblNewLabel_1);
		
		h1=new Hilo("proceso1",eventos,lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Parar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hilo1.interrupt();
			}
		});
		btnNewButton_1.setBounds(24, 131, 91, 23);
		contentPane.add(btnNewButton_1);
		lanzarHilo();
	}
	public void lanzarHilo() {
		hilo1 = new Thread( h1);
		hilo1.start();
	}
}
