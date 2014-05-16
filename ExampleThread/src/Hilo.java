import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class Hilo implements Runnable {
	
	private final int tiempoInactividad; // tiempo de inactsubproceso
	private final String nombreTarea;// nombre de la tarea
	private final static Random generador = new Random();
	
	private JTextField eventos;
	private JLabel contar;
	private volatile boolean isRunning = true;
	private int contarNum=0;
	
	public Hilo(String nombre,JTextField eventos,JLabel contar)  {
		nombreTarea = nombre; // establece el nombre de la tarea
		this.eventos=eventos;
		this.contar=contar;
		// elige un tiempo de inactividad aleatorio entre 0 y 5 segundos
		tiempoInactividad = generador.nextInt(5000);// milisegundos
	}
	
	public void run()
	{
		try// deja el subproceso inactivo durante tiempoInactividad segundos 
		{
			
			this.eventos.setText("COMIENZO");
			while(isRunning)
			{
				//System.out.printf("%s va a estar inactivo durante %d milisegundos.\n",nombreTarea, tiempoInactividad );
				contarNum++;
				contar.setText(String.valueOf(contarNum));
				Thread.sleep( 1000); // deja el subproceso inactivo
			}
		}// fin de try
		catch( InterruptedException excepcion )
		{
			System.out.println(excepcion);
			isRunning = false;
		    this.eventos.setText("PARADO");
			System.out.printf("%s %s\n", nombreTarea,"termino en forma prematura, debido a la interrupcion");
		}// fin de catch
 
		// imprime el nombre de la tarea
		System.out.printf("%s termino su inactividad\n", nombreTarea ); 
	}// fin del método run
	
	 public void kill() {
	       isRunning = false;
	       this.eventos.setText("PARADO");
	 }
}
