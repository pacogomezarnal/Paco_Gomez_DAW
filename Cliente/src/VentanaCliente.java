import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaCliente extends JFrame {

	private JPanel contentPane;
	private Cliente c;
	private JTextField estado;
	private JLabel lblMensajeServidor;
	private JTextField servidor;
	private JLabel lblMensaje;
	private JTextField mensaje;
	private JButton btnEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCliente frame = new VentanaCliente();
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
	public VentanaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estado");
		lblNewLabel.setBounds(10, 21, 46, 14);
		contentPane.add(lblNewLabel);
		
		estado = new JTextField();
		estado.setBounds(10, 46, 414, 20);
		contentPane.add(estado);
		estado.setColumns(10);
		estado.setText("APAGADO");
		
		JButton btnNewButton = new JButton("Conectar");
		btnNewButton.setBounds(10, 89, 89, 23);
		contentPane.add(btnNewButton);
		
		lblMensajeServidor = new JLabel("Mensaje Servidor");
		lblMensajeServidor.setBounds(10, 130, 145, 14);
		contentPane.add(lblMensajeServidor);
		
		servidor = new JTextField();
		servidor.setEditable(false);
		servidor.setColumns(10);
		servidor.setBounds(10, 155, 414, 20);
		contentPane.add(servidor);
		
		lblMensaje = new JLabel("Mensaje");
		lblMensaje.setBounds(10, 189, 46, 14);
		contentPane.add(lblMensaje);
		
		mensaje = new JTextField();
		mensaje.setColumns(10);
		mensaje.setBounds(10, 214, 414, 20);
		contentPane.add(mensaje);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                JButton btnEnviar=(JButton)arg0.getSource();
                VentanaCliente v=(VentanaCliente)SwingUtilities.getRoot(btnEnviar);
                v.c.enviarDatos(v.mensaje.getText());
			}
		});
		btnEnviar.setBounds(10, 239, 89, 23);
		contentPane.add(btnEnviar);
		
		//Creamos cliente
		c=new Cliente("localhost");
		try{
			c.conectarAlServidor();
		}catch(IOException exception){
			System.out.println(exception);
		}
	}
}
