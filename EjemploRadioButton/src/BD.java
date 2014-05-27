import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.mysql.jdbc.Statement;


public class BD {
	Connection conexion = null; //maneja la conexión
	Statement instruccion = null;// instrucción de consulta
	ResultSet conjuntoResultados = null;// maneja los resultados
	
	public BD() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/preguntas","root","");
			// crea objeto Statement para consultar la base de datos
			instruccion = (Statement) conexion.createStatement();
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}// fin de catch
	}
	
	public void insertarPregunta(String pregunta,String opcion){
		try{
			instruccion = (Statement) conexion.createStatement();
			// consulta la base de datos
			instruccion.executeUpdate("INSERT INTO preguntas ( Pregunta,Opcion ) VALUES( '"+pregunta+"','"+opcion+")");
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch	
	}

}
