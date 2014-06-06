import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.mysql.jdbc.Statement;


public class DB {
	private Connection conexion = null; //maneja la conexión
	private Statement instruccion = null;// instrucción de consulta
	private ResultSet conjuntoResultados = null;// maneja los resultados	
	
	public DB(JComboBox<Delincuente> delincuentes){

		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/delincuentes","root","tonphp");
			// crea objeto Statement para consultar la base de datos
			instruccion = (Statement) conexion.createStatement();
			// consulta la base de datos
			conjuntoResultados = instruccion.executeQuery("SELECT * FROM delincuente");
			//Mostrar por pantalla
			while (conjuntoResultados.next())
			{
				Delincuente d=new Delincuente();
				d.setId((int)conjuntoResultados.getObject("id"));
				d.setNombre((String)conjuntoResultados.getObject("nombre"));
				d.setEdad((int)conjuntoResultados.getObject("edad"));
				d.setAltura((int)conjuntoResultados.getObject("altura"));
				d.setCrimen((String)conjuntoResultados.getObject("crimen"));
				delincuentes.addItem(d);
			}
			conjuntoResultados.close();
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}// fin de catch
	}
	
	public void insertarDelincuente(Delincuente d){
		try{
			// crea objeto Statement para consultar la base de datos
			instruccion = (Statement) conexion.createStatement();
			// insercion en base de datos
			/*
				UPDATE  `delincuentes`.`delincuente` SET  `nombre` =  'Paco2' WHERE  `delincuente`.`id` =1;
			*/
			String sqlFijo="INSERT INTO  `delincuentes`.`delincuente` (`nombre` ,`edad` ,`altura` ,`crimen`)VALUES (";
			String sqlVariable=d.getNombre()+d.getEdad()+d.getAltura()+d.getCrimen()+")";
			instruccion.executeUpdate(sqlFijo+sqlVariable);
			conjuntoResultados.close();
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch	
	}

}
