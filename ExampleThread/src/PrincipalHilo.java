
public class PrincipalHilo {

	public static void main(String[] args) {
		System.out.println("Creacion de subprocesos");
		
		// crea cada subproceso con un nuevo objeto Runnable
		//Thread subproceso1 = new Thread( new Hilo( "tarea1") );
		//Thread subproceso2 = new Thread( new Hilo( "tarea2") );
		//Thread subproceso3 = new Thread( new Hilo( "tarea3") );

		// inicia los subprocesos y los coloca en el estado "en eje
		//subproceso1.start();// invoca al método run de tarea1
		//subproceso2.start();// invoca al método run de tarea2
		//subproceso3.start();// invoca al método run de tarea3
		System.out.println("Tareas iniciadas, main termina.\n");
		
		//Ejecutar a traves de administrador de hilos
		/*
		 * // crea objeto ExecutorService para administrar los subprocesos
			ExecutorService ejecutorSubprocesos = Executors.newCachedThreadPool();
			// inicia los subprocesos y los coloca en el estado ejecutable
			ejecutorSubprocesos.execute( subproceso1 ); // inicia tarea1
			ejecutorSubprocesos.execute( subproceso2 ); // inicia tarea2
			ejecutorSubprocesos.execute( subproceso3 ); // inicia tarea3
			
			// cierra los subprocesos trabajadores cuando terminan sus tareas
			ejecutorSubprocesos.shutdown();
		 */
		 
	}

}
