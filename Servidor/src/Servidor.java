import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor implements Runnable{
	private ServerSocket servidor; // socket servidor
	private Socket conexion;// conexión al cliente
	private int contador = 1;// contador del número de conexiones
	
	public Servidor(){
	
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
					esperarConexion();// espera una conexión
				}// fin de try
				catch( EOFException excepcionEOF ){
					System.out.println("\nServidor termino la conexion");
				}// fin de catch
				finally
				{
					cerrarConexion();// cierra la conexión
					contador++;
				}// fin de finally
			}// fin de while
		}// fin de try
		catch( IOException exepcionES ) 
		{
			exepcionES.printStackTrace();
		}// fin de catch
	}// fin del método ejecutarServidor
	
	private void esperarConexion() throws IOException{
		System.out.println("Esperando una conexion\n" );
		conexion = servidor.accept(); // permite al servidor aceptar la conexión
		System.out.println("Conexion "+ contador +" recibida de: "+
		conexion.getInetAddress().getHostName() );
	}// fin del método esperarConexion
	
	private void cerrarConexion() {
		System.out.println("\nTerminando conexion\n" );
		try{
			conexion.close();// cierra el socket
		}// fin de try
		catch( IOException exepcionES ) 
		{
			exepcionES.printStackTrace();
		}// fin de catch
	}// fin del método cerrarConexion

}
