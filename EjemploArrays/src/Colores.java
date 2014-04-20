
public class Colores {


	public static void main(String[] args) {
		Color blanco=new Color((short)255,(short)255,(short)255,"Blanco");
		Color unArrayDeColores[]=new Color[3];
		Color unColor;
		
		//Inicializamos el array
		unArrayDeColores[0]=new Color((short)255,(short)0,(short)0,"Rojo");
		unArrayDeColores[1]=new Color((short)0,(short)255,(short)0,"Verde");
		unArrayDeColores[2]=new Color((short)0,(short)0,(short)155,"Azul");
		
		//IMPRIMIMOS UN COLOR
		System.out.println("Este es el color blanco con R="+blanco.getR()+",G="+blanco.getG()+",B="+blanco.getB());
		
		//IMPRIMIMOS UN ARRAY DE COLORES
		for(int i=0;i<unArrayDeColores.length;i++){
			unColor=unArrayDeColores[i];
			System.out.println("Este es el color"+unColor.getNombre()+" con R="+unColor.getR()+",G="+unColor.getG()+",B="+unColor.getB());
		}
	}

}
