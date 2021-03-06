import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextField;


public class Servidor implements Runnable{
	private ServerSocket servidor; // socket servidor
	private Socket conexion;// conexi�n al cliente
	private int contador = 1;// contador del n�mero de conexiones
	private ObjectOutputStream salida;// flujo de salida hacia el cliente
	private ObjectInputStream entrada; // flujo de entrada del cliente
	private JTextField cliente;

	
	public Servidor(JTextField cliente){
		this.cliente=cliente;
	}
	
	public void run()
	{
			ejecutarServidor();
	}
	public void ejecutarServidor(){
		try// establece el servidor para que reciba conexiones; procesa las conexiones
		{
			servidor = new ServerSocket(12345,100); // crea objeto ServerSocket
			while(true) 
			{
				try{
					esperarConexion();// espera una conexi�n
					obtenerFlujos();// obtiene los flujos de entrada y salida
					procesarConexion();
				}// fin de try
				catch( EOFException excepcionEOF ){
					System.out.println("\nServidor termino la conexion");
				}// fin de catch
				finally
				{
					cerrarConexion();// cierra la conexi�n
					contador++;
				}// fin de finally
			}// fin de while
		}// fin de try
		catch( IOException exepcionES ) 
		{
			exepcionES.printStackTrace();
		}// fin de catch
	}// fin del m�todo ejecutarServidor
	
	private void esperarConexion() throws IOException{
		System.out.println("Esperando una conexion\n" );
		conexion = servidor.accept(); // permite al servidor aceptar la conexi�n
		System.out.println("Conexion "+ contador +" recibida de: "+
		conexion.getInetAddress().getHostName() );
	}// fin del m�todo esperarConexion
	
	// obtiene flujos para enviar y recibir datos
	private void obtenerFlujos() throws IOException{
		// establece el flujo de salida para los objetos
		salida = new ObjectOutputStream( conexion.getOutputStream() );
		salida.flush();// vac�a el b�fer de salida para enviar informaci�n del encabezado

		// establece el flujo de entrada para los objetos
		entrada = new ObjectInputStream( conexion.getInputStream() );

		System.out.println("\nSe obtuvieron los flujos de E/S\n");
	}// fin del m�todo obtenerFlujos
	
	// procesa la conexi�n con el cliente
	private void procesarConexion() throws IOException
	{
		String mensaje = "Conexion exitosa";
		enviarDatos( mensaje );// env�a mensaje de conexi�n exitosa
		// habilita campoIntroducir para que el usuario del servidor pueda enviar mensajes
		do// procesa los mensajes enviados desde el cliente
			{
				try// lee el mensaje y lo muestra en pantalla
				{
					mensaje = ( String ) entrada.readObject(); // lee el nuevo mensaje
					this.cliente.setText("\n"+ mensaje); // muestra el mensaje
				}// fin de try
				catch( ClassNotFoundException excepcionClaseNoEncontrada ) 
				{
					System.out.println("\nSe recibio un tipo de objeto desconocido");
				}// fin de catch

		}while( !mensaje.equals( "CLIENTE>>> TERMINAR") );
	}// fin del m�todo procesarConexion

	private void enviarDatos( String mensaje )
	{
		try// env�a objeto al cliente
		{
			salida.writeObject("SERVIDOR>>> "+ mensaje );
			salida.flush();// env�a toda la salida al cliente
			System.out.println("\nSERVIDOR>>> "+ mensaje );
		}// fin de try
		catch( IOException exepcionES ) {
			System.out.println("\nError al escribir objeto");
		}// fin de catch
	}// fin del m�todo enviarDatos
	
	private void cerrarConexion() {
		System.out.println("\nTerminando conexion\n" );
		try{
			conexion.close();// cierra el socket
		}// fin de try
		catch( IOException exepcionES ) 
		{
			exepcionES.printStackTrace();
		}// fin de catch
	}// fin del m�todo cerrarConexion

}
