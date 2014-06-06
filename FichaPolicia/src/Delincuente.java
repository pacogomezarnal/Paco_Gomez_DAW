
public class Delincuente {
	
	private int id;
	private String nombre;
	private int edad;
	private int altura;
	private String crimen;

	public Delincuente() {
		
	}
	//Falta por crear
	//Los métodos de guardado y recuperación
	
	//Falta por crear
	//El método toString para que aparezca en el comboBox
	public String toString(){
		return this.nombre;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setCrimen(String crimen){
		this.crimen=crimen;
	}

	public void setEdad(int edad){
		this.edad=edad;
	}
	
	public void setAltura(int altura){
		this.altura=altura;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getCrimen(){
		return crimen;
	}
	
	public int getEdad(){
		return edad;
	}
	public int getAltura(){
		return altura;
	}
}
