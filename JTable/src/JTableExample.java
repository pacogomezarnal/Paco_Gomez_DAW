import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class JTableExample extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel dtmEjemplo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableExample frame = new JTableExample();
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
	public JTableExample() {
		
		//PARTE GRÁFICA SWING
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//JTABLE
        //Llenamos el modelo
        dtmEjemplo = new DefaultTableModel(null,rellenarColumnas());
		
		//CONEXION A BASE DE DATOS
		conexionDB();
	}
	
    //Encabezados de la tabla
    private String[] rellenarColumnas()
    {
          String columna[]=new String[]{"idLiga","Nombre"};
          return columna;
    }
	
	private void conexionDB() {
		Connection conexion = null; //maneja la conexión
		Statement instruccion = null;// instrucción de consulta
		ResultSet conjuntoResultados = null;// maneja los resultados
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","tonphp");
			// crea objeto Statement para consultar la base de datos
			instruccion = (Statement) conexion.createStatement();
			// consulta la base de datos
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
