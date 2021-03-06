import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class EjercicioDBINSERT {

	public static void main(String[] args) {
		Connection conexion = null; //maneja la conexi�n
		Statement instruccion = null;// instrucci�n de consulta
		ResultSet conjuntoResultados = null;// maneja los resultados
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexi�n a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","");
			// crea objeto Statement para consultar la base de datos
			instruccion = (Statement) conexion.createStatement();
			// insercion en base de datos
			instruccion.executeUpdate("INSERT INTO liga ( Nombre ) VALUES( 'Liga Alemana')");
			//Compruebo la insercion
			conjuntoResultados = instruccion.executeQuery("SELECT idLiga,Nombre FROM liga");
			//Mostrar por pantalla
			while (conjuntoResultados.next())
			{
			   System.out.println("id="+conjuntoResultados.getObject("idLiga")+
			      ", Nombre="+conjuntoResultados.getObject("Nombre"));
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

}
