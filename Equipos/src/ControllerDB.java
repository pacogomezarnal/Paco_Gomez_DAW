import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JComboBox;


public class ControllerDB {
	//DB
	Connection conexion = null; //maneja la conexión
	
	public ControllerDB() {
		//Nos conectamos a la base de datos
		crearConexion();
	}
	
	private void crearConexion(){
		//Conectarnos a la base de datos
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","");
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}// fin de catch			
	}
	
	//En este método leeremos de la base de datos los equipos existentes
	// 1.- Leer de la base de datos
	// 2.- Actualizar el combobox
	public void leerEquipos(JComboBox listadoEquipos){
		//Aquí realizaremos la consulta y actualización del combobox
	}
	
	//En este método leeremos de la base de datos los equipos existentes
	// 1.- Crearemos la consulta a la base de datos (Statement)
	// 2.- Lanzaremos la consulta
	// 3.- Eliminaremos todos los elementos del combobox
	// 4.- Volveremos a rellenar el combobox
	public void insertarEquipos(int idLiga,String nombreEquipo,int golesFavor,int golesContra, int partidosGanados,int partidosPerdidos,JComboBox listadoEquipos){
		//Aquí realizaremos la consulta
		
		//Actualización del combobox
		listadoEquipos.removeAllItems();
		leerEquipos(listadoEquipos);
	}
}
