/*
 * Clase Color almacena varias características de un color
 * */

public class Color {
	//Atributos
	private String nombreColor=""; //Almacena el nombre del color
	private short r,g,b=0; //Almacena el numero del color en el formato R,G,B
	

	//CONSTRUCTORES
	public Color() {
		nombreColor="NEGRO";
		r=0;
		g=0;
		b=0;
	}
	
	public Color(short r,short g,short b,String nombreColor) {
		this.nombreColor=nombreColor;
		this.r=r;
		this.g=g;
		this.b=b;
	}
	
	//METODOS QUE CAMBIAN LOS ATRIBUTOS
	public void setRGB(short r,short g,short b){
		this.r=r;
		this.g=g;
		this.b=b;		
	}
	
	public void setNombre(String nombreColor)
	{
		this.nombreColor=nombreColor;
	}
	
	//METODOS QUE DEVUELVEN LOS ATRIBUTOS
	public short getR()
	{
		return this.r;
	}

	public short getG()
	{
		return this.g;
	}

	public short getB()
	{
		return this.b;
	}
	public String getNombre()
	{
		return this.nombreColor;
	}

}
