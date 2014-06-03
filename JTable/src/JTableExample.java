import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class JTableExample extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel dtmEjemplo;
	private JTable table;
	private JScrollPane scpEjemplo;

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
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//JTABLE
        //1.- Definimos el modelo de JTable, en nuestro caso DefaultModel
		//2.- Definimos los títulos de las columnas
		//3.- REllenamos las filas a partir de la consulta a la base de datos
		//3.- Creamos el JTable y le asignamosel modelo rellenado
		//4,. Ponemos el JTable dentro de un JScrollPane para poder hacer scroll
		//5.- Damos visivilidad al JTable con setViewportView
        dtmEjemplo = new DefaultTableModel(null,rellenarTitColumnas());
        
		//CONEXION A BASE DE DATOS
		conexionDB();       
		
        table = new JTable();
		table.setModel(dtmEjemplo);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 414, 241);
		scrollPane.add(table);
		//REvisar la documentación para ver que significa el JScrollPane
		//http://docs.oracle.com/javase/7/docs/api/javax/swing/JScrollPane.html
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		

	}
	
    //Encabezados de la tabla
    private String[] rellenarTitColumnas()
    {
          String columna[]=new String[]{"idLiga","nombre","numEquipos"};
          return columna;
    }
	
	private void conexionDB() {
		Connection conexion = null; //maneja la conexión
		Statement instruccion = null;// instrucción de consulta
		ResultSet conjuntoResultados = null;// maneja los resultados
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","");
			// crea objeto Statement para consultar la base de datos
			instruccion = (Statement) conexion.createStatement();
			// consulta la base de datos
			conjuntoResultados = instruccion.executeQuery("SELECT idLiga,nombre,numEquipos FROM ligas");
			//Añadir datos al modelo
	        Object datos[]=new Object[3]; //Numero de columnas de la tabla
	        while (conjuntoResultados.next()) {
	        	for (int i = 0; i < 3; i++) {
	            	datos[i] = conjuntoResultados.getObject(i + 1);
	            }
	        	dtmEjemplo.addRow(datos);
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
